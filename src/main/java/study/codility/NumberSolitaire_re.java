package study.codility;

import static java.lang.Math.max;

public class NumberSolitaire_re {
    public static void main(String[] args) {

    }

    class Solution {
        private int[] cache;
        public int solution(int[] A) {
            // write your code in Java SE 8
            cache = new int[6];
            for(int i = 0; i < 6; i++){
                cache[i] = A[0];
            }
            for(int i = 1; i < A.length; i++){
                int cacheMax = cache[0];
                for(int j = 1; j < 6; j++){
                    cacheMax = max(cacheMax, cache[j]);
                }
                cache[i%6] = cacheMax + A[i];
            }
            return cache[(A.length-1)%6];
        }
    }
}
