package study.acmicpc.samsung; //아기 상어

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Num16236 {
    private static int N;
    private static int[][] fishSizeArray;
    private static Shark babyShark;
    private static int answer = 0;
    public static void main(String[] args) throws IOException {
        Initializer.init();

        // bfs 쓰고, 먹이 먹었으면 size check
        while(bfs());

        System.out.println(answer);

    }

    private static boolean bfs(){
        Queue<Node> queue = new LinkedList<>();
        boolean[][] discovered = new boolean[N][];
        for(int i = 0; i < N; i++){
            discovered[i] = new boolean[N];
        }
        List<Node> feedList = new ArrayList<>();
        final int[][] DIRECTION = {{-1,0,1,0},{0,1,0,-1}};

        queue.add(new Node(babyShark.hereI, babyShark.hereJ, 0));
        discovered[babyShark.hereI][babyShark.hereJ] = true;
        //만약에 먹을 걸 못 구했다면?
        while(!queue.isEmpty()){
            int queueSize = queue.size();
            for(int i = 0; i < queueSize; i++){
                Node pollNode = queue.poll();
                // 작은 물고기이면,,,
                int fishSize = fishSizeArray[pollNode.hereI][pollNode.hereJ];
                if(fishSize != 0 && fishSize < babyShark.size){
                    feedList.add(pollNode);
                    continue;
                }

                if(!feedList.isEmpty()) continue;

                for(int j = 0; j < 4; j++){
                    int thereI = pollNode.hereI + DIRECTION[0][j];
                    int thereJ = pollNode.hereJ + DIRECTION[1][j];
                    if(thereI < 0 || thereI > N-1 || thereJ < 0 || thereJ > N-1) continue;
                    if(discovered[thereI][thereJ]) continue;
                    // 더 큰 물고기가 있으면 pass
                    if(fishSizeArray[thereI][thereJ] > babyShark.size){
                        discovered[thereI][thereJ] = true;
                        continue;
                    }
                    discovered[thereI][thereJ] = true;
                    queue.add(new Node(thereI, thereJ,  pollNode.level + 1));
                }
            }

            // 먹이 아직 못 찾았으면 계속 bfs 진행
            if(feedList.isEmpty()) continue;

            // feedList sort
            Collections.sort(feedList);

            // 먹으러 간다.
            Node node = feedList.get(0);
            fishSizeArray[node.hereI][node.hereJ] = 0; // 0으로 만들고
            babyShark.countForSizeUp--;
            babyShark.hereI = node.hereI;
            babyShark.hereJ = node.hereJ;
            answer += node.level;
            if(babyShark.countForSizeUp == 0){
                babyShark.size++;
                babyShark.countForSizeUp = babyShark.size;
            }

//            Initializer.print(node.hereI, node.hereJ);

            return true; // 먹이 구했으면 true
        }
        return false; //먹이 못 구했으면 false
    }

    static class Node implements Comparable<Node>{
        int hereI;
        int hereJ;
        int level;

        // fishSizeArray index 참조해서 먹을 수 있는지, 지나갈 수 있는지 등 판결
        Node(int hereI, int hereJ, int level){
            this.hereI = hereI;
            this.hereJ = hereJ;
            this.level = level;
        }

        @Override
        public int compareTo(Node o) {
            if(this.hereI == o.hereI) return this.hereJ - o.hereJ;
            return this.hereI - o.hereI;
        }
    }

    static class Shark{
        int size;
        int countForSizeUp;
        int hereI;
        int hereJ;

        Shark(){
            this.size = 2;
            this.countForSizeUp = this.size;
        }

        Shark(int hereI, int hereJ, int size){
            this.hereI = hereI;
            this.hereJ = hereJ;
            this.size = size;
            this.countForSizeUp = size;
        }
    }

    static class Initializer{
        private static void print(int i, int j){
            printFishSizeArray(i, j);
        }

        private static void printFishSizeArray(int hereI, int hereJ){
            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    if(hereI == i && hereJ == j){
                        System.out.print(fishSizeArray[i][j]+"\"");
                        continue;
                    }
                    System.out.print(fishSizeArray[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println("====================");
        }

        private static void init() throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            N = Integer.parseInt(br.readLine());

            //fishSIzeArray 초기화
            fishSizeArray = new int[N][];
            for(int i = 0; i < N; i++){
                String[] split = br.readLine().split(" ");
                fishSizeArray[i] = new int[N];
                for(int j = 0; j < N; j++){
                    fishSizeArray[i][j] = Integer.parseInt(split[j]);
                    if(fishSizeArray[i][j] == 9){
                        babyShark = new Shark(i, j, 2);
                        fishSizeArray[i][j] = 0;
                        // 아기상어 위치 파악, 빈자리로 표시
                    }
                }
            }

        }
    }

}
