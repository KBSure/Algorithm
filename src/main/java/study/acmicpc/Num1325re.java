package study.acmicpc; //효율적인 해킹

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Num1325re {
    private static int N, M;
    private static List<Integer>[] adj;
    private static Queue<Integer> queue;

    public static void main(String[] args) throws IOException {
        init();
        int maxCount = 0;
        List<Integer> answerList = new ArrayList<>();

        for(int i = 1; i <= N; i++){
            int currentCount = bfs(i);
            if(maxCount < currentCount){
                maxCount = currentCount;
                answerList.clear();
                answerList.add(i);
            }else if(maxCount == currentCount){
                answerList.add(i);
            }
        }
        for(int i = 0; i < answerList.size() - 1; i++){
            System.out.print(answerList.get(i) + " ");
        }
        if(answerList.size() != 0)
            System.out.print(answerList.get(answerList.size()-1));
    }

    private static int bfs(int startNum) {
        // 1 ~ N 까지 인접 돌면서 Max 갱신
        int count = 0;
        boolean[] discovered = new boolean[N+1];

        queue.offer(startNum);
        while(!queue.isEmpty()){
            Integer pollNum = queue.poll();
            count++;
            for(Integer num : adj[pollNum]){
                if(!discovered[num]){
                    queue.offer(num);
                    discovered[num] = true;
                }
            }
        }
        return count;
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        N = Integer.parseInt(split[0]);
        M = Integer.parseInt(split[1]);

        adj = new ArrayList[N+1];
        for(int i = 1; i <= N; i++){
            adj[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++){
            String[] line = br.readLine().split(" ");
            int A = Integer.parseInt(line[0]);
            int B = Integer.parseInt(line[1]);
            adj[B].add(A);
        }
        queue = new LinkedList<>();
    }
}
