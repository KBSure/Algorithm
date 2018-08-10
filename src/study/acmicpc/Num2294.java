package study.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Num2294 {
    private static int[] A;
    private static int N, K;
    private static int[][] cache;
    private static final int MAX_RESULT = 10000;
    public static void main(String[] args) throws IOException {
        init();
        int result = MAX_RESULT + 1;
        for(int i = 0; i < N; i++){
            result = Math.min(result, countCoin(K, i));
        }
        System.out.println(result > MAX_RESULT ? -1 : result);
    }

    private static int countCoin(int k, int indexN){ //k는 합, indexN은 동전인덱스
        if(k == 0) return 0;
        if(k < 0) return MAX_RESULT;
        if(cache[k][indexN] != -1) return cache[k][indexN];

        int ret = MAX_RESULT+1;
        for(int i = 0; i < N; i++){
            ret = Math.min(ret, countCoin(k - A[indexN], i) + 1);
        }
        cache[k][indexN] = ret;
        return ret;
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");

        N = Integer.parseInt(split[0]);
        K = Integer.parseInt(split[1]);

        cache = new int[K+1][N];
        for(int i = 0; i < K+1; i++){
            for(int j = 0; j < N; j++){
                cache[i][j] = -1;
            }
        }

        A = new int[N];
        for(int i = 0; i < N; i++){
            A[i] = Integer.parseInt(br.readLine());
        }
    }
}
