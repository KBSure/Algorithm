package Line.test;

public class Test1 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] solution1 = solution.solution(new int[][]{{1, 1}, {2, 2}, {1, 2}});

    }
    static class Solution {
        public int[] solution(int[][] v) {
            int[] answer = new int[2];
            boolean[] isThisNum = {true, true};
            h: for (int h = 0; h < 2; h++) {
                for (int i = 0; i < v.length; i++) {
                    answer[h] = v[i][h];
                    isThisNum[h] = true;
                    for (int j = 0; j < v.length; j++) {
                        if (i != j && answer[h] == v[j][h]) {
                            isThisNum[h] = !isThisNum[h];
                        }
                    }
                    if(isThisNum[h]) break;
                }
            }

            return answer;
        }
    }
}
