package study.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Num1325 {
    private static List<Integer>[] adj;
//    private static int[] distance;
    private static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        int N = Integer.parseInt(split[0]);
        int M = Integer.parseInt(split[1]);
        adj = new ArrayList[N+1];
//        distance = new int[N+1]; //초기화 0
        visited = new boolean[N+1];
        for(int i = 1; i <= N; i++){
            adj[i] = new ArrayList<>();
        }
        for(int i = 0; i < M; i++){
            split = br.readLine().split(" ");
            adj[Integer.parseInt(split[1])].add(Integer.parseInt(split[0]));
        }

        int maxValue = 0;
        List<Integer> answerList = new ArrayList<>();
        for(int i = 1; i <= N; i++){
            Arrays.fill(visited, false);
                int cand = dfs(i);
                if(maxValue == cand) answerList.add(i);
                else if(maxValue < cand){
                    maxValue = cand;
                    answerList.clear();
                    answerList.add(i);
                }
        }

        for(int i = 0; i < answerList.size(); i++){
            if(i != 0) System.out.print(" ");
            System.out.print(answerList.get(i));
        }
    }

    private static int dfs(int here){
        if(visited[here]){
            return -1;
        }
        visited[here] = true;
        int there;
        if(adj[here].size() == 0) return 0;
//        if(distance[here] != 0) return distance[here]; //그냥 줘버리니까 양방향으로 신뢰있는 컴퓨터일 때 문제
        int max = 0;
        for(int i = 0; i < adj[here].size(); i++){
            there = adj[here].get(i);
            int distanceValue = dfs(there) + 1;
            if(max < distanceValue){
               max = distanceValue;
            }
        }
        return max;
    }
}
