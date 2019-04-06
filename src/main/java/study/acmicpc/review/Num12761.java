package study.acmicpc.review;
//돌다리
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Num12761 {
    private static int A;
    private static int B;
    private static int N;
    private static int M;
    private static Queue<Node> queue;
    private static boolean[] cache;

    public static void main(String[] args) throws IOException {
        init();
        queue.add(new Node(N, 0));
        while(!queue.isEmpty()){
            Node here = queue.poll();
            if(here.num < 0 || here.num > 100000) continue;
            if(here.num == M){
                System.out.println(here.level);
                return;
            }
            if(!cache[here.num]){
                int num = here.num;
                int level = here.level+1;
                queue.add(new Node(num+1, level));
                queue.add(new Node(num-1, level));
                queue.add(new Node(num+A, level));
                queue.add(new Node(num-A, level));
                queue.add(new Node(num+B, level));
                queue.add(new Node(num-B, level));
                queue.add(new Node(num*A, level));
                queue.add(new Node(num*B, level));
                cache[num] = true;
            }
        }
    }

    private static class Node{
        int num;
        int level;

        Node(int num, int level){
            this.num = num;
            this.level = level;
        }
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        A = Integer.parseInt(split[0]);
        B = Integer.parseInt(split[1]);
        N = Integer.parseInt(split[2]);
        M = Integer.parseInt(split[3]);
        queue = new LinkedList<>();
        cache = new boolean[100001];
    }
}
