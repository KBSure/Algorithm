package zum;

public class Num2 {
    public static void main(String[] args) {

    }
    class Solution {
        private int answer;
        public int solution(int[] A) {
            // write your code in Java SE 8
            // 시작 index -> 연속으로 올라가거나 연속으로 내려가면 다시 시작 index
            // 끝 index -> 연속으로 올라가거나 연속으로 내려갈 떄
            int period = 1;
            if (A.length == 1) return period;
            int slope = 0;
            //같은 경우는 starIdx 만 증가
            for (int i = 0; i < A.length - 1; i++) { // 마지막 이전 인덱스
                int nextSlope = A[i + 1] - A[i];
                if (slope < 0) { // 내려갔다가
                    if (nextSlope > 0) { //올라가면
                        period++;
                    } else if (nextSlope < 0) { //또 내려가면
                        if(period > answer) answer = period; //검토 필요!!
                        period = 2;
                    } else { // 같으면
                        if(period > answer) answer = period;
                        period = 1;
                    }
                } else if (slope > 0) { // 올라갔다
                    if(nextSlope < 0){ //내려가면
                        period++;
                    } else if (nextSlope > 0){ //올라가면
                        if(period > answer) answer = period;
                        period = 2;
                    }else{
                        if(period > answer) answer = period;
                        period = 1;
                    }
                } else { // 쭉 됐었다면
                    if(nextSlope > 0){ // 올라가면
                        period++;
                    }else if(nextSlope < 0){ //내려가면
                        period++;
                    }else{ // 쭉 가면
                        period = 1;
                    }
                }
                slope = nextSlope;
            }
            if(period > answer) answer = period;

            return answer;
        }
    }
}
