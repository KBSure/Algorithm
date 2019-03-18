package nhn.realtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Num2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        int index = -1;

        String[] elements = new String[21];
        int elementIdx = 0;
        String[] numbers = new String[21];
        int numberIdx = 0;
        for(int i = 0; i < s.length() - 1; i++){
            char here = s.charAt(i);
            char next = s.charAt(i+1);
            if(here >= 'A' && here <='Z'){
                if(next >= 'A' && next <= 'Z'){
                    elements[elementIdx++] = String.valueOf(here);
                    elements[elementIdx++] = String.valueOf(next);
                    i++;
                }else if(next >= 'a' && next <= 'z'){
                    elements[elementIdx++] = String.valueOf(here) + String.valueOf(next); // 검토
                    i++;
                }else{
                    elements[elementIdx++] = String.valueOf(here);
                }
            } else if(here >= '1' && here <= '9'){
                if(here == '1' && next == '0'){
                    numbers[numberIdx++] = String.valueOf(here) + String.valueOf(next);
                    i++;
                }else{
                    numbers[numberIdx++] = String.valueOf(here);
                }
            }
        }

        if(s.charAt(s.length()-1) != '0') numbers[numberIdx++] = String.valueOf(s.charAt(s.length()-1)); //마지막 예외처리

        StringBuilder sb = new StringBuilder();

        if(elementIdx == numberIdx){
            for(int i = 0; i < elementIdx; i++){
                sb.append(elements[i]);
                if(!"1".equals(numbers[i]))
                    sb.append(numbers[i]);
            }
            System.out.println(sb.toString());
        }else{
            System.out.println("error");
        }


    }
}
