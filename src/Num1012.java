import java.util.Scanner;

public class Num1012 {
    //col = 가로, row = 세로로 생각한다.
    private static int rowSize;
    private static int colSize;
    private static int cabageCount;
    private static int warmCount [];

    private static int map [][];
    private final static int VISITED = 2;
    private final static int UNVISITED = 1;
    private final static int UNVISITABLE = 0;

    private final static int TOP = 0;
    private final static int RIGHT = 1;
    private final static int BOTTOM = 2;
    private final static int LEFT = 3;

    public static void main(String[] args) {
//1. 입력 받는 과정
        Scanner scanner = new Scanner(System.in);
        final int caseCount = scanner.nextInt();
        warmCount = new int[caseCount];

        for(int i = 0; i < caseCount; i++){
            colSize = scanner.nextInt();
            rowSize = scanner.nextInt();
            cabageCount = scanner.nextInt();
            map = new int[colSize][rowSize];
//2. 배추가 있는 곳 표시(아직 방문하지 않았음을 의미하는 값 1로) 초기화
            for(int j = 0; j < cabageCount; j++){
                map[scanner.nextInt()][scanner.nextInt()] = UNVISITED;
            }
//3. dfs가 몇 번 돌아가는 지 dfsAll 함수 호출해서 해결
            dfsAll(i);
        }
        scanner.close();
        for(int i = 0; i < caseCount; i++){
            System.out.println(warmCount[i]);
        }
    }

    private static void dfsAll(int nth){
        for(int i = 0; i < colSize; i++){
            for(int j = 0; j < rowSize; j++){
                if(map[i][j] == UNVISITED) {
//4. dfs는 connected Component 단위로 돌아가게 되어있음
                    dfs(i, j);
                    warmCount[nth]++;
                }
            }
        }
    }
    //-1 colSize, rowSize 이면 indexOver
    private static void dfs(int hereI, int hereJ){
//5. 방문하자마자 visited로 표시
        map[hereI][hereJ] = VISITED;
        for(int i = 0; i < 4; i++){
//6. 방문하자마자 인접한 네 방향에 대해서 방문할 수 있는 지 조건을 따져봄
            if(i == TOP && hereI-1 != -1 && map[hereI-1][hereJ] == UNVISITED){ //위 쪽 인덱스 참조 가능하며 방문 안 해본 배추가 있으면
                dfs(hereI-1, hereJ);
            }else if(i == RIGHT && hereJ+1 != rowSize && map[hereI][hereJ+1] == UNVISITED){
                dfs(hereI, hereJ+1);
            }else if(i == BOTTOM && hereI+1 != colSize && map[hereI+1][hereJ] == UNVISITED){
                dfs(hereI+1, hereJ);
            }else if(i == LEFT && hereJ-1 != -1 && map[hereI][hereJ-1] == UNVISITED){
                dfs(hereI, hereJ-1);
            }
        }
    }
}


// 지역 변수가 아닌 멤버변수(특히 static 변수)가 루프에서 사용될 때 루프 처음 부분에서 초기화되어야하는지 따져보자 꼭.
