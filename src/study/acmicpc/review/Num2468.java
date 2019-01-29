package study.acmicpc.review; //안전 영역

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Num2468 {
    private static int[][] map;
    private static int N;
    private static int maxDepth = -1;
    private static int maxSafetyArea = 1; // 강수량이 0일 때는 안전 지역 1이다.
    private static boolean[][] visited;
    private static final int[][] DIRECTION = {{-1, 0, 1, 0}, {0, 1, 0, -1}};
    public static void main(String[] args) throws IOException {
        init();
        for(int i = 1; i <= maxDepth; i++){
            visited = new boolean[N][N];
            int safetyArea = dfsAll(i);
            maxSafetyArea = safetyArea > maxSafetyArea ? safetyArea : maxSafetyArea;
        }
        System.out.println(maxSafetyArea);
    }

    private static int dfsAll(int rainHeight) {
        int safetyArea = 0;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(!visited[i][j] && map[i][j] > rainHeight){
                    dfs(i, j, rainHeight);
                    safetyArea++;
                }
            }
        }
        return safetyArea;
    }

    private static void dfs(int hereI, int hereJ, int rainHeight){
        // rainHeight 보다 큰 지역만 안전지역
        if(hereI < 0 || hereI > N-1 || hereJ < 0 || hereJ > N-1) return;
        if(map[hereI][hereJ] <= rainHeight) return;
        if(visited[hereI][hereJ]) return;
        visited[hereI][hereJ] = true;
        for(int i = 0; i < 4; i++){
            int thereI = hereI + DIRECTION[0][i];
            int thereJ = hereJ + DIRECTION[1][i];
            dfs(thereI, thereJ, rainHeight);
        }
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];

        for(int i = 0; i < N; i++){
            String[] split = br.readLine().split(" ");
            for(int j = 0; j < N; j++){
                map[i][j] = Integer.parseInt(split[j]);
                maxDepth = maxDepth < map[i][j] ? map[i][j] : maxDepth;
            }
        }
    }
}
