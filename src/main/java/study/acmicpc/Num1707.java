package study.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Num1707 {

    private static Integer testCase;
    private static List<Integer>[] adj;
    private static boolean[] visited;

    private static boolean answer;

    private static int[] marking;
    private static final int RED = 1;
    private static final int BLUE = 2;

    public static void main(String[] args) throws IOException {
        //testcase 만큼 for문 돌면서 실행
        while(init()){
            System.out.println(dfs(1, marking[1] = RED) ? "YES" : "NO");
        }
    }

    private static boolean dfs(int here, int mark) {
        visited[here] = true;
        for (int i = 0; i < adj[here].size(); i++) {
            int there = adj[here].get(i);
            if (marking[there] == 0) {
                if (mark == BLUE)
                    marking[there] = RED;
                else if (mark == RED)
                    marking[there] = BLUE;
            } else if (marking[there] == mark) {
                return false;
            }

            if (visited[there] && !dfs(there, marking[there]))
                return false;
        }
        return true;
    }

    private static boolean init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        if(testCase == null)
            testCase = Integer.parseInt(br.readLine());
        String[] stringVandE = br.readLine().split(" ");
        int numV = Integer.parseInt(stringVandE[0]);
        int numE = Integer.parseInt(stringVandE[1]);

        adj = new ArrayList[numV+1];

        for(int i = 1; i <= numV; i++){
            adj[i] = new ArrayList<>();
        }

        for(int i = 0; i < numE; i++){
            String[] stringE = br.readLine().split(" ");
            int v1 = Integer.parseInt(stringE[0]);
            int v2 = Integer.parseInt(stringE[1]);

            adj[v1].add(v2);
            adj[v2].add(v1);
            System.out.println();
        }

        visited = new boolean[numV+1];
        marking = new int[numV+1];

        return --testCase != 0;
    }
}
