package Line.realtest2019;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Num5 {
    private static int c;
    private static int b;
    private static Queue<Node> queue;
    private static boolean[] cache;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        c = Integer.parseInt(split[0]);
        b = Integer.parseInt(split[1]);
        queue = new LinkedList<>();
        cache = new boolean[200_000];

        int hereC = c;
        queue.add(new Node(b,0));

        while(!queue.isEmpty()){
            Node hereB = queue.poll();
            int hBNum = hereB.num;
            int hBLevel = hereB.level;

            hereC = c + hereB.level*(hereB.level+1)/2;

            if(hereC > 200_000){
                System.out.println(-1);
                return;
            }

            if(hBNum < 0 || hBNum > 200_000) continue;

            if(hereC == hBNum){ // 정답인지 비교
                System.out.println(hBLevel);
                return;
            }

            if(!cache[hBNum]){ //cache에 있는지 cache에 없으면
                cache[hBNum] = true;
                queue.add(new Node(hBNum+1, hBLevel+1));
                queue.add(new Node(hBNum-1, hBLevel+1));
                queue.add(new Node(hBNum*2, hBLevel+1));
            }
        }

    }

    static class Node {
        int num;
        int level;

        Node(int num, int level) {
            this.num = num;
            this.level = level;
        }
    }
}
