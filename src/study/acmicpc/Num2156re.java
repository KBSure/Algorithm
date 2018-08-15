package study.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Num2156re {
    private static int N;
    private static int[] A;
    private static int[][] cache;
    public static void main(String[] args) throws IOException {
        init();
        System.out.println(recursion(-1,-1));
    }

    private static int recursion(int i, int k){
        if(i >= N) return 0;
        if(k == 2) return 0;
        int ret = 0;
        if(i >= 0){
            if(cache[i+1][k+1] != -1) return cache[i+1][k+1];
            ret = A[i];
        }
        ret += Math.max(recursion(i + 1, k + 1), Math.max(recursion(i + 2, 0), recursion(i + 3, 0)));
        cache[i+1][k+1] = ret;
        return ret;
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        A = new int[N];
        for(int i = 0; i < N; i++){
            A[i] = Integer.parseInt(br.readLine());
        }
        cache = new int[N+1][3];
        for(int i = 0; i < N+1; i++){
            for(int j = 0; j < 3; j++){
                cache[i][j] = -1;
            }
        }
    }
}
