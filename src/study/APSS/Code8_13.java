package study.APSS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Code8_13 {
    private static int[][] cache;
    private static int[] A;
    private static int[] B;
    private static int n;
    private static int m;
    private static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int C = Integer.parseInt(br.readLine());
        for(int i = 0; i < C; i++){
            A = new int[100];
            B = new int[100];
            cache = new int[101][101];
            for(int a = 0; a < 101; a++){
                Arrays.fill(cache[a], -1);
            }

            String[] split = br.readLine().split(" ");
            n = Integer.parseInt(split[0]);
            m = Integer.parseInt(split[1]);

            String[] split1 = br.readLine().split(" ");
            for(int j = 0; j < n; j++){
                A[j] = Integer.parseInt(split1[j]);
            }
            String[] split2 = br.readLine().split(" ");
            for(int j = 0; j < m; j++){
                B[j] = Integer.parseInt(split2[j]);
            }

            System.out.println(jlis(-1,-1, 0));
        }
    }

    private static int jlis(int indexA, int indexB, int depth){
        String s = "depth : " + depth + "  indexA : " + indexA + "  indexB : " + indexB;
        if (indexA >= 0) s += "  A[indexA] : " + A[indexA];
        if (indexB >= 0) s += "  B[indexB] : " + B[indexB];

        System.out.println(s);
        if(cache[indexA+1][indexB+1] != -1) return cache[indexA+1][indexB+1];

        int ret = 0;
        int a = indexA == -1 ? -1 : A[indexA];
        int b = indexB == -1 ? -1 : B[indexB];
        int maxElement = Math.max(a,b);
        System.out.println("maxElement : " + maxElement);

        for(int nextA = indexA+1; nextA < n; ++nextA){
            if(maxElement < A[nextA]){
                System.out.println("-- nextA로 호출 직전");
                ret = Math.max(ret, jlis(nextA, indexB, depth+1) + 1);
                cache[indexA+1][indexB+1] = ret;
            }
        }
//        System.out.println("--------------------------------------");
        for(int nextB = indexB+1; nextB < n; ++nextB){
            if(maxElement < B[nextB]){
                System.out.println("== nextB로 호출 직전");
                ret = Math.max(ret, jlis(indexA, nextB, depth+1) + 1);
                cache[indexA+1][indexB+1] = ret;
            }
        }
        System.out.println("  depth : " + depth + "  indexA : " + indexA + "  indexB : " + indexB +  "  ret : " + ret);
        return ret;
    }
}
