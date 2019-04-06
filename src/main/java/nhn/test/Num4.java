package nhn.test;

import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.util.ArrayList;
        import java.util.Collections;
        import java.util.List;

public class Num4 {
    private static int[][] map;
    private static int size;
    private static boolean[][] visited;
    private static final int[][] DIRECTION = new int[][]{ {0, 1, 0, -1}, {-1, 0, 1, 0} };
    private static List<Integer> result;


    public static void main(String[] args) throws Exception{
        init();
        dfsAll();

        if(result.size() == 0){
            System.out.println(result.size());
            return;
        }

        Collections.sort(result);
        System.out.println(result.size());
        for(int i = 0; i < result.size(); i++){
            if(i == 0){
                System.out.print(result.get(i));
                continue;
            }
            System.out.print(" ");
            System.out.print(result.get(i));
        }
    }

    private static void dfsAll(){
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                if(!visited[i][j] && map[i][j] == 1){
                    int hereI = i;
                    int hereJ = j;
                    result.add(dfs(hereI, hereJ));
                }
            }
        }
    }

    private static int dfs(int hereI, int hereJ){
        visited[hereI][hereJ] = true;
        int count = 0;
        for(int k = 0; k < 4; k++){
            int thereI = hereI + DIRECTION[0][k];
            int thereJ = hereJ + DIRECTION[1][k];
            if(thereI == -1 || thereI == size) continue;
            if(thereJ == -1 || thereJ == size) continue;
            if(!visited[thereI][thereJ] && map[thereI][thereJ] == 1){
                count += dfs(thereI, thereJ);
            }
        }
        return count + 1;
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        size = Integer.parseInt(br.readLine());
        map = new int[size][size];
        for(int i = 0; i < size; i++){
            String[] split = br.readLine().split(" ");
            for(int j = 0; j < size; j++){
                map[i][j] = Integer.parseInt(split[j]);
            }
        }
        visited = new boolean[size][size];
        result = new ArrayList<>();
    }
}
