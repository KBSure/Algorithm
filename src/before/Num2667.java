package before;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Num2667 {
    private static int N;
    private static int [][] map;
    private final static int UNVISITABLE = 0;
    private final static int UNVISITED = 1;
    private final static int VISITED = 2;
    private final static int TOP = 0;
    private final static int RIGHT = 1;
    private final static int BOTTOM = 2;
    private final static int LEFT = 3;

    private static ArrayList<Integer> houseCountList = new ArrayList<>();

    public static void main(String[] args) {
        // 입력 받아 배열로 맵 만들기
        // dfs로 단지 찾기
        // 집의 수가 작은 순서대로 출력하기

        // 입력 받아 배열로 맵 만들기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        //맵 만들기
        try {
            // 배열 생성 (0으로 셋팅)
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];

            for(int i = 0; i < N; i++){
                String [] row = br.readLine().split("");
                for(int j = 0; j < N; j++){
                    // 0 혹은 1로 셋팅이 됨
                    map[i][j] = Integer.parseInt(row[j]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // dfs로 단지 찾기
        // dfsAll 호출
        int townCount = dfsAll();

        // 집의 수가 작은 순서대로 출력하기
        Collections.sort(houseCountList);
        System.out.println(townCount);
        for(int i = 0; i < townCount; i++) {
            System.out.println(houseCountList.get(i));
        }
    }

    private static int dfsAll(){
        int townIdx = -1;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(map[i][j] == UNVISITED) { // 방문하지 않은 집
                    houseCountList.add(0);
                    townIdx++;
                    dfs(i, j, townIdx);
                }
            }
        }
        int townCount = townIdx + 1;
        return townCount;
    }

    private static void dfs(int hereI, int hereJ, int townIdx){
        map[hereI][hereJ] = VISITED;
        houseCountList.set(townIdx, houseCountList.get(townIdx)+1);
        //인접한 곳을 방문
        for(int i = 0; i < 4; i++) {
            if (i == TOP && hereI - 1 != -1 && map[hereI-1][hereJ] == 1) dfs(hereI-1, hereJ, townIdx);
            if (i == RIGHT && hereJ + 1 != N && map[hereI][hereJ+1] == 1) dfs(hereI, hereJ+1, townIdx);
            if (i == BOTTOM && hereI + 1 != N && map[hereI+1][hereJ] == 1) dfs(hereI+1,hereJ, townIdx);
            if (i == LEFT && hereJ - 1 != -1 && map[hereI][hereJ-1] == 1) dfs(hereI, hereJ-1, townIdx);
        }
    }
}
