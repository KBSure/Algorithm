package study.acmicpc.review; // 미로찾기

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Num2178 {
    private static int N, M;
    private static int[][] map;
    private static boolean[][] discovered;
    private static Queue<Node> queue;
    private static final int[][] DIRECTION = {{-1,0,1,0},{0,1,0,-1}};
    public static void main(String[] args) throws IOException {
        init();
        int answer = bfs();
        System.out.println(answer);
    }

    private static class Node {
        int hereI, hereJ;
        int depth;

        Node(int hereI, int hereJ, int depth){
            this.hereI = hereI;
            this.hereJ = hereJ;
            this.depth = depth;
        }

        List<Node> searchAdj() {
            List<Node> adjNodeList = new ArrayList<>();
            for(int i = 0; i < 4; i++){
                int thereI = hereI + DIRECTION[0][i];
                int thereJ = hereJ + DIRECTION[1][i];
                if(thereI < 0 || thereI > N-1 || thereJ < 0 || thereJ > M-1) continue;
                if(map[thereI][thereJ] == 0) continue;
                if(discovered[thereI][thereJ]) continue;
                adjNodeList.add(new Node(thereI, thereJ, depth + 1));
                discovered[thereI][thereJ] = true;
            }
            return adjNodeList;
        }
    }

    private static int bfs() {
        queue.offer(new Node(0,0, 1));
        while(!queue.isEmpty()){
            Node here = queue.poll();
            if(here.hereI == N-1 && here.hereJ == M-1) return here.depth;
            List<Node> adjNodeList = here.searchAdj();
            for(Node adjNode : adjNodeList){
                queue.offer(adjNode);
            }
        }
        return -1;
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        N = Integer.parseInt(split[0]);
        M = Integer.parseInt(split[1]);
        map = new int[N][];
        discovered = new boolean[N][];
        for(int i = 0; i < N; i++){
            map[i] = new int[M];
            discovered[i] = new boolean[M];
            String row = br.readLine();
            for(int j = 0; j < M; j++){
                map[i][j] = row.charAt(j) == '1' ? 1 : 0;
            }
        }
        queue = new LinkedList<>();
    }
}
