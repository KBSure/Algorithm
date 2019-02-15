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
    private static int[] distance;
    private static List<Integer> answerList;

    public static void main(String[] args) throws IOException {
        init();
        int maxHackingCount = 1;
        for(int i = 1; i <= N; i++){
            int currentHackingCount = dfs(i);
            if(maxHackingCount < currentHackingCount){
                maxHackingCount = currentHackingCount;
                answerList.clear();
                answerList.add(i);
            }else if(maxHackingCount == currentHackingCount) answerList.add(i);
        }
        System.out.print(answerList.get(0));
        for(int i = 1; i < answerList.size(); i++){
            System.out.print(" " + answerList.get(i));
        }
    }

    private static int dfs(int currentComputer) {
        if(distance[currentComputer] != 0) return distance[currentComputer];
        int ret = 0;
        for(Integer adjComputer : adj[currentComputer]){
            ret += Math.max(ret, dfs(adjComputer));
        }
        return distance[currentComputer] = ret + 1;
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
        distance = new int[N+1];
        answerList = new LinkedList<>();
    }
}
