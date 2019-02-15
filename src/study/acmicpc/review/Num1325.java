package study.acmicpc.review; // 효율적인 해킹

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Num1325 {
    private static int N, M;
    private static List<Integer>[] adj;
    private static List<Integer> answerList;

    public static void main(String[] args) throws IOException {
        init();
        int maxHackingCount = 1;
        for(int i = 1; i <= N; i++){
            int currentHackingCount = dfs(i, new boolean[N+1]);
            if(maxHackingCount < currentHackingCount){
                maxHackingCount = currentHackingCount;
                answerList.clear();
                answerList.add(i);
            }else if(maxHackingCount == currentHackingCount) answerList.add(i);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(answerList.get(0));
        for(int i = 1; i < answerList.size(); i++){
            sb.append(" " + answerList.get(i));
        }
        System.out.println(sb.toString());
    }

    private static int dfs(int currentComputer, boolean[] visited) {
        if(visited[currentComputer]) return 0;
        visited[currentComputer] = true;
        int ret = 0;
        for(Integer adjComputer : adj[currentComputer]){
            ret += dfs(adjComputer, visited);
        }
        return ret + 1;
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
            adj[B].add(A);
        }
        answerList = new LinkedList<>();
    }
}
