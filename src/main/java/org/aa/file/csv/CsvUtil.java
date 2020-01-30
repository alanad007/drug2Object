package org.aa.file.csv;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvUtil {

    public static List<String[]> convertCsvFile(String filename,String token,boolean parseFirstLine) throws IOException {
        List<String[]> csvKeys=new ArrayList<String[]>();
        BufferedReader br = new BufferedReader(new FileReader(filename));
        String line = "";
        token=token.equals("")?",":token;
        int lncCnt=0;
        while ((line = br.readLine()) != null) {

            if(lncCnt==0 && !parseFirstLine)

            {
                lncCnt++;
                continue;
            }
            lncCnt++;
            String[] keys = line.split(token);
            csvKeys.add(keys);
        }
        return csvKeys;
    }

    public static List<String[]> convertCsvFile(String filename,boolean parseFirstLine) throws IOException {
        return convertCsvFile(filename,",",parseFirstLine);
    }


    public static List<String[]> convertCsvFile(String filename) throws IOException {
        return convertCsvFile(filename,",",false);
    }


    public static String removeEnclosures(String str,String closure)
    {
        String prfStripped=str.startsWith(closure)?str.substring(closure.length(),str.length()):str;
        String suffixStripped=str.endsWith(closure)?prfStripped.substring(0, (prfStripped.length()-(closure.length()))):prfStripped;
        return suffixStripped;
    }


    public static String[] removeEnclosures(String[] keys, String closure) {
        //Misc.print(keys);
        for (int index =0; index < keys.length; index++){
            keys[index] = removeEnclosures(keys[index], closure);
        }

        //Misc.print(keys);
        return keys;
    }
}
