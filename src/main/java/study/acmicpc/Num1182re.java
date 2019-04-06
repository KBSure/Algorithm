package study.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Num1182re {
    static int result = 0;

    private static int N;
    private static int S;
    private static int[] integerArray;
    private static LinkedList<Integer> indexList;
    private static int count;

    public static void main(String[] args) throws Exception {

        init();

        findAns(integerArray, S, 0, 0);

        System.out.println(result);

    }

    public static void findAns(int[] nums, int S, int nowVal, int index) {

        if (nowVal + nums[index] == S) {
            result++;
        }

        if (index == nums.length - 1) {
            return;
        } else {
            findAns(nums, S, nowVal, index + 1);
            findAns(nums, S, nowVal + nums[index], index + 1);
        }

    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] firstLineSplit = br.readLine().split(" ");
        S = Integer.parseInt(firstLineSplit[1]);
        N = Integer.parseInt(firstLineSplit[0]);
        integerArray = new int[N];

        String[] integerSplit = br.readLine().split(" ");
        for(int i = 0; i < N; i++){
            integerArray[i] = Integer.parseInt(integerSplit[i]);
        }

        indexList = new LinkedList<>();
    }

}
