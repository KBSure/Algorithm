package study.acmicpc.review; //Z

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Num1074 {
    private static int N;
    private static int r;
    private static int c;
    private static int answer;
    public static void main(String[] args) throws IOException {
        init();
        int count = counting(N, (int)Math.pow(2.0, N), 0, 0, 0);
        System.out.println(answer);
//        System.out.println(count);
    }

    private static int counting(int k, int length, int startR, int startC, int count) {
        if(answer != -1) return count;
        if(k == 0){
            if(startR == r && startC == c){
                answer = count;
                return count;
            }
            return count + 1;
        }
        int half = length / 2; // 2 ^ k-1
        count = counting(k-1, half, startR, startC, count); // count 갱신시켜주기
        count = counting(k-1, half, startR, startC+half, count);
        count = counting(k-1, half, startR+half, startC, count);
        count = counting(k-1, half,startR+half, startC+half, count);
        return count;
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        N = Integer.parseInt(split[0]);
        r = Integer.parseInt(split[1]);
        c = Integer.parseInt(split[2]);
        answer = -1;

    }
}
