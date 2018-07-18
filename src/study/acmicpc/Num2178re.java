package study.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Num2178re {
    private static int[][] map;
    private static int[][] distance;
    private static boolean[][] discovered;
    private static Queue<Integer[]> queue;

    private static int N;
    private static int M;

    private static final int[][] DIR = {{-1,0,1,0}, {0,1,0,-1}};

    public static void main(String[] args) throws IOException {
        init();
        System.out.println(bfs(0,0));
    }

    private static int bfs(int startI, int startJ){
        discovered[startI][startJ] = true;
        distance[startI][startJ] = 1;
        queue.offer(new Integer[]{startI, startJ});

        while(!queue.isEmpty()){
            Integer[] here = queue.poll();
            if(here[0] == N-1 && here[1] == M-1){
                return distance[here[0]][here[1]];
            }
            for(int i = 0; i < 4; i++){
                Integer[] there = new Integer[2];
                there[0] = here[0] + DIR[0][i];
                there[1] = here[1] + DIR[1][i];

                if(there[0] != -1 && there[0] != N && there[1] != -1 && there[1] != M){
                    if(map[there[0]][there[1]] == 1 && !discovered[there[0]][there[1]]){
                        discovered[there[0]][there[1]] = true;
                        distance[there[0]][there[1]] = distance[here[0]][here[1]] + 1;
                        queue.offer(there);
                    }
                }
            }

        }
        return 0;
    }


    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line1 = br.readLine().split(" ");
        N = Integer.parseInt(line1[0]);
        M = Integer.parseInt(line1[1]);
        map = new int[N][M];
        distance = new int[N][M];
        discovered = new boolean[N][M];
        queue = new LinkedList<>();

        for(int i = 0; i < N; i++){
            String[] row = br.readLine().split("");
            for(int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(row[j]);
            }
        }
    }
}
