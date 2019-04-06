package study.acmicpc.review; //순열 사이클

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Num10451 {
    private static BufferedReader br;
    private static int testCase;
    private static int N;
    private static int[] arr;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        testCase = Integer.parseInt(br.readLine());
        for(int i = 0; i < testCase; i++){
            init();
            int answer = 0;
            for(int j = 1; j < N+1; j++){
                if(!visited[j]){
                    traversal(arr, j, visited);
                    answer++;
                }
            }
            System.out.println(answer);
        }
    }

    private static void traversal(int[] arr, int i, boolean[] visited) {
        while(!visited[i]){
            visited[i] = true;
            i = arr[i];
        }
    }

    private static void init() throws IOException {
        N = Integer.parseInt(br.readLine());
        arr = new int[N+1]; // index 0 안씀
        String[] split = br.readLine().split(" ");
        for(int i = 0; i < N; i++){
            arr[i+1] = Integer.parseInt(split[i]);
        }
        visited = new boolean[N+1];
    }
}
