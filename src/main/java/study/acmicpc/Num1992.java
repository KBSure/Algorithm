package study.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Num1992 {
    private static int N;
    private static int[][] map;
    public static void main(String[] args) throws IOException {
        init();
        System.out.println(compression(0,0,N));
    }
    public static String compression(int startIndexI, int startIndexJ, int loofSize){
        switch (numOfThisArea(startIndexI, startIndexJ, loofSize)){
            default:
                return "";
            case 0:
                return "0";
            case 1:
                return "1";
            case -1:
                int half = loofSize / 2;
                return "("
                        + compression(startIndexI, startIndexJ, half)
                        + compression(startIndexI, startIndexJ+half, half)
                        + compression(startIndexI+half, startIndexJ, half)
                        + compression(startIndexI+half, startIndexJ+half, half)
                        + ")";
        }
    }

    private static int numOfThisArea(int startIndexI, int startIndexJ, int loofSize) {
        for(int i = startIndexI; i < startIndexI+loofSize; i++){
            for(int j = startIndexJ; j < startIndexJ+loofSize-1; j++){
                if(map[i][j] != map[i][j+1]) return -1;
            }
            if(i < startIndexI + loofSize-1 && map[i][startIndexJ] != map[i+1][startIndexJ]) return -1;
        }
        return map[startIndexI][startIndexJ];
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
    }
}
