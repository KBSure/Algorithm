package study.acmicpc.review;//단지번호 붙이기

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Num2667 {
    private static int N;
    private static int[][] map;
    private static List<Integer> answerList;
    private static final int[][] DIRECTION = {{-1,0,1,0},{0,1,0,-1}};
    private static boolean[][] discovered;
    public static void main(String[] args) throws IOException {
        init();
        dfsAll();
        System.out.println(answerList.size());
        Collections.sort(answerList);
        for(Integer i : answerList){
            System.out.println(i);
        }
    }

    private static void dfsAll(){
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(!discovered[i][j] && map[i][j] == 1){
                    answerList.add(dfs(i,j));
                }
            }
        }
    }

    private static int dfs(int hereI, int hereJ) {
        //갈 곳 없으면 리턴 0
        //갈 곳 있었으면 합쳐서 리턴
        if(hereI < 0 || hereI > N-1 || hereJ < 0 || hereJ > N-1) return 0;
        if(discovered[hereI][hereJ] || map[hereI][hereJ] == 0) return 0; //방문을 했거나 map에서 갈 수 없으면
        //방문 안했으면
        discovered[hereI][hereJ] = true;
        int ret = 1;
        for(int i = 0; i < 4; i++){
            ret += dfs(hereI + DIRECTION[0][i],hereJ + DIRECTION[1][i]);
        }
        return ret;
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for(int i = 0; i < N; i++){
            String[] split = br.readLine().split("");
            for(int j = 0; j < N; j++){
                map[i][j] = Integer.parseInt(split[j]);
            }
        }
        answerList = new ArrayList<>();
        discovered = new boolean[N][N];
    }

}
