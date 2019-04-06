package study.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Num2011 {
    private static int[] A;
    private static int N;
    private static int[][] cache;
    public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String[] split = br.readLine().split("");
            N = split.length;
            A = new int[N];
            for (int i = 0; i < N; i++) {
                A[i] = Integer.parseInt(split[i]);
            }
            cache = new int[N][2];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < 2; j++) {
                    cache[i][j] = -1;
                }
            }

            System.out.println((howMany(0, 1) + howMany(0, 2)) % 1000000);
    }

    private static int howMany(int i, int k){
        if(cache[i][k-1] != -1) return cache[i][k-1];
        if(i > N-1) return 0;
        if(k == 1){
            if(A[i] == 0){
                return 0;
            }else{
                if(i == N-1) return 1;
            }
        }
        if(k == 2){
            if(i + 1 > N - 1) return 0;
            if(A[i] != 1){
                if(A[i] != 2){
                    return 0;
                }else{
                    if(A[i+1] > 6 || A[i+1] < 0){
                        return 0;
                    }
                }
            }
            if(i+1 == N-1) return 1;
        }
        int ret = howMany(i + k, 1) + howMany(i + k, 2) % 1000000;
        cache[i][k-1] = ret;
        return ret;
    }
}
