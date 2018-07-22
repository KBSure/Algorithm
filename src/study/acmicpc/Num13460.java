package study.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Num13460 {
    private static int N;
    private static int M;
    private static char[][] map;
    private static Queue<Ball[]> queue;

    private static final int RED = 0;
    private static final int BLUE = 1;

    private final static int UP = 0;
    private final static int RIGHT = 1;
    private final static int DOWN = 2;
    private final static int LEFT = 3;

    private final static char WALL = '#';
    private final static char ROAD = '.';
    private final static char HOLE = 'O';
    private final static char REDBALL = 'R';
    private final static char BLUEBALL = 'B';

    private final static int[][] DIR = {{-1,0,1,0}, {0,1,0,-1}};

    public static void main(String[] args) throws IOException {
        init();
        System.out.println(bfs());
    }

    private static int bfs(){
        //start 셋팅되어 있음
        while(!queue.isEmpty()){ //10번 이하로 게임
            Ball[] hereBalls = queue.peek();
            if(hereBalls[RED].distance <= 10){
                queue.poll();
            }else{
                return -1;
            }
            Ball hereRed = hereBalls[RED]; //null이 생길 수 없다
            Ball hereBlue = hereBalls[BLUE];

//            for(int i = 0; i < N; i++){
//                for(int j = 0; j < M; j++){
//                    if(hereRed.i == i && hereRed.j == j){
//                        System.out.print(REDBALL);
//                    }else if(hereBlue.i == i && hereBlue.j == j){
//                        System.out.print(BLUEBALL);
//                    }
//                    else{
//                        System.out.print(map[i][j]);
//                    }
//                }
//                System.out.println();
//            }

            if(map[hereRed.i][hereRed.j] == HOLE && map[hereBlue.i][hereBlue.j] != HOLE){ // 구멍 잘 들어갔으면
                return hereRed.distance;
            }else if(map[hereRed.i][hereRed.j] == HOLE && map[hereBlue.i][hereBlue.j] == HOLE){
                continue;
            }

            //사방으로 이동시키기
            for(int i = 0; i < 4; i++){
                //before랑 beforebefore가 dir 차이가 2가 나고 beforebefore랑 i랑 같으면 추가 안한다
                //before랑 같으면 추가 안한다
                if(hereRed.beforeDir != i && !(Math.abs(hereRed.beforeDir - hereRed.beforebeforeDir) == 2 && hereRed.beforebeforeDir == i)) {
                    Ball[] thereBalls = moveBalls(hereBalls, i);
                    queue.offer(thereBalls);
                }
            }
        }
        return -1;
    }

    private static Ball[] moveBalls(Ball[] hereBalls, int dir) {
        switch (dir){
            case UP:
                if(hereBalls[RED].i < hereBalls[BLUE].i){
                    Ball thereRed = hereBalls[RED].move(dir);
                    Ball thereBlue = hereBalls[BLUE].move(dir);
                    if(thereRed.i == thereBlue.i && thereRed.j == thereBlue.j && map[thereRed.i][thereRed.j] != HOLE){
                        thereBlue.i -= DIR[0][dir];
                        thereBlue.j -= DIR[1][dir];
                    }
                    return new Ball[]{thereRed, thereBlue};
                }else{
                    Ball thereBlue = hereBalls[BLUE].move(dir);
                    Ball thereRed = hereBalls[RED].move(dir);
                    if(thereRed.i == thereBlue.i && thereRed.j == thereBlue.j && map[thereRed.i][thereRed.j] != HOLE){
                        thereRed.i -= DIR[0][dir];
                        thereRed.j -= DIR[1][dir];
                    }
                    return new Ball[]{thereRed, thereBlue};
                }
            case RIGHT:
                if(hereBalls[RED].j > hereBalls[BLUE].j){
                    Ball thereRed = hereBalls[RED].move(dir);
                    Ball thereBlue = hereBalls[BLUE].move(dir);
                    if(thereRed.i == thereBlue.i && thereRed.j == thereBlue.j && map[thereRed.i][thereRed.j] != HOLE){
                        thereBlue.i -= DIR[0][dir];
                        thereBlue.j -= DIR[1][dir];
                    }
                    return new Ball[]{thereRed, thereBlue};
                }else{
                    Ball thereBlue = hereBalls[BLUE].move(dir);
                    Ball thereRed = hereBalls[RED].move(dir);
                    if(thereRed.i == thereBlue.i && thereRed.j == thereBlue.j && map[thereRed.i][thereRed.j] != HOLE){
                        thereRed.i -= DIR[0][dir];
                        thereRed.j -= DIR[1][dir];
                    }
                    return new Ball[]{thereRed, thereBlue};
                }
            case DOWN:
                if(hereBalls[RED].i > hereBalls[BLUE].i){
                    Ball thereRed = hereBalls[RED].move(dir);
                    Ball thereBlue = hereBalls[BLUE].move(dir);
                    if(thereRed.i == thereBlue.i && thereRed.j == thereBlue.j && map[thereRed.i][thereRed.j] != HOLE){
                        thereBlue.i -= DIR[0][dir];
                        thereBlue.j -= DIR[1][dir];
                    }
                    return new Ball[]{thereRed, thereBlue};
                }else{
                    Ball thereBlue = hereBalls[BLUE].move(dir);
                    Ball thereRed = hereBalls[RED].move(dir);
                    if(thereRed.i == thereBlue.i && thereRed.j == thereBlue.j && map[thereRed.i][thereRed.j] != HOLE){
                        thereRed.i -= DIR[0][dir];
                        thereRed.j -= DIR[1][dir];
                    }
                    return new Ball[]{thereRed, thereBlue};
                }
            case LEFT:
                if(hereBalls[RED].j < hereBalls[BLUE].j){
                    Ball thereRed = hereBalls[RED].move(dir);
                    Ball thereBlue = hereBalls[BLUE].move(dir);
                    if(thereRed.i == thereBlue.i && thereRed.j == thereBlue.j && map[thereRed.i][thereRed.j] != HOLE){
                        thereBlue.i -= DIR[0][dir];
                        thereBlue.j -= DIR[1][dir];
                    }
                    return new Ball[]{thereRed, thereBlue};
                }else{
                    Ball thereBlue = hereBalls[BLUE].move(dir);
                    Ball thereRed = hereBalls[RED].move(dir);
                    if(thereRed.i == thereBlue.i && thereRed.j == thereBlue.j && map[thereRed.i][thereRed.j] != HOLE){
                        thereRed.i -= DIR[0][dir];
                        thereRed.j -= DIR[1][dir];
                    }
                    return new Ball[]{thereRed, thereBlue};
                }

        }

        return new Ball[0];
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] sizeSplit = br.readLine().split(" ");
        N = Integer.parseInt(sizeSplit[0]);
        M = Integer.parseInt(sizeSplit[1]);
        map = new char[N][M];
        queue = new LinkedList<>();

        Ball red = null;
        Ball blue = null;

        for(int i = 0; i < N; i++){
            String row = br.readLine();
            for (int j = 0; j < M; j++){
                map[i][j] = row.charAt(j);
                if(map[i][j] == 'R'){
                    map[i][j] = '.';
                    red = new Ball(i,j, 0, -1, -1);
                }else if(map[i][j] == 'B'){
                    map[i][j] = '.';
                    blue = new Ball(i,j,0, -1,-1);
                }
            }
        }
        queue.add(new Ball[]{red, blue});


    }

    private static class Ball{
        int i;
        int j;
        int distance;
        int beforeDir;
        int beforebeforeDir;

        Ball(int i, int j, int distance, int beforeDir, int beforebeforeDir){
            this.i = i;
            this.j = j;
            this.distance = distance;
            this.beforeDir = beforeDir;
            this.beforebeforeDir = beforebeforeDir;
        }

        Ball move(int dir) {
            //while문 돌면서 이동시킨다.
            int thereI = this.i;
            int thereJ = this.j;
            Ball thereBall = new Ball(thereI, thereJ, this.distance + 1, dir, this.beforeDir);
            while(true){
                //up이라고 가정하고
                thereI = thereI + DIR[0][dir];
                thereJ = thereJ + DIR[1][dir];

                if(map[thereI][thereJ] == HOLE){
                    thereBall.i = thereI;
                    thereBall.j = thereJ;
                    return thereBall; //호출한 곳에서 혹시 구멍 위치인지 비교한 후 red면 return distance, blue면 그 경우에는 탐색 중지
                }else if(map[thereI][thereJ] == ROAD){
                    thereBall.i = thereI;
                    thereBall.j = thereJ;
                }else{ //장애물
                    return thereBall;
                }
            }
        }
    }
}
