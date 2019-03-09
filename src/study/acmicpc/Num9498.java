package study.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Num9498 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        if(n >= 90){
            System.out.println("A");
            return;
        }else if(n >= 80){
            System.out.println("B");
            return;
        }else if(n >= 70){
            System.out.println("C");
            return;
        }else if(n >= 60){
            System.out.println("D");
            return;
        }
        System.out.println("F");
    }
}
