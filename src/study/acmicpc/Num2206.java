package study.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Num2206 {

    private static int[][] map;
    private static int[][] distance;
    private static Queue<Cell> queue;
    private static int N;
    private static int M;

    public static void main(String[] args) throws IOException {
        init();
        int minDistance = -1;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(map[i][j] == 0){
                    map[i][j] = 1;
                    int tempDistance = bfs();
                    if(minDistance > tempDistance){
                        minDistance = tempDistance;
                    }
                    map[i][j] = 0;
                }
            }
        }
        System.out.println(minDistance);
    }

    private static int bfs(){
        //진입점
        queue.offer(new Cell(0,0));
        distance[0][0] = 0;

        while(!queue.isEmpty()){
            Cell here = queue.poll();
            if(here.i == N-1 && here.j == M-1) return distance[here.i][here.j];

            for(int i = 0; i < 4; i++){
                Cell there = here.adj(i);
                if(map[there.i][there.j] == 0 && distance[there.i][there.j] == -1){
                    queue.offer(there);
                    distance[there.i][there.j] = distance[here.i][here.j] + 1;
                }
            }
        }
        return 0;
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
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                distance[i][j] = -1;
            }
        }

        queue = new LinkedList<>();

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
          return new Cell(i+DIR[0][dir],j+DIR[1][dir]);
        }
    }

}
