package study.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Num2839 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        System.out.println(minSugarPack(N));
    }

    private static int minSugarPack(int n){
        int remainder = 0; //
        int k = -1;
        while(remainder >= 0)
            if((remainder = n - 3*++k) % 5 == 0) return k + remainder / 5;
        return -1;
    }
}
