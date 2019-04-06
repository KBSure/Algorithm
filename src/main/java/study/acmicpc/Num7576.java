package study.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Num7576 {
    private static int N;
    private static int M;
    private static int[][] map;

    private static List<Queue<Cell>> queueList;

    private static int countVisitable;

    public static void main(String[] args) throws IOException {
        init();
        System.out.println(bfs());
    }

    private static class Cell{
        int i;
        int j;
        int distance; //distance가 기입되는 과정이 필요한 것이 아니라면, 별도의 자료구조에 기록해놓을 필요가 없다.

        static final int[][] DIR = {{-1,0,1,0}, {0,1,0,-1}};
        Cell(int i, int j, int distance){
            this.i = i; this.j = j; this.distance = distance;
        }

        public Cell adj(int dir) {
            int thereI = this.i + DIR[0][dir];
            int thereJ = this.j + DIR[1][dir];
            Cell there = null;
            if(thereI != -1 && thereI != N && thereJ != -1 && thereJ != M){
                there = new Cell(thereI, thereJ, this.distance + 1);
            }
            return there;
        }
    }

    private static int bfs(){
        //here 들어 가 있는 중
        int nowDistance = -1;
            while(!isEmptyAllQueue()){
            nowDistance++;
            for(Queue<Cell> queue : queueList){
                Cell here = queue.peek();
                while(here != null && here.distance == nowDistance){
                    queue.poll();
                    for (int i = 0; i < 4; i++) {
                        Cell there = here.adj(i);
                        if (there != null) {
                            if (map[there.i][there.j] == 0) {
                                queue.offer(there);
                                map[there.i][there.j] = 1;
                                countVisitable--;
                            }
                        }
                    }
                    here = queue.peek();
                }
            }
        }
        return countVisitable == 0 ? nowDistance : -1;
    }

    private static boolean isEmptyAllQueue() {
        boolean isEmpty= true;
        for(Queue queue : queueList){
            if(!queue.isEmpty()){
                isEmpty = false;
            }
        }
        return isEmpty;
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new  InputStreamReader(System.in));
        String[] sizeSplit = br.readLine().split(" ");
        M = Integer.parseInt(sizeSplit[0]);
        N = Integer.parseInt(sizeSplit[1]);

        map = new int[N][M];
//        discovered = new boolean[N][M];
        queueList = new ArrayList<>();

        for(int i = 0; i < N; i++){
            String[] rowSplit = br.readLine().split(" ");
            for(int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(rowSplit[j]);
                if(map[i][j] == 1){
                    Queue<Cell> tempQueue = new LinkedList<>();
                    tempQueue.add(new Cell(i,j,0));
                    queueList.add(tempQueue);
                }
                if(map[i][j] == 0) countVisitable++;
            }
        }
    }
}
