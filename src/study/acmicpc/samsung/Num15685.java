package study.acmicpc.samsung;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Num15685 {
    private static BufferedReader br;
    private static int N;
    private static int[][] map;
    private static LinkedList<Integer> curveDirectionList;
    private static final int[][] INCREASEMENT = {{0, -1, 0, 1}, {1, 0, -1, 0}};
    private static int count;
    private static List<Info> infoList;
    private static LinkedList<Integer> tempList;

    public static void main(String[] args) throws Exception {
        init();
        for (int i = 0; i < N; i++) {
            Info info = infoList.get(i);
            drowCurve(info.r, info.c, info.d, info.g);
        }

        //네개 씩 검사
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (map[i][j] == 1 && map[i + 1][j] == 1 && map[i][j + 1] == 1 && map[i + 1][j + 1] == 1) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }

    private static void drowCurve(int r, int c, int d, int g) {
        curveDirectionList.clear();
        map[r][c] = 1;

        r += INCREASEMENT[0][d];
        c += INCREASEMENT[1][d];

        map[r][c] = 1;

        curveDirectionList.addLast((d + 2) % 4);
        //x,y 계속 변경
        for (int i = 0; i < g; i++) {
            tempList = (LinkedList<Integer>) curveDirectionList.clone();
            curveDirectionList.clear();
            //list에서 뱉은 값
            int tempListSize = tempList.size();
            for (int j = 0; j < tempListSize; j++) {

                Integer pollFirst = tempList.pollFirst();

                Integer newDirection = (pollFirst - 1) % 4 < 0 ? 3 : (pollFirst - 1) % 4; //-1 하고 나눴을 때 어케 하는지 살펴보자
                r += INCREASEMENT[0][newDirection];
                c += INCREASEMENT[1][newDirection];
                map[r][c] = 1;

                curveDirectionList.addLast(pollFirst);
                curveDirectionList.addFirst((newDirection + 2) % 4);

            }

        }

    }

    private static void init() throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        infoList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            String[] split = br.readLine().split(" ");
            int c = Integer.parseInt(split[0]);
            int r = Integer.parseInt(split[1]);
            int d = Integer.parseInt(split[2]);
            int g = Integer.parseInt(split[3]);
            infoList.add(new Info(r, c, d, g));
        }
        map = new int[101][101];
        curveDirectionList = new LinkedList<>();
    }

    private static class Info {
        private int r;
        private int c;
        private int d; //시작방향
        private int g; //세대 수

        public Info(int r, int c, int d, int g) {
            super();
            this.r = r;
            this.c = c;
            this.d = d;
            this.g = g;
        }

    }

}
