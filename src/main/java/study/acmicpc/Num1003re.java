package study.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Num1003re {
    private static int[][] cache;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine());
        for(int i = 0; i < testcase; i++){
            int n = Integer.parseInt(br.readLine());
            cache = new int[n+1][3]; // size가 0이면 1 0 임
            int[] answer = fibonacci(n);
            System.out.println(answer[0] + " " + answer[1]);
        }
    }

    private static int[] fibonacci(int n){
        if(n == 1){
            return new int[]{0,1};
        }else if(n == 0){
            return new int[]{1,0};
        }

        if(cache[n][2] != 0) return cache[n];

        int[] cand1 = fibonacci(n-1);
        int[] cand2 = fibonacci(n-2);
        int[] ret = new int[]{cand1[0]+cand2[0], cand1[1]+cand2[1], 1};
        cache[n] = ret;
        return ret;
    }
}
