package study.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Num10451 {
    private static int testCase;
    private static int[][] adj; //[i][0]은 1차배열의 요소수
    private static boolean[][] visited; //[i][0]은 신경쓰지 않는다.
    public static void main(String[] args) throws IOException {
        init();
        //사이클이 몇 개 생기는지 = dfsAll이 dfs()를 몇 번 호출하는지
        for(int i = 0; i < testCase; i++){
            System.out.println(dfsAll(i));
        }
    }

    private static int dfs(int testNum, int here){
        visited[testNum][here] = true;
        int there = adj[testNum][here];

        if(!visited[testNum][there]) {
            return dfs(testNum, there);
        }else{
            return there;
        }
    }

    private static int dfsAll(int testNum){
        //node 마다
        int cycleCount = 0;
        for(int i = 1; i <= adj[testNum][0]; i++){
            if(!visited[testNum][i] && dfs(testNum, i) == i) cycleCount++; //처음 방문했떤 i노드를 방문 앞두고 dfs() 끝났으면
        }
        return cycleCount;
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        testCase = Integer.parseInt(br.readLine());
        adj = new int[testCase][];
        visited = new boolean[testCase][];
        for(int i = 0; i < testCase; i++){
            int N = Integer.parseInt(br.readLine());
            adj[i] = new int[N+1];
            visited[i] = new boolean[N+1];
            adj[i][0] = N; //요솟수
            visited[i][0] = true;
            String[] row = br.readLine().split(" ");
            for(int j = 1; j <= N; j++) {
                adj[i][j] = Integer.parseInt(row[j-1]);
            }
        }
    }
}
