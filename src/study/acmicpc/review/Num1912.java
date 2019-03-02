package study.acmicpc.review; // 연속합

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Num1912 {
    private static int n;
    private static int[] arr;
    private static int max;
    private static int negativeMax = Integer.MIN_VALUE;
    private static int current;
    public static void main(String[] args) throws IOException {
        init();

        for(int i = 0; i < n; i++){
            int temp = current + arr[i];
            if(temp >= 0)
                current = temp;
            else
                current = 0;
            max = Math.max(max, current);
            if(negativeMax < 0)
                negativeMax = Math.max(negativeMax, arr[i]);
        }

        if(current == 0 && max == 0) max = negativeMax;

        System.out.println(max);

        // 현재값을 수정 (그 전에 현재값이 0이였는데 음수를 안 만났다면 현재값 갱신)
        // 최대값과 비교해서 최대값 반영

        // 단, 음수를 만나면 현재값 0으로 셋팅하고, 인덱스 업
        // 마지막 인덱스 때 최대값 출력

        // 단, 모두 음수라면 가장 최대값 출력

    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        String[] split = br.readLine().split(" ");
        arr = new int[n];
        for(int i = 0; i < n; i ++){
            arr[i] = Integer.parseInt(split[i]);
        }
    }
}
