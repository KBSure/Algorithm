package study.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//쉬운 계단 수
public class Num10844 {
    private static int N;
    private static long[][] cache;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); // 1 <= N <= 100
        cache = new long[10][N+1];
        for(int i = 0; i < 10; i++){
            for(int j = 0; j < N+1; j++){
                cache[i][j] = -1;
            }
        }
        long result = 0;
        for(int i = 1; i <= 9; i++){
            result += findAnswer(i, N);
        }
        System.out.println(result % 1000000000);
    }
    private static long findAnswer(int k, int n){
        if(k < 0 || k > 9) return 0;
        if(n - 1 == 0) return 1;
        if(cache[k][n] != -1) return cache[k][n];
        long ret = findAnswer(k - 1, n - 1) + findAnswer(k + 1, n - 1);
        if(ret > 1000000000) ret -= 1000000000;
        cache[k][n] = ret;
        return ret;
    }
}
