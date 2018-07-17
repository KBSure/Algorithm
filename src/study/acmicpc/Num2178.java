package study.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Num2178 {
    private static Queue<Integer>[] Q;
    private static int[][] distance;
    private static boolean[][] discovered;
    private static int[][] map;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        int N = Integer.parseInt(split[0]);
        int M = Integer.parseInt(split[1]);
        map = new int[N][M];
        distance = new int[N][M];
        discovered = new boolean[N][M];

        Q = new LinkedList[2];
        Q[0] = new LinkedList<>();
        Q[1] = new LinkedList<>();
        for(int i = 0; i < N; i++){
            String[] row = br.readLine().split("");
            for(int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(row[j]);
            }
        }

        int startI = 0;
        int startJ = 0;

        Q[0].add(startI);
        Q[1].add(startJ);
        distance[startI][startJ] = 0;

        while(!Q[0].isEmpty()){
            Integer hereI = Q[0].poll();
            Integer hereJ = Q[1].poll();

            if(hereI == N-1 && hereJ == M-1){
                System.out.println(distance[hereI][hereJ]);
                return;
            }


            int thereI;
            int thereJ;
            thereI = hereI-1;
            thereJ = hereJ;
            if(thereI != -1 && !discovered[thereI][thereJ]) {
                discovered[thereI][thereJ] = true;
                Q[0].add(thereI);
                Q[1].add(thereJ);
                distance[thereI][thereJ] = distance[hereI][hereJ] + 1;
            }
            thereI = hereI;
            thereJ = hereJ+1;
            if(thereJ != N && !discovered[thereI][thereJ]) {
                discovered[thereI][thereJ] = true;
                Q[0].offer(thereI);
                Q[1].offer(thereJ);
                distance[thereI][thereJ] = distance[hereI][hereJ] + 1;
            }
            thereI = hereI + 1;
            thereJ = hereJ;
            if(thereI != N && !discovered[thereI][thereJ]) {
                discovered[thereI][thereJ] = true;
                Q[0].offer(thereI);
                Q[1].offer(thereJ);
                distance[thereI][thereJ] = distance[hereI][hereJ] + 1;
            }
            thereI = hereI;
            thereJ = hereJ - 1;
            if(thereJ != -1 && !discovered[thereI][thereJ]) {
                discovered[thereI][thereJ] = true;
                Q[0].offer(thereI);
                Q[1].offer(thereJ);
                distance[thereI][thereJ] = distance[hereI][hereJ] + 1;
            }

        }
    }
}
