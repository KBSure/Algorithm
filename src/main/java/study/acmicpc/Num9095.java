package study.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Num9095 {
    private static int[] cache;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int i = 0; i < T; i++){
            int n = Integer.parseInt(br.readLine());
            cache = new int[n+1];
            Arrays.fill(cache, -1);
            System.out.println(combi123(n));
        }
    }

    private static int combi123(int n){
        if(n == 0) return 1;
        if(n < 0) return 0;
        if(cache[n] != -1) return cache[n];
        int ret = combi123(n-1) + combi123(n-2) + combi123(n-3);
        cache[n] = ret;
        return ret;
    }
}
