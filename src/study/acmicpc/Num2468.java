package study.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Num2468 {
    private static int N;
    private static int[][] map;
//    private static int[][][] judgeMap;
    private static boolean[][] visited;

    private static int maxRain = 1;
    private static int minRain = 100;
    private static int maxSafeArea = 0;

    public static void main(String[] args) throws IOException {
        //dfsAll도 여러번 실행이 된다. h별로 dfsAll 실행,
        //그리고 제일 큰 max값 비교
        init();
        for(int h = 0; h <= maxRain; h++){ // 비는 0.5가 올 수도 있다 비는 0mm부터 시작!
            visited = new boolean[N][N];
            int safeArea = dfsAll(h);
            if(maxSafeArea < safeArea) maxSafeArea = safeArea;
        }

        System.out.println(maxSafeArea);
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for(int i = 0; i < N; i++){
            String[] row = br.readLine().split(" ");
            for(int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(row[j]);
                if(maxRain < map[i][j]) maxRain = map[i][j]; //최댓값
                if(minRain > map[i][j]) minRain = map[i][j]; //최솟값
            }
        }

        visited = new boolean[N][N];

//        //6이면 6도 잠긴다.
//        //전부 다 1일 때 1만 내려도 다 잠긴다-> 안전영역 0
//        //min과 max 같아도 한 번 돈다.
//        for(int h = minRain; h <= maxRain; h++){
//            for(int i = 0; i < N; i++){
//                for(int j = 0; j < N; j++){
//                    //h 높이로 내리면 h이하의 높이지역은 잠기는 것으로 분류 -> 0
//                    //아니면 -> 1로 안전지역 표시
//                    if(judgeMap[h][i][j] > h) judgeMap[h][i][j] = 1;
//                }
//            }
//        }
    }

    private static void dfs(int hereI, int hereJ, int rHeight){
        //위아래좌우 검사
        // i 상하  j 좌우
          //상 0, -1
        //우 +1, 0
        //하 0, +1
        //좌 -1, 0

        // 경계 검사
        // 방문 검사
        // 높이 해당 여부 검사
        visited[hereI][hereJ] = true;

        if(hereI-1 != -1 && !visited[hereI-1][hereJ] && map[hereI-1][hereJ] > rHeight)
            dfs(hereI-1, hereJ, rHeight);
        if(hereJ+1 != N && !visited[hereI][hereJ+1] && map[hereI][hereJ+1] > rHeight)
            dfs(hereI, hereJ+1, rHeight);
        if(hereI+1 != N && !visited[hereI+1][hereJ] && map[hereI+1][hereJ] > rHeight)
            dfs(hereI+1, hereJ, rHeight);
        if(hereJ-1 != -1 && !visited[hereI][hereJ-1] && map[hereI][hereJ-1] > rHeight)
            dfs(hereI, hereJ-1, rHeight);
    }

    private static int dfsAll(int rHeight){
        //입력된 값 중 최대 값과 최저값을 구하고
        //그 사이의 값에 따라 0혹은 1로 map을 다시 채운다.
        //그 map들을 가지고 dfsAll을 돌린다.

        //height 별로 기준 잡아서 dfs할 수 있도록
        int safeArea = 0;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(map[i][j] > rHeight && !visited[i][j]){
                    dfs(i, j, rHeight);
                    safeArea++;
                }
            }
        }

        return safeArea;
    }

}
