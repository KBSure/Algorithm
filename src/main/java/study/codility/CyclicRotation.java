package study.codility;

public class CyclicRotation {
    public static void main(String[] args) {

    }
    class Solution {
        public int[] solution(int[] A, int K) {
            // write your code in Java SE 8
            if(A.length == 0 || K == 0) return A;
            int[] B = new int[A.length];

            int rotation = K % A.length;
            int N = A.length - rotation;
            for(int i = 0; i < N; i++){
                B[i+rotation] = A[i];
            }
            for(int i = N; i < A.length; i++){
                B[i-N] = A[i];
            }
            return B;
        }
    }
}
