package study.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class Num1158 {
    private static int n, m;
    private static List<Integer> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        n = Integer.parseInt(split[0]);
        m = Integer.parseInt(split[1]);
        list = new LinkedList<>();
        for(int i = 1; i <= n; i++){
            list.add(i);
        }
        int kill = 0;
        System.out.print("<");
        while(n-- > 0) {
            if (kill == list.size()) kill = 0;
            for (int i = 0; i < m-1; i++) {
                kill++;
                if (kill == list.size()) kill = 0;
            }
            System.out.print(n == 0 ? list.get(kill) : list.get(kill) + ", ");
            list.remove(kill);
        }
        System.out.print(">");

    }
}
