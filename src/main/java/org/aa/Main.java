package org.aa;

import org.aa.drug.*;
import org.aa.util.Misc;
import org.aa.util.file.Folder;
import org.aa.util.timer.ElapsedTimeCounter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.Package;
import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Main {

    public static void main(String[] args) throws IOException {
        ElapsedTimeCounter.setTimer("main");
        String csvFile = Statics.drug_Path_ROOT;
        Set<String> files = Folder.listFilesForFolderv8(csvFile);
        Set<String> files2 = files.stream().filter(name -> name.endsWith(".txt")).collect(Collectors.toSet());

        Map<String,List<List<String>>> dataMap=new HashMap<String,List<List<String>>>();

        files2.stream().forEach(filePath -> {
            try {
                Scanner scanner = new Scanner(new File(filePath));
                int lineCount=-1;
                List<List<String>> dataList=new ArrayList<List<String>>();
                while (scanner.hasNext()) {
                    List<String> line = parseLine(scanner.nextLine());
                    lineCount++;
                    if(lineCount==0){
                        //headerMap.put(filePath, line);
                        //continue;
                    }
                    dataList.add(line);
                   // Misc.print(line);
                }
                dataMap.put(filePath, dataList);
                scanner.close();

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

        });

        //dataMap.forEach((k,v) -> System.out.println("For File "+k+" Count "+v.size()));
        Map<String,List<List<String>>> trimmedDataMap=new HashMap<String,List<List<String>>>();
        dataMap.forEach((k,v) -> trimmedDataMap.put(k.substring(k.lastIndexOf("\\")+1,k.lastIndexOf(".txt")),v));
        //Misc.print(trimmedDataMap.entrySet().size());
        //trimmedDataMap.forEach((k,v) -> System.out.println("For File "+k+" Count "+v.size()));
        Pattern pattern = Pattern.compile(",");
       // Misc.print(pattern.split(Statics.CSV_HEADER_DRUG));
        Map<String,List<String>> headerMap=populateHeader(trimmedDataMap.keySet());
       // headerMap.forEach((k,v) -> System.out.println("For File "+k+" Count "+v.size()));

        /*
        convert to the key and its hashmap with header as keys
        * key List<Map<String,String>>
        * */
        Map<String,List<Map<String, String>>>  finalMap=trimmedDataMap.keySet().stream().collect(Collectors.toMap(key->key,key->loadDataMap(key,headerMap.get(key),trimmedDataMap.get(key))));

        /*
         * convert the held map to object
         */
        //TODO CORRECT THIS CODE touch
        /*finalMap.keySet().stream().collect(Collectors.toMap(key->key,key->{
            transform2Object(finalMap.get(key),getClass2Map(key));
        }));
*/




        //Misc.print(finalMap);
       /*
        CsvSchema orderLineSchema = CsvSchema.emptySchema();
        CsvMapper csvMapper = new CsvMapper();
        MappingIterator<OrderLine> orderLines = csvMapper.readerFor(OrderLine.class)
                .with(orderLineSchema)
                .readValues(new File("src/main/resources/orderLines.csv"));
        */
        ElapsedTimeCounter.getTimeEllapsedInSec("main");

    }

    private static Class getClass2Map(String key) {
        Class className = null;
        switch(key){
            case "package":
                className=Package.class;
                break;
            case "ther":
                className= TherDrug.class;
                break;
            case "route":
                className= Route.class;
                break;
            case "drug":
                className= Drug.class;
                break;
            case "form":
                className= DrugForm.class;
                break;
            case "ingred":
                className= Ingredient.class;
                break;
            case "vet":
                className=VetDrug.class;
                break;
            case "schedule":
                className=Schedule.class;
                break;
            case "pharm":
                className=PharmaStd.class;
                break;
            case "status":
                className=Status.class;
                break;
            case "comp":
                className=MfgCompany.class;
                break;
        }
        return className;

    }

    private static <T> List<T > transform2Object(List<Map<String, String>> maps, Class<T> classType) {

       /* maps.stream().collect(Collectors.toList(m -> {

            ObjectMapper mapper = new ObjectMapper();
            //return mapper.convertValue(m, classType);
            return null;
        } ));*/
return null;
    }

    /**
     * dataPoint.stream().collect(Collectors.toMap(d-> {
     *                         Misc.print(d+" : "+dataPoint.indexOf(d)+" : "+headers.get(dataPoint.indexOf(d)));
     *                         return headers.get(dataPoint.indexOf(d));
     *                     } ,d->d));
     *                     dataMap.add(dMap);
     * @param key
     * @param headers
     * @param data
     * @return
     */
    private static List<Map<String, String>> loadDataMap(String key,List<String> headers, List<List<String>> data) {
        //Misc.print(key);
        List<Map<String, String>> dataMap=new ArrayList<>();
        data.stream().forEach(dataPoint -> {
                    Map<String, String> dMap= IntStream.range(0,dataPoint.size()).collect(HashMap::new,
                                                                                          (m,i) -> m.put(headers.get(i),dataPoint.get(i)),
                                                                                           Map::putAll
                                                                                           );
                    dataMap.add(dMap);
        }
        );


        return dataMap;
    }

    /**
     * List<List<String>> vals= keys.stream().map(key -> parseLine(getHeaderLine(key))).collect(Collectors.toList());
     *
     * @param keys
     * @return
     */
    private static Map<String, List<String>> populateHeader(Set<String> keys) {
        //Misc.print("...populateHeader");
        //Misc.print(keys);
        //List<List<String>> vals= keys.stream().map(key -> parseLine(getHeaderLine(key))).collect(Collectors.toList());
        Map<String, List<String>> headerMap= keys.stream().collect(Collectors.toMap(key -> key, key -> parseLine(getHeaderLine( key))));
        keys.stream().collect(Collectors.toMap(key -> key,key -> key));
        return headerMap;
    }

    private static String getHeaderLine(String key) {
        String headerline="";
        switch(key){
            case "package":
                headerline=Statics.CSV_HEADER_PACKAGE;
                break;
            case "ther":
                headerline=Statics.CSV_HEADER_THER;
                break;
            case "route":
                headerline=Statics.CSV_HEADER_ROUTE;
                break;
            case "drug":
                headerline=Statics.CSV_HEADER_DRUG;
                break;
            case "form":
                headerline=Statics.CSV_HEADER_FORM;
                break;
            case "ingred":
                headerline=Statics.CSV_HEADER_INGRED;
                break;
            case "vet":
                headerline=Statics.CSV_HEADER_VET;
                break;
            case "schedule":
                headerline=Statics.CSV_HEADER_SCHEDULE;
                break;
            case "pharm":
                headerline=Statics.CSV_HEADER_PHARM;
                break;
            case "status":
                headerline=Statics.CSV_HEADER_STATUS;
                break;
            case "comp":
                headerline=Statics.CSV_HEADER_COMP;
                break;
        }
        return headerline;
    }


    public static List<String> parseLine(String cvsLine) {
        return parseLine(cvsLine, Statics.DEFAULT_SEPARATOR, Statics.DEFAULT_QUOTE);
    }
    public static List<String> parseLine(String cvsLine, char separators) {
        return parseLine(cvsLine, separators, Statics.DEFAULT_QUOTE);
    }
    public static List<String> parseLine(String cvsLine, char separators, char customQuote) {

        List<String> result = new ArrayList<>();

        //if empty, return!
        if (cvsLine == null && cvsLine.isEmpty()) {
            return result;
        }

        if (customQuote == ' ') {
            customQuote = Statics.DEFAULT_QUOTE;
        }

        if (separators == ' ') {
            separators = Statics.DEFAULT_SEPARATOR;
        }

        StringBuffer curVal = new StringBuffer();
        boolean inQuotes = false;
        boolean startCollectChar = false;
        boolean doubleQuotesInColumn = false;

        char[] chars = cvsLine.toCharArray();

        for (char ch : chars) {

            if (inQuotes) {
                startCollectChar = true;
                if (ch == customQuote) {
                    inQuotes = false;
                    doubleQuotesInColumn = false;
                } else {

                    //Fixed : allow "" in custom quote enclosed
                    if (ch == '\"') {
                        if (!doubleQuotesInColumn) {
                            curVal.append(ch);
                            doubleQuotesInColumn = true;
                        }
                    } else {
                        curVal.append(ch);
                    }

                }
            } else {
                if (ch == customQuote) {

                    inQuotes = true;

                    //Fixed : allow "" in empty quote enclosed
                    if (chars[0] != '"' && customQuote == '\"') {
                        curVal.append('"');
                    }

                    //double quotes in column will hit this!
                    if (startCollectChar) {
                        curVal.append('"');
                    }

                } else if (ch == separators) {

                    result.add(curVal.toString());

                    curVal = new StringBuffer();
                    startCollectChar = false;

                } else if (ch == '\r') {
                    //ignore LF characters
                    continue;
                } else if (ch == '\n') {
                    //the end, break!
                    break;
                } else {
                    curVal.append(ch);
                }
            }

        }

        result.add(curVal.toString());

        return result;
    }
}
