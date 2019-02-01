package study.acmicpc.review; // 부분집합의 합

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Num1182re {
    private static int N;
    private static int S;
    private static int[] arr;
    private static int answer;
    public static void main(String[] args) throws IOException {
        init();
        findSubSet(arr, 0, 0, S);
        System.out.println(answer);
    }

    private static void findSubSet(int[] arr, int index, int sum, int S) {
        if(sum + arr[index] == S) answer++;
        if(index == arr.length - 1) return;
        findSubSet(arr, index + 1, sum + arr[index], S);
        findSubSet(arr, index + 1, sum, S);
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        N = Integer.parseInt(split[0]);
        S = Integer.parseInt(split[1]);
        arr = new int[N];
        String[] split1 = br.readLine().split(" ");
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(split1[i]);
        }
    }
}
