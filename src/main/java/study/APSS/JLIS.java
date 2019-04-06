package study.APSS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

import static java.lang.Math.max;

public class JLIS {
    private static int[] A, B;
    private static int n, m;
    private static int[][] cache;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int C = Integer.parseInt(br.readLine());
        for(int i = 0; i < C; i++){
            String[] split = br.readLine().split(" ");
            n = Integer.parseInt(split[0]);
            m = Integer.parseInt(split[1]);
            cache = new int[n+1][m+1];
            for(int j = 0; j < n+1; j++){
                Arrays.fill(cache[j], -1);
            }

            A = new int[n];
            String[] split1 = br.readLine().split(" ");
            for(int j = 0; j < n; j++){
                A[j] = Integer.parseInt(split1[j]);
            }
            B = new int[m];
            String[] split2 = br.readLine().split(" ");
            for(int j = 0; j < m; j++){
                B[j] = Integer.parseInt(split2[j]);
            }

            System.out.println(jlis(-1,-1));
        }
    }

    private static int jlis(int indexA, int indexB){

        if(cache[indexA+1][indexB+1] != -1) return cache[indexA+1][indexB+1];

        int ret = 0;

        int elementA = indexA == -1 ? -1 : A[indexA];
        int elementB = indexB == -1 ? -1 : B[indexB];
        int maxElement = max(elementA, elementB);

        for(int next = indexA + 1; next < n; next++){
            if(maxElement < A[next]){
                ret = max(ret, jlis(next,indexB) + 1);
                cache[indexA+1][indexB+1] = ret;
            }
        }
        for(int next = indexB + 1; next < m; next++){
            if(maxElement < B[next]){
                ret = max(ret, jlis(indexA,next) + 1);
                cache[indexA+1][indexB+1] = ret;
            }
        }
        return ret;
    }
}
