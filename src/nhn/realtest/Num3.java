package nhn.realtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Num3 {
    private static int table1ColSize;
    private static int table2ColSize;
    private static StringBuilder header;
    private static Map<Integer, Row> idRowMap;
    private static List<Row> rowList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        header = new StringBuilder();
        header.append(br.readLine());

        idRowMap = new HashMap<>();
        rowList = new ArrayList<>();

        for(int i = 1; i < n; i++){
            String[] split = br.readLine().split(" ");
            table1ColSize = split.length;
            Row row = new Row(Integer.parseInt(split[0]), split);
            rowList.add(row);
            idRowMap.put(Integer.parseInt(split[0]), row);
        }

        int m = Integer.parseInt(br.readLine());
        String[] headerSplit = br.readLine().split(" ");
        table2ColSize = headerSplit.length;
        for(int i = 1; i < headerSplit.length; i++){
            header.append(" ").append(headerSplit[i]);
        }

        for(int i = 1; i < m; i++){
            String[] split = br.readLine().split(" ");
            int id = Integer.parseInt(split[0]);
            if(idRowMap.containsKey(id)){
                Row row = idRowMap.get(id);
                for(int j = 1; j < split.length; j++){
                    row.stringList.add(split[j]);
                }
            }
        }

        Collections.sort(rowList);

        StringBuilder sb = new StringBuilder();

        sb.append(header).append("\n");
        for(int i = 0; i < rowList.size(); i++){
            Row row = rowList.get(i);
            sb.append(row.id);
            for(int j = 0; j < row.stringList.size(); j++){
                sb.append(" ").append(row.stringList.get(j));
            }
            if(row.stringList.size() == table1ColSize - 1){
                for(int j = 0; j < table2ColSize - 1; j++){
                    sb.append(" ").append("NULL");
                }
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());

    }

    static class Row implements Comparable<Row>{
        int id;
        List<String> stringList;

        Row(int id, String[] strings){
            this.id = id;
            this.stringList = new ArrayList<>();
            for(int i = 1; i < strings.length; i++){
                this.stringList.add(strings[i]);
            }
        }

        @Override
        public int compareTo(Row o) {
            return this.id - o.id;
        }
    }
}
