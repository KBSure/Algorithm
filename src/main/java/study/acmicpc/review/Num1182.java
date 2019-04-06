package study.acmicpc.review; //부분집합의 합

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Num1182 {
    private static int N;
    private static int S;
    private static int[] arr;
    public static void main(String[] args) throws IOException {
        init();
        int answer = findSubSet(arr, 0, 0, S);
        System.out.println(answer);
    }

    private static int findSubSet(int[] arr, int index, int sum, int S) {
        //공집합 제외 -> sum에 더하는 행위를 했을 때만 S와 비교
        if(index == arr.length) return 0;
        int ret = 0;
        if(sum + arr[index] == S){
            ++ret;
        }
        ret += findSubSet(arr, index + 1, sum + arr[index], S);
        ret += findSubSet(arr, index + 1, sum, S);
        return ret;
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        N = Integer.parseInt(split[0]);
        arr = new int[N];
        S = Integer.parseInt(split[1]);
        String[] split1 = br.readLine().split(" ");
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(split1[i]);
        }

    }
}
