package study.codility;

import java.util.Arrays;

import static java.lang.Math.max;

public class NumberSolitaire {
    public static void main(String[] args) {

    }

    class Solution {
        private int[] cache;
        public int solution(int[] A) {
            // write your code in Java SE 8
            cache = new int[A.length];
            Arrays.fill(cache, Integer.MIN_VALUE);
            return dp(A, 0);
        }

        public int dp(final int[] A, int idx){
            if(idx == A.length - 1) return A[idx];
            if(cache[idx] != Integer.MIN_VALUE) return cache[idx];
            int max = Integer.MIN_VALUE;
            for(int i = 1; i <= 6; i ++){
                int thereIdx = idx + i;
                if(thereIdx <= A.length - 1)
                    max = max(max, dp(A, thereIdx));
            }
            return cache[idx] = max + A[idx];
        }
    }
}
