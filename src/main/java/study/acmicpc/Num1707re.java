package study.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Num1707re {
    private static int testCase;
    private static List<Integer>[][] adj;

    private static int[] numV;

    private static boolean[][] visited;
    private static int[][] marking;
    private static final int RED = 1;
    private static final int BLUE = 2;

    public static void main(String[] args) throws IOException {
        init();
        for(int i = 0; i < testCase; i++)
            System.out.println(dfsAll(i) ? "YES" : "NO");
    }

    private static boolean dfsAll(int testNum){
        for(int i = 1; i <= numV[testNum]; i++){
            if(!visited[testNum][i]) {
                boolean subAnswer = dfs(testNum, i, marking[testNum][i] = RED);
                if(!subAnswer)
                    return false;
            }
        }
        return true;
    }

    private static boolean dfs(int testNum, int here, int hereMark){
        //마킹 체크
        //마킹 입력
        //방문 체크 및 dfs 호출
        visited[testNum][here] = true;
        for(int i = 0; i < adj[testNum][here].size(); i++){ //인접한 곳의 마킹 체크, 입력, dfs 호출
            int there = adj[testNum][here].get(i);
            if(marking[testNum][there] == 0){
                if(hereMark == RED)
                    marking[testNum][there] = BLUE;
                else if(hereMark == BLUE)
                    marking[testNum][there] = RED;
            }else if(marking[testNum][there] == hereMark){
                return false;
            }

            if(!visited[testNum][there]){
                if(!dfs(testNum, there, marking[testNum][there]))
                    return false;
            }
        }

        return true;
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        testCase = Integer.parseInt(br.readLine());
        adj = new ArrayList[testCase][];
        marking = new int[testCase][];
        visited = new boolean[testCase][];
        numV = new int[testCase];
        for(int i = 0; i < testCase; i++){
            String[] split = br.readLine().split(" ");
            numV[i] = Integer.parseInt(split[0]);
            int numE = Integer.parseInt(split[1]);
            adj[i] = new ArrayList[numV[i]+1];
            for(int j = 1; j <= numV[i]; j++){
                adj[i][j] = new ArrayList<>();
            }

            for(int j = 1; j <= numE; j++){
                String[] split2 = br.readLine().split(" ");
                int v1 = Integer.parseInt(split2[0]);
                int v2 = Integer.parseInt(split2[1]);
                adj[i][v1].add(v2);
                adj[i][v2].add(v1);
            }

            marking[i] = new int[numV[i]+1];
            visited[i] = new boolean[numV[i]+1];
        }
    }
}
