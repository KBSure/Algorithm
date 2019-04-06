package study.acmicpc.review; // 1로 만들기
// stackoverflow 때문에 top-down 사용하면 안된다. queue를 사용해서 최소 값 구한 뒤 조기 종료 하거나
// bottom-up dp 사용

// 조건 추가로 깊이를 줄여보려고 했다가 실패했다. 애초에 깊이 끝까지 갈 필요가 없는 bfs가 정답.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Num1463 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int answer = dp(0, N, new int[1_000_001]);
        System.out.println(answer);
//        for(int i = 1; i < 10000; i++) {
//            int answer = dp(0, i, new int[1_000_001]);
//            int answer2 = dp2(i, new int[1_000_001]);
//            if(answer != answer2)
//             System.out.println("i : " + i + " answer : " + answer + " answer2 : " + answer2);
//        }

//        int[] cache = new int[1_000_001];
//        int[] cache2 = new int[1_000_001];
//        int answer = dp(0, 321, cache);
//        int answer2 = dp2(321, cache2);
//
//        for(int i = 0; i < 1_000_001; i++){
//            if(cache[i] != 0) System.out.print(" " + i + ":" + cache[i]);
//        }
//        System.out.println();
//        System.out.println("------------------------------");
//        for(int i = 0; i < 1_000_001; i++){
//            if(cache2[i] != 0) System.out.print(" " + i + ":" + cache2[i]);
//
//        }

    }

    private static int dp(int subCnt, int k, final int[] cache) {
        if(k == 1) return 0;
        if(cache[k] != 0) return cache[k];

        int minCount = Integer.MAX_VALUE;
        // 나눠떨어질 때는 -1하지 않는다.
        // 최대 2번 정도 빼보면 3으로 나눌 수 있다. 2로도 나눌 수 있다.
        if(k % 3 == 0) minCount = Math.min(minCount, dp(0, k / 3, cache));
        if(k % 2 == 0) minCount = Math.min(minCount, dp(0, k / 2, cache));
        minCount = Math.min(minCount, dp(subCnt + 1, k - 1, cache));
        return cache[k] = minCount + 1;
    }
//    private static int dp2(int k, final int[] cache) {
//        if(k == 1) return 0;
//        if(cache[k] != 0) return cache[k];
//
//        int minCount = Integer.MAX_VALUE;
//        // 나눠떨어질 때는 -1하지 않는다.
//        // 최대 2번 정도 빼보면 3으로 나눌 수 있다. 2로도 나눌 수 있다.
//        if(k % 3 == 0) minCount = Math.min(minCount, dp2(k / 3, cache));
//        if(k % 2 == 0) minCount = Math.min(minCount, dp2(k / 2, cache));
//        minCount = Math.min(minCount, dp2(k - 1, cache));
//        return cache[k] = minCount + 1;
//    }
}
