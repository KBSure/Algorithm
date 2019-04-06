package study.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Num1074 {
    private static int count = -1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        int N = Integer.parseInt(split[0]);
        int r = Integer.parseInt(split[1]);
        int c = Integer.parseInt(split[2]);

        int size = (int)Math.pow(N, 2);

        z(r, c, 0, 0, (int)Math.pow(2, N));
    }

    private static void z(int r, int c, int startI, int startJ, int size){
        if(size == 2) {
            for(int i = startI; i < startI+size; i++){
                for(int j = startJ; j < startJ+size; j++){
                    count++;
                    if(i == r && j == c) System.out.println(count);
                }
            }
            return;
        }

        int half = size / 2;
        z(r, c, startI, startJ, half);
        z(r, c, startI, startJ+half, half);
        z(r, c, startI+half, startJ, half);
        z(r, c, startI+half, startJ+half, half);
    }

}
