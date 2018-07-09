package study.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Num1260 {
    private static int numV;
    private static int numE;
    private static int startV;
    private static List<Integer>[] adj;
    private static boolean[] visited;
    public static void main(String[] args) throws IOException {
        init();
        dfs(startV);
    }

    private static void dfs(int here){
        visited[here] = true;
        System.out.println(here);
        for(int i = 0; i < adj[here].size(); i++){
            int there = adj[here].get(i);
            if(!visited[there]) dfs(there);
        }
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] row = br.readLine().split(" ");
        numV = Integer.parseInt(row[0]);
        numE = Integer.parseInt(row[1]);
        startV = Integer.parseInt(row[2]);
        adj = new ArrayList[1001];
        visited = new boolean[1001];

        for(int i = 1; i <= numV; i++){
            adj[i] = new ArrayList<>();
        }
        for(int i = 0; i < numE; i++){
            //앞 기준으로 넣고 뒤 기준으로 넣고
            row = br.readLine().split(" ");
            int v1 = Integer.parseInt(row[0]);
            int v2 = Integer.parseInt(row[1]);
            adj[v1].add(v2);
            adj[v2].add(v1);
        }
        for(int i = 1; i <= numV; i++){
            Collections.sort(adj[i]);
        }
    }
}
