package zum;

import java.util.LinkedList;
import java.util.List;

import static java.lang.Math.max;
import static java.lang.Math.pow;

public class Num4 {
    public static void main(String[] args) {

    }
    class Solution {
        private final int[][] DIRECTION = {{-1,0,1,0},{0,1,0,-1}};
        private int answer;
        public int solution(int[][] Board) {
            // write your code in Java SE 8
            // 큰 숫자를 찾고 거기서 dfs 돌린다.
            // 안되면 그 다음 큰 숫자를 찾는다.
            int maxNum = 0;

            if(Board.length == 1 || Board[0].length == 1){
                for (int i = 0; i < Board.length; i++) {
                    for (int j = 0; j < Board[0].length; j++) {
                        answer = max(answer, dfs(null, new Node(i, j, 1, Board)));
                    }
                }
                return answer;
            }

            for (int i = 0; i < Board.length; i++) {
                for (int j = 0; j < Board[0].length; j++) {
                    if (Board[i][j] > maxNum) maxNum = Board[i][j];
                }
            }
            for (int i = 0; i < Board.length; i++) {
                for (int j = 0; j < Board[0].length; j++) {
                    if (Board[i][j] == maxNum){
                        answer = max(answer, dfs(null, new Node(i, j, 1, Board)));
                    }
                }
            }
            return answer;
        }

        public int dfs(Node preNode, Node hereNode){
            if(hereNode.level == 4) return hereNode.value;
            int maxValue = Integer.MIN_VALUE;
            if(hereNode.adj().size() == 0) return Integer.MIN_VALUE; // level4까지 인접가능한 곳이 없으면
            for(Node adjNode : hereNode.adj()){
//                if(adjNode.hereI == preNode.hereI && adjNode.hereJ == preNode.hereJ) continue;
                maxValue = max(maxValue, dfs(hereNode, adjNode));
            }
            if(maxValue == Integer.MIN_VALUE) return Integer.MIN_VALUE;
            return maxValue + ((int)pow(10,4-hereNode.level) * hereNode.value);
        }

        class Node{
            int hereI, hereJ;
            int level;
            int value;
            int[][] board;

            Node(int hereI, int hereJ, int level, int[][] board){
                this.hereI = hereI;
                this.hereJ = hereJ;
                this.level = level;
                this.board = board;
              value = board[hereI][hereJ];
            }

            List<Node> adj(){
                List<Node> adjNode = new LinkedList<>();
                int thereI = 0;
                int thereJ = 0;
                int max = 0;
                for(int i = 0; i < 4; i++){
                    thereI = hereI + DIRECTION[0][i];
                    thereJ = hereJ + DIRECTION[1][i];
                    if(thereI < 0 || thereI > board.length-1 || thereJ < 0 || thereJ > board[0].length-1) continue;
                    if(board[thereI][thereJ] > max){
                        max = board[thereI][thereJ];
                        adjNode.clear();
                        adjNode.add(new Node(thereI, thereJ, level + 1, board));
                    }else if(board[thereI][thereJ] == max){
                        adjNode.add(new Node(thereI, thereJ, level + 1, board));
                    }
                }
                return adjNode;
            }
        }
    }
}
