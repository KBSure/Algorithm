package study.acmicpc.review; // 효율적인 해킹

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Num1325 {
    private static int N, M;
    private static List<Integer>[] adj;
    private static int[] answerArray;

    public static void main(String[] args) throws IOException {
        init();
        int maxHackingCount = 1;
        for(int i = 1; i <= N; i++){
            dfs(i, new boolean[N+1]);
        }

        for(int i = 1; i < answerArray.length; i++){
            if(maxHackingCount < answerArray[i]) maxHackingCount = answerArray[i];
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= N; i++){
            if(answerArray[i] == maxHackingCount) sb.append(i + " ");
        }
        System.out.println(sb.toString().trim());
    }

    private static void dfs(int currentComputer, boolean[] visited) {
        visited[currentComputer] = true;
        answerArray[currentComputer]++;
        for(Integer adjComputer : adj[currentComputer]){
            if(!visited[adjComputer]) dfs(adjComputer, visited);
        }
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        N = Integer.parseInt(split[0]);
        M = Integer.parseInt(split[1]);
        adj = new ArrayList[N+1];
        for(int i = 1; i < N+1; i++){
            adj[i] = new ArrayList<>();
        }
        for(int i = 0; i < M; i++){
            String[] line = br.readLine().split(" ");
            int A = Integer.parseInt(line[0]);
            int B = Integer.parseInt(line[1]);
            adj[A].add(B);
        }
        answerArray = new int[N+1];
    }
}
