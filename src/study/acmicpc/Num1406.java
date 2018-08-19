package study.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Num1406 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] split = br.readLine().split("");
        List<String> strList = new LinkedList<>();
        strList.addAll(Arrays.asList(split));

        int N = Integer.parseInt(br.readLine());

        int cursor = strList.size();

        for(int i = 0; i < N; i++){
            String[] split1 = br.readLine().split(" ");
            if(split1.length == 2){
                if("P".equals(split1[0])){
                    strList.add(cursor++, split1[1]);
                }
            }else{
                switch (split1[0]){
                    case "L":
                        if(cursor > 0) cursor--;
                        break;
                    case "D":
                        if(cursor < strList.size()) cursor++;
                        break;
                    case "B":
                        if(cursor > 0){
                            strList.remove(--cursor);
                        }
                        break;
                }
            }
        }
        strList.forEach(System.out::print);
    }
}
