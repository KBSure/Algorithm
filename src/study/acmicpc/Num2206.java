package study.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

//반복문 돌려서 메서드 호출 할 때 초기화 해줘야 하는 자료구조가 있는지 확인!
//
public class Num2206 {

    private static int[][] map;
    private static int[][] distance;
    private static Queue<Cell> queue;
    private static int N;
    private static int M;

    public static void main(String[] args) throws IOException {
        while(true) {
            init();
            int minDistance = 1000 * 1000;
            int tempDistance = bfs(); //벽 안 뚫고 bfs
            if (tempDistance != -1 && minDistance > tempDistance) {
                minDistance = tempDistance;
            }

            minDistance = bfsWithWallBreaking(minDistance);

            System.out.println(minDistance != 1000 * 1000 ? minDistance : -1);
        }
    }

    private static int bfs(){
        //진입점
        queue.offer(new Cell(0,0));
        distance[0][0] = 1;

        while(!queue.isEmpty()){
            Cell here = queue.poll();
            if(here.i == N-1 && here.j == M-1) return distance[here.i][here.j];

            for(int i = 0; i < 4; i++){
                Cell there = here.adj(i);
                if(there != null) {
                    if (map[there.i][there.j] == 0 && distance[there.i][there.j] == -1) {
                        queue.offer(there);
                        distance[there.i][there.j] = distance[here.i][here.j] + 1;
                    }
                }
            }
        }
        return -1;
    }

    private static int bfsWithWallBreaking(int minDistance){
        //초기화
        int tempDistance = 0;
        for(int i = 0; i < N; i++){ //벽 뚫고 bfs
            for(int j = 0; j < M; j++){
                if(map[i][j] == 1){
                    initDistance();
                    map[i][j] = 0;
                    tempDistance = bfs();
                    if(tempDistance != -1 && minDistance > tempDistance){
                        minDistance = tempDistance;
                    }
                    map[i][j] = 1;
                }
            }
        }
        return minDistance;
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] sizeSplit = br.readLine().split(" ");
        N = Integer.parseInt(sizeSplit[0]);
        M = Integer.parseInt(sizeSplit[1]);

        map = new int[N][M]; //0 초기화
        for(int i = 0; i < N; i++){
            String[] rowSplit = br.readLine().split("");
            for(int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(rowSplit[j]);
            }
        }

        distance = new int[N][M]; //-1 초기화
        initDistance();

        queue = new LinkedList<>();

    }

    private static void initDistance(){
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                distance[i][j] = -1;
            }
        }
    }

    private static class Cell {
        int i;
        int j;

        private final int[][] DIR = {{-1,0,1,0},
                                    {0,1,0,-1}};

        Cell(int i, int j){
            this.i = i;
            this.j = j;
        }

        Cell adj(int dir){
            int thereI = i+DIR[0][dir];
            int thereJ = j+DIR[1][dir];
            Cell there = null;
            if(thereI != -1 && thereI != N && thereJ != -1 && thereJ != M) {
                there = new Cell(thereI, thereJ);
            }
          return there;
        }
    }

}
