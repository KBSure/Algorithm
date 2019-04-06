package study.acmicpc; //2007년

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Num1924 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        int x = Integer.parseInt(split[0]);
        int y = Integer.parseInt(split[1]);
        int[] arr = {0,31,28,31,30,31,30,31,31,30,31,30,31};
        String[] answerArr = {"SUN","MON","TUE","WED","THU","FRI","SAT"};
        int day = y;
        for(int i = 0; i < x; i++){
            day += arr[i];
        }
        System.out.println(answerArr[day%7]);
    }
}
