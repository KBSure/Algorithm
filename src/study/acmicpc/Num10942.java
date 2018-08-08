package study.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

//팰린드롬?
public class Num10942 {
    private static int[] A;
    private static int[][] cache;
    private static int[][] SE;
    private static int M;
    public static void main(String[] args) throws IOException {
        init();
        for(int i = 0; i < M; i++){
            System.out.println(palindrome(SE[i][0], SE[i][1]));
        }
    }

    private static int palindrome(int s, int e){
        if(cache[s][e] != -1) return cache[s][e];
        if(s >= e) return 1;

        if(A[s] == A[e]){
            return cache[s][e] = palindrome(s + 1, e - 1);
        }
        cache[s][e] = 0; // 기저사례(Not equal)로, 직접 return 0하는 것 저장
        return 0;
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        cache = new int[N+1][N+1];
        for(int i = 0; i < N+1; i++){
            Arrays.fill(cache[i], -1);
        }

        String[] split = br.readLine().split(" ");
        A = new int[N+1];
        for(int i = 1; i < N+1; i++){
            A[i] = Integer.parseInt(split[i-1]);
        }

        M = Integer.parseInt(br.readLine());

        SE = new int[M][2];
        for(int i = 0; i < M; i++){
            String[] split1 = br.readLine().split(" ");
            SE[i][0] = Integer.parseInt(split1[0]);
            SE[i][1] = Integer.parseInt(split1[1]);
        }

    }
}
