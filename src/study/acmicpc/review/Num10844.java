package study.acmicpc.review; // 쉬운 계단 수

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Num10844 {
    private static int N;
    private static long[][] cache;
    private static final int NUMBER_SIZE = 10;
    private static final long DIVIDE_COUNT = 1_000_000_000;

    public static void main(String[] args) throws IOException {
        init();
        long answer = 0;
        for(int i = 1; i <= 9; i++){
            answer += (findStairNum(1, i) % DIVIDE_COUNT);
        }
        System.out.println(answer % DIVIDE_COUNT);
    }

    private static long findStairNum(int k, int currentNum) {
        if(currentNum < 0 || currentNum > 9) return 0;
        if(k == N) return cache[k][currentNum] = 1;
        if(cache[k][currentNum] != 0) return cache[k][currentNum];

        long ret = 0;
        ret += (findStairNum(k + 1, currentNum + 1) % DIVIDE_COUNT);
        ret += (findStairNum(k + 1, currentNum - 1) % DIVIDE_COUNT);

        return cache[k][currentNum] = (ret % DIVIDE_COUNT);
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        cache = new long[N+1][NUMBER_SIZE];
        for(int i = 0; i < N+1; i ++){
            cache[i] = new long[NUMBER_SIZE];
        }
    }
}
