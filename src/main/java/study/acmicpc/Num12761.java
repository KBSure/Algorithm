package study.acmicpc;

import java.util.LinkedList;
import java.util.Scanner;

public class Num12761 {

    private static final int NUM = 100001;
    private static int adj [][] = new int[NUM][8];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        bfs(scanner.nextInt(), scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
    }

    private static void init_adj(int a, int b){
        for(int i = 0; i < NUM; i++){
            if(i-1 >= 0) adj[i][0] = i-1;
            else adj[i][0] = -1;
            if(i+1 < NUM) adj[i][1] = i+1;
            else adj[i][1] = -1;
            if(i-a >= 0) adj[i][2] = i-a;
            else adj[i][2] = -1;
            if(i+a < NUM) adj[i][3] = i+a;
            else adj[i][3] = -1;
            if(i-b >= 0) adj[i][4] = i-b;
            else adj[i][4] = -1;
            if(i+b < NUM) adj[i][5] = i+b;
            else adj[i][5] = -1;
            if(i*a < NUM) adj[i][6] = i*a;
            else adj[i][6] = -1;
            if(i*b < NUM) adj[i][7] = i*b;
            else adj[i][7] = -1;
        }
    }
    private static void bfs(int powerA, int powerB, int start, int end){
        init_adj(powerA, powerB);

        LinkedList<Integer> q = new LinkedList<>();
        boolean discovered [] = new boolean[NUM];
        int distance [] = new int[NUM];

        q.addLast(start);
        discovered[start] = true;
        distance[start] = 0;

        while(q!=null){
            int here = q.pollFirst();

            if(here == end){
                System.out.println(distance[here]);
                return;
            }

            for(int i = 0; i < 8; i++){
                int there = adj[here][i];
                if(there != -1 && discovered[there] == false){
                    q.addLast(there);
                    discovered[there] = true;
                    distance[there] = distance[here] + 1;
                }
            }
        }
    }
}
