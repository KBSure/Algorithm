package study.acmicpc.review; //리모컨

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Num1107 {
    private static int N;
    private static int M;
    private static boolean[] buttons;
    public static void main(String[] args) throws IOException {
        init();
        int max = Math.abs(N - 100);
        int answer = Integer.MAX_VALUE;
        for(int i = 0; i < max; i++){
            int count = Math.min(countPushButton(N + i), countPushButton(N - i));
            if(count != Integer.MAX_VALUE){
                answer = i + count;
                break;
            }
        }
        System.out.println(answer > max ? max : answer);
    }

    private static int countPushButton(int number) {
        if(number < 0) return Integer.MAX_VALUE;
        if(number == 0){
            if(buttons[0]) return 1;
            return Integer.MAX_VALUE;
        }
        int count = 0;
        while(number > 0){ // N이 0일때는?
            int num = number % 10;
            if(!buttons[num]) return Integer.MAX_VALUE;
            count++;
            number /= 10;
        }
        return count;
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        buttons = new boolean[10];
        Arrays.fill(buttons, true);
        if(M == 0) return;
        String[] split = br.readLine().split(" ");
        for(int i = 0; i < M; i++){
            int broken = Integer.parseInt(split[i]);
            buttons[broken] = false;
        }
    }

}
