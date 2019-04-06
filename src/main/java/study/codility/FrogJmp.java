package study.codility;

public class FrogJmp {
    public static void main(String[] args) {

    }

    static class Solution {
        public int solution(int X, int Y, int D) {
            // write your code in Java SE 8
            int distance = Y - X; //0일 때도 체크
            return distance % D == 0 ? distance / D : distance / D + 1;
        }
    }
}
