package study.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Num1912re {
    private static int n;
    private static int[] arr;
    public static void main(String[] args) throws IOException {
        init();
        int answer = dp(arr, 0, 0);
    }

    private static int dp(final int[] arr, int k, int sum) {
        // 지금 요소 합한 것과 합하지 않은 것을 각각 호출
        // 하나도 선택하지 않은 것은 제외한다.

//        int max = ;
        dp(arr, k + 1, sum + arr[k]);
        dp(arr, k + 1, 0);
        return 0;
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        String[] split = br.readLine().split(" ");
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(split[i]);
        }

    }
}
