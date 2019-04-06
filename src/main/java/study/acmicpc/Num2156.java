package study.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Num2156 {
    private static int N;
    private static int[] A;
    public static void main(String[] args) throws IOException {
        init();
        System.out.println(Math.max(recursion(0,1), Math.max(recursion(1, 2), recursion(2, 3))));
    }

    private static int recursion(int i, int k){
        if(i > N || i - k + 1 < 0) return 0;
        int ret = 0;
        for(int j = i - k + 1; j < i; j++){
            ret += A[j];
        }

        ret += Math.max(recursion(i + k, 1), Math.max(recursion(i + k, 2), recursion(i + k, 3)));
        return ret;
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        A = new int[N];
        for(int i = 0; i < N; i++){
            A[i] = Integer.parseInt(br.readLine());
        }
    }
}
