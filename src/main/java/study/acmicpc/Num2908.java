package study.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Num2908 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        String A =  split[0];
        String B = split[1];
        boolean isAnswerA = true;
        for(int i = A.length()-1; i >= 0; i--){
            if(A.charAt(i) > B.charAt(i)) break;
            if(A.charAt(i) < B.charAt(i)){
                isAnswerA = false;
                break;
            }
        }
        String answer = isAnswerA ? A : B;
        for(int i = A.length()-1; i >= 0; i--){
            System.out.print(answer.charAt(i));
        }
    }
}
