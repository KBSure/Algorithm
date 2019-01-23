package study.acmicpc.review;
//유기농배추
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Num1012 {
    private static int testCaseCount;
    private static BufferedReader br;
    private static int M;
    private static int N;
    private static int K;
    private static final int[][] DIRECTION = new int[][] { {-1, 0, 1, 0}, {0, 1, 0, -1} };
    private static int[][] map;
    private static boolean[][] visited;
    private static int answer;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        testCaseCount = Integer.parseInt(br.readLine());
        for(int i = 0; i < testCaseCount; i++){
            init();
            for(int j = 0; j < N; j++){
                for(int k = 0; k < M; k++){
                    if(!visited[j][k] && map[j][k] == 1) {
                        dfs(j,k);
                        answer++;
                    }
                }
            }
            System.out.println(answer);
        }
    }

    private static void dfs(int hereI, int hereJ){
        if(hereI < 0 || hereI > N-1 || hereJ < 0 || hereJ > M-1 ) return;
        if(map[hereI][hereJ] == 0 || visited[hereI][hereJ]) return;
        visited[hereI][hereJ] = true;

        for(int i = 0; i < 4; i++){
            dfs(hereI + DIRECTION[0][i], hereJ + DIRECTION[1][i]);
        }
    }

    private static void init() throws IOException {
        String[] split = br.readLine().split(" ");
        M = Integer.parseInt(split[0]);
        N = Integer.parseInt(split[1]);
        K = Integer.parseInt(split[2]);
        map = new int[N][M];
        visited = new boolean[N][M];
        for(int i = 0; i < K; i++){
            String[] split2 = br.readLine().split(" ");
            int x = Integer.parseInt(split2[0]);
            int y = Integer.parseInt(split2[1]);
            map[y][x] = 1;
        }
        answer = 0;
    }
}
