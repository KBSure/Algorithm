package study.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Num2292 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int add = 1;
        int start = 1;
        int k = 1;

        while(n >= start + add){
            start += add;
            add = (++k-1)*6;
        }
        System.out.println(k);
    }
}
