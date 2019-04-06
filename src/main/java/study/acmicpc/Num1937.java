package study.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Num1937 {
    private static int N;
    private static int[][] map;
    private static int[][] cache;
    private static final int[][] DIRECTION = {{-1, 0, 1, 0}, {0, 1, 0, -1}};
    public static void main(String[] args) throws IOException {
        init();
        System.out.println(dfsAll());
    }

    private static int dfsAll(){
        int ret = 1;
        for(int i = 0; i < N; i++){
            for(int j = 0 ; j < N; j++){
                if(cache[i][j] == 0){ //아직 기록 없으면
                    ret = Math.max(ret, dfs(i, j, map[i][j]));
                }
            }
        }
        return ret;
    }

    private static int dfs(int hereI, int hereJ, int hereValue){
        if(cache[hereI][hereJ] != 0) return cache[hereI][hereJ];
        for(int i = 0; i < 4; i++){
            int thereI = hereI + DIRECTION[0][i];
            int thereJ = hereJ + DIRECTION[1][i];
            if(thereI < 0 || thereI > N-1) continue;
            if(thereJ < 0 || thereJ > N-1) continue;

            int thereValue = map[thereI][thereJ];
            if(hereValue < thereValue){
                int cacheValue = dfs(thereI, thereJ, thereValue) + 1;
                if(cache[hereI][hereJ] < cacheValue){ // <= 필요??
                    cache[hereI][hereJ] = cacheValue;
                }
            }
        }
        return cache[hereI][hereJ] != 0 ? cache[hereI][hereJ] : 1;
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for(int i = 0; i < N; i++){
            String[] split = br.readLine().split(" ");
            for(int j = 0; j < N; j++){
                map[i][j] = Integer.parseInt(split[j]);
            }
        }
        cache = new int[N][N];
    }
}
