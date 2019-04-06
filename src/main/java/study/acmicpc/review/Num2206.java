package study.acmicpc.review; // 벽 부수고 이동하기

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Num2206 {
    private static int N, M;
    private static boolean[][] map;
    private static Queue<Node> queue;
    private static final int[][] DIRECTION ={{-1,0,1,0},{0,1,0,-1}};
    private static int[][] discovered;
    private static final int UNDISCOVERED = 0;
    private static final int DISCOVERED_BY_BROKEN = 2;
    private static final int DISCOVERED_BY_UNBROKEN = 1;

    public static void main(String[] args) throws IOException {
        init();
        int answer = findMinDistance();
        System.out.println(answer);
    }

    private static int findMinDistance() {
        queue.offer(new Node(0, 0, 1, false));
        while(!queue.isEmpty()){
            Node hereNode = queue.poll();
            if(hereNode.getHereI() == N-1 && hereNode.getHereJ() == M-1) return hereNode.getDepth();
            List<Node> nextNodeList = hereNode.nextNode();
            for(Node nextNode : nextNodeList){
                queue.offer(nextNode);
            }
        }
        return -1;
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        N = Integer.parseInt(split[0]);
        M = Integer.parseInt(split[1]);

        map = new boolean[N][M];
        discovered = new int[N][M];

        for(int i = 0; i < N; i++){
            map[i] = new boolean[M];
            discovered[i] = new int[M];
            String line = br.readLine();
            for(int j = 0; j < M; j++){
                map[i][j] = line.charAt(j) == '1';
            }
        }

        queue = new LinkedList<>();

    }

    static class Node{
        private int hereI, hereJ;
        private int depth;
        private boolean wasBroken;
        Node(int hereI, int hereJ, int depth, boolean wasBroken){
            this.hereI = hereI;
            this.hereJ = hereJ;
            this.depth = depth;
            this.wasBroken = wasBroken;
        }

        public int getHereI() {
            return hereI;
        }

        public int getHereJ() {
            return hereJ;
        }

        public int getDepth() {
            return depth;
        }

        List<Node> nextNode(){
            List<Node> nextNodeList = new ArrayList<>();
            for(int i = 0; i < 4; i++){
                int thereI = hereI + DIRECTION[0][i];
                int thereJ = hereJ + DIRECTION[1][i];
                boolean wasThereBroken = wasBroken;
                if(thereI < 0 || thereI > N-1 || thereJ < 0 || thereJ > M-1) continue;
                if(map[thereI][thereJ]){
                    if(wasBroken) continue;
                    wasThereBroken = true;
                }
                switch (discovered[thereI][thereJ]){
                    case UNDISCOVERED :
                        discovered[thereI][thereJ] = wasThereBroken ? DISCOVERED_BY_BROKEN : DISCOVERED_BY_UNBROKEN;
                        break;
                    case DISCOVERED_BY_UNBROKEN :
                        continue;
                    case DISCOVERED_BY_BROKEN :
                        if(wasThereBroken) continue;
                        discovered[thereI][thereJ] = DISCOVERED_BY_UNBROKEN;
                        break;
                    default :
                        break;
                }

                nextNodeList.add(new Node(thereI, thereJ, depth + 1, wasThereBroken));
            }
            return nextNodeList;
        }
    }
}
