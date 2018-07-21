package study.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Num2206re {
    private static final int WALL = 1;
    private static final int VISITABLE = 0;
    private static final int VISITABLE2 = 2;
    private static int N;
    private static int M;
    private static int[][] map;
    private static boolean[][] discovered;
    private static int[][] distance;
    private static Queue<Cell> queue;

    //static class를 인스턴스화 하면
    private static class Cell{
        int i;
        int j;
        boolean broken;

        private final int[][] DIR = {{-1,0,1,0}, {0,1,0,-1}};

        Cell(int i, int j, boolean broken){
            this.i = i;
            this.j = j;
            this.broken = broken;
        }

        Cell adj(int dir){
            //사방 dir별
            int thereI = this.i + DIR[0][dir];
            int thereJ = this.j + DIR[1][dir];
            Cell there = null;
            if(thereI != -1 && thereI != N && thereJ != -1 && thereJ != M){
                there = new Cell(thereI, thereJ, this.broken);
            }
            return there;
        }
    }


    public static void main(String[] args) throws IOException {
        init();
        //bfs는 distance return
        System.out.println(bfs());
    }

    private static int bfs(){
        //진입점 초기화
        discovered[0][0] = true;
        distance[0][0] = 1;
        queue.offer(new Cell(0,0, false));
        //while
        while(!queue.isEmpty()){
            Cell here = queue.poll();
            if(here.i == N-1 && here.j == M-1) return distance[here.i][here.j];

            for(int i = 0; i < 4; i++){
                //there 넣고, queue에 넣을 것인지 안 넣을것인지
                Cell there = here.adj(i);
                if(there != null){
                    //벽 안 뚫은 상태에서 진행 중(일반:false,X,0,false) -> discovered : true, distance : +1, map: 0을 0, broken:false
                    //벽 안 뚫은 상태에서 진행 중(특수:true,X,2,false) -> discovered : true, distance: +1, map:2를 0, broken:false
                    //벽 뚫을 때(false,X,1,false) -> discoverd : true, distance : +1, map: 1을 1, broken:true
                    //벽 뚫은 상태에서 진행 중(false,X,0,true) -> discovered : true, distance : +1, map: 0을 2, broken:true

                    //discovered -> map -> broken

                    if(discovered[there.i][there.j]){ //방문했을 때
                        if(map[there.i][there.j] == WALL){
                        }else if(map[there.i][there.j] == VISITABLE){
                        }else if(map[there.i][there.j] == VISITABLE2){
                            if(there.broken){
                            }else if(!there.broken){
                                //앞의 놈이 실패할 수 있으므로 간다(벽 더이상 못 뚫는 경우)
                                discovered[there.i][there.j] = true;
                                distance[there.i][there.j] = distance[here.i][here.j] + 1;
                                map[there.i][there.j] = VISITABLE;
                                queue.offer(there);
                            }
                        }
                    }else{ //방문 안 했을 때
                        if(map[there.i][there.j] == WALL){
                            if(there.broken){
                            }else{
                                //뚫는다
                                discovered[there.i][there.j] = true;
                                distance[there.i][there.j] = distance[here.i][here.j] + 1;
                                map[there.i][there.j] = WALL;
                                queue.offer(there);
                                there.broken = true;
                            }
                        }else if(map[there.i][there.j] == VISITABLE){ //갈 수 있다
                            if(there.broken){
                                discovered[there.i][there.j] = true;
                                distance[there.i][there.j] = distance[here.i][here.j] + 1;
                                map[there.i][there.j] = VISITABLE2;
                                queue.offer(there);
                            }else if(!there.broken){
                                discovered[there.i][there.j] = true;
                                distance[there.i][there.j] = distance[here.i][here.j] + 1;
                                map[there.i][there.j] = VISITABLE;
                                queue.offer(there);
                            }
                        }else if(map[there.i][there.j] == VISITABLE2){
                        }
                    }
                }
            }
        }
        return -1;
    }
    
    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] sizeSplit = br.readLine().split(" ");
        N = Integer.parseInt(sizeSplit[0]);
        M = Integer.parseInt(sizeSplit[1]);

        map = new int[N][M];

        for(int i = 0; i < N; i++){
            String[] rowSplit = br.readLine().split("");
            for(int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(rowSplit[j]);
            }
        }

        discovered = new boolean[N][M]; //false
        distance = new int[N][M]; //0
        queue = new LinkedList<>();

    }
}
