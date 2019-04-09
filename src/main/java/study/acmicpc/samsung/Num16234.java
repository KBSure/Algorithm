package study.acmicpc.samsung; //인구 이동

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Num16234 {
    private static int N, L, R;
    private static int[][] arr;
    private static final int[][] DIRECTION = {{-1,0,1,0},{0,1,0,-1}};
    static class Union{
        int sum;
        int count;
        List<Node> nodeList;

        Union(){
            nodeList = new ArrayList<>();
        }

        void move(){
            int aver = sum / count;
            for(Node node : nodeList){
                arr[node.hereI][node.hereJ] = aver;
            }
        }
    }

    static class Node{
        int hereI, hereJ;

        Node(int hereI, int hereJ){
            this.hereI = hereI;
            this.hereJ = hereJ;
        }
    }

    public static void main(String[] args) throws IOException {
        Initializer.init();
        int answer = 0;
        while(dfsAll(Initializer.booleanArr())){
            answer++;
        }        //true이면 dfsALll 돌린다.
        System.out.println(answer);
    }

    private static boolean dfsAll(boolean[][] visitedAll){ // dfsAll은 인구이동을 더 해야 하는지 판별해준다.
        // dfs()가 몇번 호출되었는지 세야 한다.
        int callCount = 0;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(visitedAll[i][j]) continue;
                Union union = new Union();
                dfs(union, i, j, visitedAll);
                callCount++;
                // 평균 내서 분할해준다.
                union.move();
            }
        }
        if(callCount == N*N) return false; // false면 인구 이동 Stop
        return true;
    }

    private static void dfs(Union union, int hereI, int hereJ, final boolean[][] visited){ // {sum, count}
        visited[hereI][hereJ] = true;
        union.nodeList.add(new Node(hereI, hereJ));
        union.sum += arr[hereI][hereJ];
        union.count++;

        for(int i = 0; i < 4; i++){
            int thereI = hereI + DIRECTION[0][i];
            int thereJ = hereJ + DIRECTION[1][i];
            if(thereI < 0 || thereI > N-1 || thereJ < 0 || thereJ > N-1) continue; //인덱스 유효하지 않으면
            if(visited[thereI][thereJ]) continue; //방문했으면
            int distance = Math.abs(arr[hereI][hereJ] - arr[thereI][thereJ]);
            if(distance < L || distance > R) continue; // LR 조건에 안 맞으면

            dfs(union, thereI, thereJ, visited);
        }
    }

    static class Initializer{
        private static boolean[][] booleanArr(){
            boolean[][] booleans = new boolean[N][];
            for(int i = 0; i < N; i++){
                booleans[i] = new boolean[N];
            }
            return booleans;
        }
        private static void init() throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String[] split = br.readLine().split(" ");
            N = Integer.parseInt(split[0]);
            L = Integer.parseInt(split[1]);
            R = Integer.parseInt(split[2]);

            arr = new int[N][];
            for(int i = 0; i < N; i++){
                arr[i] = new int[N];
                String[] split1 = br.readLine().split(" ");
                for(int j = 0; j < N; j++){
                    arr[i][j] = Integer.parseInt(split1[j]);
                }
            }
        }
    }
}
