package study.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Num1874 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] stack = new int[N+1];
        int top = 0;
        int nextNum;
        int k = 1;
        StringBuilder sb = new StringBuilder();
        while(N-- > 0){
            nextNum = Integer.parseInt(br.readLine());
            while(k <= nextNum){
                stack[top++] = k++;
                sb.append("+");
            }
            if(stack[--top] == nextNum){
                sb.append("-");
            }else{
                System.out.println("NO");
                break;
            }
        }
        if(N < 0){
            for(int i = 0; i < sb.length(); i++){
                System.out.println(sb.charAt(i));
            }
        }
    }
}
