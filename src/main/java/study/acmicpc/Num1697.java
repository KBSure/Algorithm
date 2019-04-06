package study.acmicpc;

import java.util.LinkedList;
import java.util.Scanner;

public class Num1697 {

    static final int NUM = 100001;
    private static int adj [][] = new int[NUM][3];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        bfs(scanner.nextInt(), scanner.nextInt());
    }

    private static void init_adj(){
        for(int i = 0; i < NUM; i++){
            if(i*2 < NUM && i*2 != i) { //이렇게 예외 처리를 하거나
                adj[i][0] = i*2;
            }else{
                adj[i][0] = -1;
            }
            if(i-1 >= 0){
                adj[i][1] = i-1;
            }else{
                adj[i][1] = -1;
            }
            if(i+1 < NUM){
                adj[i][2] = i+1;
            }else{
                adj[i][2] = -1;
            }
        }
    }
    private static void bfs(int start, int end){
        //인접된 정점 기록한 int 2차배열
        //검사할 정점 리스트 queue<Integer>
        //정점까지의 distance 기록 int 배열

        init_adj();

        LinkedList<Integer> q = new LinkedList<>();
        int distance [] = new int[NUM];
        boolean discovered [] = new boolean[NUM];
        q.addLast(start);
        distance[start] = 0;
        discovered[start] = true; //이렇게 초기화 작업 중요.
        // 교훈 : 값을 Injection 하는 부분이나, 배열의 맨 앞이나 맨 뒤에서의 동작 등을 살펴보자.


        while(!q.isEmpty()){
            int here = q.pollFirst();

            if(here == end){ //정답 검사
                System.out.println(distance[here]);
                return;
            }

            for(int i = 0; i < adj[here].length; i++){ //인접점 찾기
                int there = adj[here][i];
                if(there != -1 && discovered[there] == false){ //갈 수 있고, 가지 않았다면
                    distance[there] = distance[here] + 1;
                    discovered[there] = true;
                    q.addLast(there);
                }
            }
        }
    }
}
