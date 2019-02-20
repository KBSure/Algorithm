package zum;

public class Num1 {
    public static void main(String[] args) {

    }
    class Solution {
        private boolean[] openCheckArray;
        private int answer;
        public int solution(int[] A) {
            openCheckArray = new boolean[A.length + 1];
            // write your code in Java SE 8
            // 반복문 돌리면서 boolean 배열 체크
            // 불켜질 수 있는 인덱스 경계 인덱스 boundary
            int boundary = 1;
            for(int i = 0; i < A.length; i++){
                openCheckArray[A[i]] = true;
                if(A[i] == boundary) {
                    int forI = 0;
                    for (forI = boundary; forI < openCheckArray.length && openCheckArray[forI]; forI++);
                    answer++;
                    boundary = forI;
                }
            }
            return answer;
        }
    }
}
