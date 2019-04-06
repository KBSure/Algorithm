package Line.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Num1 {
    private static int n;
    private static int[][][] map;
    private static final int F = 0;
    private static final int R = 1;
    private static final int B = 2;
    private static final int L = 3;
    private static final int[][] DIRECTION ={{F,R,B,L},
                                            {R,B,L,F},
                                            {B,L,F,R},
                                            {L,F,R,B}};
    private static boolean[][][] isVisited;

    public static void main(String[] args) throws IOException {
        init();
        // 현재 노드 도착
        // 1. isVIsited 확인해서 맞으면
        // 2.
        // 1. DIRECTION으로 다음 방향 파악
        // 2. map[][][1] 만큼 이동
        // 2.1 이동할 때 isVisited 작성
        //
        // 3. 이동한 곳에서 isVIsited 확인
        // isVisited가 true이면 위치 출력

        int hereI = 0;
        int hereJ = 0;
        int preDirection = B;
        int currentDirection = DIRECTION[preDirection][map[hereI][hereJ][0]];
        while(!isVisited[hereI][hereJ][currentDirection]){ // 방문 안했으면
            // 해당 방향으로 이동 증가
            int increase = map[hereI][hereJ][1];
            isVisited[hereI][hereJ][currentDirection] = true;
            switch (currentDirection){
                case F:
                    hereI -= increase;
                    break;
                case R:
                    hereJ += increase;
                    break;
                case B:
                    hereI += increase;
                    break;
                case L:
                    hereJ -= increase;
                    break;
            }
            preDirection = currentDirection;
            currentDirection = DIRECTION[preDirection][map[hereI][hereJ][0]];
        }

        System.out.println(hereJ +" " + hereI);
//
//        while(isVisited[hereI][hereJ][])


    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][][];
        isVisited = new boolean[n][][];

        for(int i = 0; i < n; i++){
            map[i] = new int[n][];
            isVisited[i] = new boolean[n][];
            String[] line = br.readLine().split(" ");
            for(int j = 0; j < n; j++){
                map[i][j] = new int[2];
                switch (line[j].charAt(0)){ // 0에 방향
                    case 'F':
                        map[i][j][0] = F;
                        break;
                    case 'R':
                        map[i][j][0] = R;
                        break;
                    case 'B':
                        map[i][j][0] = B;
                        break;
                    case 'L':
                        map[i][j][0] = L;
                        break;
                }
                map[i][j][1] = line[j].charAt(1) - '0'; // 1에 이동 칸 수
                isVisited[i][j] = new boolean[4];
            }
        }

//        for(int i = 0; i < n; i++){
//            for(int j = 0; j < n; j++){
//                System.out.print(map[i][j][0] + "" + map[i][j][1] + " ");
//            }
//            System.out.println();
//        }


    }
}
