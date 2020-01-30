package org.aa.util.file;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import org.aa.util.Misc;

public class Folder {
	

/**
 * JDk 7 and below
 * 
 * Usage 
		final File folder = new File("/home/you/Desktop");
		listFilesForFolder(folder);
 * @param folder
 */
public static  Set<String> listFilesForFolder(final String folder) {
    Set<String> filePaths=new HashSet<String>();  
	for (final File fileEntry : (new File(folder)).listFiles()) {
        if (fileEntry.isDirectory()) {
            listFilesForFolder(fileEntry.getAbsolutePath());
        } else {
            Misc.print(fileEntry.getAbsolutePath());
            filePaths.add(fileEntry.getAbsolutePath());
        }
    }
	return filePaths;
}


/**
 * JDk 8+
 * 
 * Usage 
		final File folder = new File("/home/you/Desktop");
		listFilesForFolder(folder);
 * @param folder
 * @throws IOException 
 */
public static Set<String> listFilesForFolderv8(final String folder) throws IOException {
	Set<String> filePaths=new HashSet<String>();
	try(Stream<Path> paths = Files.walk(Paths.get(folder))) {
	    paths.forEach(filePath -> {
	        if (Files.isRegularFile(filePath)) {
	            //print(filePath);
	            filePaths.add(filePath.toString());
	        }
	    });
	}
	return filePaths;
}



static String ArchiveFolder="archive";

/**
 * Moves Files from a folder to a target folder
 * @param folderFrom
 * @param folderTarget
 * @param appendtargetPathToFrom
 * @throws IOException
 */
public static void moveFilesFromFolder(final String folderFrom,final String folderTarget,boolean appendtargetPathToFrom,boolean ignoreArchive) throws IOException
{
	Set<String> files= Folder.listFilesForFolderv8(folderFrom);
	for(String file:files)
	{
		
		if(ignoreArchive && file.contains(ArchiveFolder)) continue;
		print(file);
		String remnantPath= file.substring(folderFrom.length());
		print(remnantPath);
		File afile =new File(file);
		//afile.toPath()
		Files.move(afile.toPath(),afile.toPath().resolve((appendtargetPathToFrom?folderFrom+folderTarget:folderTarget)+remnantPath ) ,StandardCopyOption.REPLACE_EXISTING);
		print(afile.getName()+"   :   "+(appendtargetPathToFrom?folderFrom+folderTarget:folderTarget) + afile.getName());
 	   if(afile.renameTo(new File(appendtargetPathToFrom?folderFrom+folderTarget:folderTarget + afile.getName())))
 	   {
 		System.out.println("File is moved successful!");
 	   }else{
 		System.out.println("File is failed to move!");
 	   }
	}
	
}

public static void copyFilesFromFolder(String fromDirectory, String ToDirectory) throws IOException {

	Files.copy(new File(fromDirectory).toPath(), new File(ToDirectory).toPath());
	
}

private static void print(Object obj) {
	Misc.print(obj);
}

/**
 * returns the number of Lines in a file
 * @param filename
 * @return
 * @throws IOException 
 */
public static Long getNumberOfLines(String filename) throws IOException {
 
	return getNumberOfLines(new File(filename));
	
}

/**
* returns the number of Lines in a file
 * 
 * @param file
 * @return
 * @throws IOException
 */
private static Long getNumberOfLines(File file) throws IOException {
	if(file.exists())
	{
		long linenumber = 0;
		FileReader fr = new FileReader(file);
	    LineNumberReader lnr = new LineNumberReader(fr);
	    while (lnr.readLine() != null){
        	linenumber++;
            }
         lnr.close();
         return linenumber;
	}
	return null;
}

	public static List<File> getTextFilesFromUpload(String path)
	{
		File f = new File(path);
		FilenameFilter textFilter = new FilenameFilter() {
			public boolean accept(File dir, String name) {
				return name.toLowerCase().endsWith(".txt");
			}
		};
		List<File> filesLst=new ArrayList<>();
		File[] files = f.listFiles(textFilter);
		for (File file : files) {
			if (file.isDirectory()) {

			} else {
				filesLst.add(file);
			}

		}
		return filesLst;
	}

	public static boolean moveFile(final String source, final String target) {
		File sourceFile = new File(source);

		File targetFile = new File(target);
		// delete file if already exists so that move will succeed
		if (targetFile.exists()) {
			targetFile.delete();
		}
		if(sourceFile.exists()){
			System.out.println("yes");
		}
		boolean success = sourceFile.exists()?sourceFile.renameTo(targetFile):false;

		if (!success) {
			String errorMessage =  "Error moving files from "+source+" to "+ target ;

		}
		return success;
	}


}
