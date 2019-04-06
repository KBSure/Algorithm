package study.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Num11729 {
    private static int N;
    public static void main(String[] args) throws IOException {
        init();
        System.out.println((int)Math.pow(2, N)-1);
        findStep(N, 1,2,3);
    }

    private static void findStep(int step, int start, int middle, int end){
        if(step == 1){
            System.out.println(start + " " + end);
            return;
        }

        findStep(step-1, start, end, middle);
        System.out.println(start + " " + end);
        findStep(step-1, middle, start, end);
    }


    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
    }
}
