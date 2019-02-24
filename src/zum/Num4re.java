package zum;

import static java.lang.Math.max;
import static java.lang.StrictMath.pow;

public class Num4re {
    public static void main(String[] args) {
//        int answer = Solution.solution(new int[][] {{9,1,1,0,7},{1,0,2,1,0},{1,9,1,1,0}});
//        int answer = Solution.solution(new int[][] {{1,1,1},{1,3,4},{1,4,3}});
//        int answer = Solution.solution(new int[][] {{0,1,5,0,0}});
        int answer = Solution.solution(new int[][] {{0},{1},{5},{0},{0}});
        System.out.println(answer);
    }
    static class Solution{
        private static int rowSize, colSize, answer;
        private static final int[][] DIRECTION = {{-1,0,1,0},{0,1,0,-1}};
        private static int[][] board;
        private static boolean[][] visited;
        public static int solution(int[][] Board){
            board = Board;
            rowSize = Board.length;
            colSize = Board[0].length;
            visited = new boolean[rowSize][];
            for(int i = 0; i < rowSize; i++) {
                visited[i] = new boolean[colSize];
            }
            // 1. for문을 돌려서 max 숫자를 찾고, 그 max 위치에서 dfs를 돌린다.
            // bfs가 아니라 dfs를 쓴 이유는 top-down 방식으로 크기를 비교하여 큰 값을 리턴하는 방식이 가시적이기 떄문이다.
            // queue 2개 이상을 통해 bfs 접근하는 방식도 있다. 그러나 탐색 깊이가 고정적인 상황에서 굳이 queue를 쓸 필요는 없어 보인다.
            // 2. dfs는 가장 큰 값을 리턴하고, 리턴한 값들 중 max값을 정답으로 내놓는다.
            // 3. 단, 예외로 열이나 행의 크기가 1인 Board의 경우는 시작점의 index를 잘 처리한다.

            // 예외상황
            if(rowSize == 1){
                for(int i = 0; i < rowSize; i++){
                    for(int j = 0; j < colSize; j++){
                        if(j + 3 > colSize-1 && j - 3 < 0) continue;
                        answer = max(answer, dfs(i, j, 1, visited));
                    }
                }
                return answer;
            }else if(colSize == 1){
                for(int i = 0; i < rowSize; i++){
                    for(int j = 0; j < colSize; j++){
                        if(i + 3 > rowSize-1 && i - 3 < 0) continue;
                        answer = max(answer, dfs(i, j, 1, visited));
                    }
                }
                return answer;
            }


            // 일반상황
            int maxNum = 0;
            for(int i = 0; i < rowSize; i++){
                for(int j = 0; j < colSize; j++){
                    if(maxNum < board[i][j]) maxNum = board[i][j];
                }
            }
            for(int i = 0; i < rowSize; i++){
                for(int j = 0; j < colSize; j++){
                    if(board[i][j] == maxNum){
                        answer = max(answer, dfs(i, j, 1, visited));
                    }
                }
            }
            return answer;
        }

        public static int dfs(int hereI, int hereJ, int level, boolean[][] visited){
            visited[hereI][hereJ] = true;
            if(level == 4){
                visited[hereI][hereJ] = false;
                return board[hereI][hereJ];
            }
            int maxNum = 0;
            for(int i = 0; i < 4; i++){
                int thereI = hereI + DIRECTION[0][i];
                int thereJ = hereJ + DIRECTION[1][i];
                if(thereI < 0 || thereI > rowSize-1 || thereJ < 0 || thereJ > colSize-1) continue;
                if(visited[thereI][thereJ]) continue;
                maxNum = max(maxNum, board[thereI][thereJ]);
            }
            int preRet = 0;
            for(int i = 0; i < 4; i++){
                int thereI = hereI + DIRECTION[0][i];
                int thereJ = hereJ + DIRECTION[1][i];
                if(thereI < 0 || thereI > rowSize-1 || thereJ < 0 || thereJ > colSize-1) continue;
                if(visited[thereI][thereJ]) continue;
                if(maxNum == board[thereI][thereJ]) preRet = max(preRet, dfs(thereI, thereJ, level + 1, visited));
            }
            visited[hereI][hereJ] = false;
            return preRet + (int)pow(10, 4 - level) * board[hereI][hereJ];
        }
    }
}
