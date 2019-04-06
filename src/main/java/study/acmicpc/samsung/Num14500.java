package study.acmicpc.samsung;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Num14500 {
    private static int N;
    private static int M;
    private static int[][] map;
    private static final int[][] DIRECTION = new int[][] {{-1,0,1,0}, {0,1,0,-1}};
    private static boolean[][] visited;

    public static void main(String[] args) throws Exception {
        init();
        System.out.println(calcMax());
    }

    private static int calcMax() {
        //ㅗ 모양도 예외적으로 검사
        int ret = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                ret = Math.max(ret, dfs(4, i, j));
                ret = Math.max(ret, calcMtnShape(i, j));
            }
        }
        return ret;
    }

    private static int calcMtnShape(int hereI, int hereJ) {
        int tempSum = map[hereI][hereJ];
        int count = 0;
        for(int i = 0; i < 4; i++) {
            int thereI = hereI + DIRECTION[0][i];
            int thereJ = hereJ + DIRECTION[1][i];
            if(thereI == -1 || thereI == N || thereJ == -1 || thereJ == M){
                if(++count > 1) return -1;
                continue;
            }
            tempSum += map[thereI][thereJ];
        }

        int ret = 0;
        for(int i = 0; i < 4; i++) {
            int thereI = hereI + DIRECTION[0][i];
            int thereJ = hereJ + DIRECTION[1][i];
            if(thereI == -1 || thereI == N || thereJ == -1 || thereJ == M){
                return tempSum;
            }
            ret = Math.max(ret, tempSum - map[thereI][thereJ]);
        }
        return ret;
    }

    private static int dfs(int n, int hereI, int hereJ) {
        if(hereI == -1 || hereI == N || hereJ == -1 || hereJ == M) return -1;
        if(visited[hereI][hereJ]) return -1;
        visited[hereI][hereJ] = true;
        if(n == 1) {
            visited[hereI][hereJ] = false;
            return map[hereI][hereJ];
        }
        int ret = 0;
        for(int i = 0; i < 4; i++) {
            //너무 오래 걸리면 오른쪽, 우측으로 좁혀야 한다.
            int thereI = hereI + DIRECTION[0][i];
            int thereJ = hereJ + DIRECTION[1][i];
            ret = Math.max(ret, map[hereI][hereJ] + dfs(n-1, thereI, thereJ));
        }
        visited[hereI][hereJ] = false;
        return ret;
    }

    private static void init() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        N = Integer.parseInt(split[0]);
        M = Integer.parseInt(split[1]);
        map = new int[N][M];
        for(int i = 0; i < N; i++) {
            String[] split2 = br.readLine().split(" ");
            for(int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(split2[j]);
            }
        }
        visited = new boolean[N][M];
    }

}
