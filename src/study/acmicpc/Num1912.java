package study.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Num1912 {
    private static int N;
    private static int[] A;
    private static int[] pSum;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        String[] split = br.readLine().split(" ");
        A = new int[N];
        pSum = new int[N];
        for(int i = 0; i < N; i++){
            A[i] = Integer.parseInt(split[i]);
            if(i == 0){
                pSum[i] = A[i];
                continue;
            }
            pSum[i] = pSum[i-1] + A[i];
        }

        System.out.println(maxSuccessiveSum());
    }

    private static int maxSuccessiveSum(){
        int maxSum = -1000;
        for(int i = 0; i < N; i++){
            for(int j = i; j < N; j++){
                maxSum = Math.max(maxSum, i == 0 ? pSum[j] : pSum[j] - pSum[i-1]);
            }
        }
        return maxSum;
    }
}
