package study.acmicpc.review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
//숨바꼭질
public class Num1697re {
    private static int K;
    private static int N;
    private static boolean[] cache;
    private static Queue<Node> queue;

    public static void main(String[] args) throws IOException {
        init();
        queue.add(new Node(K, 0));

        while(!queue.isEmpty()){
            Node here = queue.poll();
            int hNum = here.getNum();
            int hLevel = here.getLevel();
            if(hNum < 0 || hNum > 100000) continue; // -1이거나 200000을 넘어가면 out
            if(N == hNum){ // 정답인지 비교
                System.out.println(hLevel);
                return;
            }

            if(!cache[hNum]){ //cache에 있는지 cache에 없으면
                cache[hNum] = true;
                queue.add(new Node(hNum+1, hLevel+1));
                queue.add(new Node(hNum-1, hLevel+1));
                queue.add(new Node(hNum*2, hLevel+1));
            }
        }
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        K = Integer.parseInt(split[0]);
        N = Integer.parseInt(split[1]);
        cache = new boolean[100001];
        queue = new LinkedList<>();
    }

    private static class Node{
        private int num;
        private int level;
        Node(int num, int level){
            this.num = num;
            this.level = level;
        }

        public int getNum() {
            return num;
        }

        public int getLevel() {
            return level;
        }
    }
}
