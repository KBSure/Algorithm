package study.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Num1463 {
    private static int[] cache;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        cache = new int[N+1];
        Arrays.fill(cache, -1);
        System.out.println(make1(N));
    }

    private static int make1(int n){
        if(n == 1) return 0;
        //cache
        int a = Integer.MAX_VALUE, b = Integer.MAX_VALUE, c = Integer.MAX_VALUE ;
        if(cache[n] != -1) return cache[n];
        if(n % 3 == 0) a = make1(n / 3) + 1;
        if(n % 2 == 0) b = make1(n / 2) + 1;
        c = make1(n - 1) + 1;
        int ret = Math.min(Math.min(a,b),c);
        cache[n] = ret;
        return ret;
    }
}
