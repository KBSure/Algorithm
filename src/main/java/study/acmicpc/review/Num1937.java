package study.acmicpc.review; //욕심쟁이 판다

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Num1937 {
    private static int n;
    private static int[][] map;
    private static int[][] cache;
    private static final int[][] DIRECTION = {{-1,0,1,0},{0,1,0,-1}};
    public static void main(String[] args) throws IOException {
        init();
        int answer = dfsAll();
        System.out.println(answer);
    }

    private static int dfsAll(){
        int max = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(cache[i][j] == 0){
                    max = Math.max(max,dfs(i,j));
                }
            }
        }
        return max;
    }

    private static int dfs(int hereI, int hereJ) {
        if(cache[hereI][hereJ] != 0) return cache[hereI][hereJ];
        int max = 0;
        for(int i = 0; i < 4; i++){
            int thereI = hereI + DIRECTION[0][i];
            int thereJ = hereJ + DIRECTION[1][i];
            if(thereI < 0 || thereI > n-1 || thereJ < 0 || thereJ > n-1) continue;
            if(map[hereI][hereJ] < map[thereI][thereJ]) {
                max = Math.max(dfs(thereI, thereJ), max);
            }
        }
        int ret = cache[hereI][hereJ] = max + 1;
        return ret;
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        for(int i = 0; i < n; i++){
            String[] split = br.readLine().split(" ");
            map[i] = new int[n];
            for(int j = 0; j < n; j++){
                map[i][j] = Integer.parseInt(split[j]);
            }
        }
        cache = new int[n][n];
        for(int i = 0; i < n; i++){
            cache[i] = new int[n];
        }
    }
}
