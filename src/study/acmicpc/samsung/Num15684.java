package study.acmicpc.samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Num15684 {
    private static int N; // (col)
    private static int H; // 높을 수 있는 수 (row)
    private static int M; // 그어진 수
    private static int[][] map; // 0은 사용하지 않는다.
    private static int[][] map2;
    private static int countOdd = 0;
    private static int selfEndCount;
    private static int maxSelfEndCount;
    private static List<Integer> oddList;

    public static void main(String[] args) throws Exception {
        init();
        //검사 -> 홀수인 곳 찾아내서 그곳을
        for(int j = 1; j < N+1; j++) {
            int count = 0;
            for(int i = 1; i < H+1; i++) {
                if(map[i][j] == 1) count++;
            }
            if(count % 2 == 1) {
                oddList.add(j);
                countOdd++;
            }
            if(countOdd > 3) { //3개 이하여야 함
                System.out.println(-1);
                return;
            }
        }
        checkSelfEndCount(); //SelfEndCount 반환 //홀수는 우선 다 채워넣는다.

        //홀수 채워넣기

        //combination
        maxSelfEndCount = selfEndCount;
        combination(oddList.size());
        selfEndCount = maxSelfEndCount;

        if(maxSelfEndCount == N) {
            System.out.println(countOdd);
            return;
        }else if(countOdd < 2){
            if(countOdd == 1) {
                combination2();
            }else if(countOdd == 0) {
                combination3();
            }
            if(selfEndCount == N) {
                System.out.println(countOdd + 2);
                return;
            }
        }
        System.out.println(-1);



        //홀수 1개 채웠을 때 dfs 해보고, 개수가 줄어들었으면 두개 연속으로 찾아본다.
        //홀수 0개 일 때 두 개짜리 넣어가면서 찾아본다.


    }



    private static void combination2() {
        outer:for(int j = 1; j <= N; j++) {
            for(int i = 1; i <= H; i++) {
                if(map2[i][j] != 0) continue;
                for(int i2 = i; i2 <= H; i2++) {
                    if(map2[i][j] != 0) continue;
                    checkSelfEndCount();
                    if(selfEndCount == N) break outer;
                }
            }
        }
    }
    private static void combination3() {
        outer:for(int j = 1; j <= N; j++) {
            for(int i = 1; i <= H; i++) {
                if(map[i][j] != 0) continue;
                for(int i2 = i; i2 <= H; i2++) {
                    if(map[i][j] != 0) continue;
                    checkSelfEndCount();
                    if(selfEndCount == N) break outer;
                }
            }
        }
    }



    private static void combination(int n) {
        if(selfEndCount == N) {
            return;
        }
        if(n == 0) {
            checkSelfEndCount();
            if(maxSelfEndCount < selfEndCount) {
                maxSelfEndCount = selfEndCount;
                map2 = map.clone();
            }
            return;
        }
        int j = oddList.get(n-1);
        for(int i = 1; i <= H; i++) {
            if(map[i][j] == 0 && map[i][j+1] == 0) {
                map[i][j] = 1;
                map[i][j+1] = 2;
                combination(n-1);
                map[i][j] = 0;
                map[i][j+1] = 0;
            }
        }
    }



    private static void checkSelfEndCount() {
        //방향 바꾸기
        //내려간다. 1을 만나면 오른쪽 2를 만나면 왼쪽으로 간다.
        selfEndCount = 0;
        for(int j = 1; j <= N; j++) {
            int j2 = j;
            for(int i = 1; i <= H; i++) {
                if(map[i][j2] == 1) {
                    j2++;
                }else if(map[i][j2] == 2) {
                    j2--;
                }
            }
            if(j == j2) {
                selfEndCount++;
            }
        }
    }

    private static void checkSelfEndCount2() {
        //방향 바꾸기
        //내려간다. 1을 만나면 오른쪽 2를 만나면 왼쪽으로 간다.
        selfEndCount = 0;
        for(int j = 1; j <= N; j++) {
            int j2 = j;
            for(int i = 1; i <= H; i++) {
                if(map2[i][j2] == 1) {
                    j2++;
                }else if(map2[i][j2] == 2) {
                    j2--;
                }
            }
            if(j == j2) {
                selfEndCount++;
            }
        }
    }



    private static void init() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        N = Integer.parseInt(split[0]);
        M = Integer.parseInt(split[1]);
        H = Integer.parseInt(split[2]);
        map = new int[H+1][N+1]; // 세로선 우측 맨 끝은 필요 없음 // 1~H / 단 N은 항상 0
        for(int i = 0; i < M; i++) {
            String[] split2 = br.readLine().split(" ");
            map[Integer.parseInt(split2[0])][Integer.parseInt(split2[1])] = 1;
            map[Integer.parseInt(split2[0])][Integer.parseInt(split2[1])+1] = 2;
        }
//
//		for(int i = 1; i < H+1; i++) {
//			for(int j = 1; j < N+1; j++) {
//				System.out.print(map[i][j] + " ");
//			}
//			System.out.println();
//		}
        oddList = new ArrayList<>();
    }

}
