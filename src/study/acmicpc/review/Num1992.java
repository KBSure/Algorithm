package study.acmicpc.review; // 쿼드트리
//TopDown 방식으로는 풀이가 어렵다. StringBuilder를 써야 할 것이다. 이 경우에는 어떻게 해야 할까?

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Num1992 {
    private static int N;
    private static boolean[][] map;
    private static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        init();
        quadTree(N, 0, 0);
        System.out.println(sb);
    }

    private static void quadTree(int n, int startI, int startJ) {
        boolean isBlack = map[startI][startJ];
        if(n == 1){
            sb.append(isBlack ? "1" : "0");
            return;
        }
        for(int i = startI; i < startI + n; i++){
            for(int j = startJ; j < startJ + n; j++){
                if(map[i][j] == isBlack) continue;
                sb.append("(");
                int halfN = n >> 1;
                quadTree(halfN, startI, startJ);
                quadTree(halfN, startI, startJ + halfN);
                quadTree(halfN, startI + halfN, startJ);
                quadTree(halfN, startI + halfN, startJ + halfN);
                sb.append(")");
                return;
            }
        }
        //무사 통과
        sb.append(isBlack ? "1" : "0");
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        map = new boolean[N][N];
        for(int i = 0; i < N; i++){
            map[i] = new boolean[N];
        }
        for(int i = 0; i < N; i++){
            String[] split = br.readLine().split("");
            for(int j = 0; j < N; j++){
                map[i][j] = "1".equals(split[j]);
            }
        }
    }
}
