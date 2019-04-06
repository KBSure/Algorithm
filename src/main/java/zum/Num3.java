package zum;

public class Num3 {
    public static void main(String[] args) {

    }
    class Solution {
        private boolean[] visited;
        private int answer;
        public int solution(int[] A) {
            // write your code in Java SE 8
            visited = new boolean[A.length];
            int startIdx = 0;
            int currentIdx = 0;
            int length = 0;
            for(int i = 0; i < A.length; i++){
                if(visited[i]) continue;
                length = 0;
                startIdx = i;
                currentIdx = i;
                do {
                    visited[currentIdx] = true;
                    currentIdx = A[currentIdx];
                    length++;
                }
                while(currentIdx != startIdx);
                answer = length > answer ? length : answer;
            }
            return answer;
        }
    }
}
