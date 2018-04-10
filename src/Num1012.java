import java.util.Scanner;

public class Num1012 {

    private static int rowSize;
    private static int colSize;
    private static int cabageCount;
    private static int map [][];
    private final static int VISITED = 2;
    private final static int UNVISITED = 1;
    private final static int UNVISITABLE = 0;

    private final static int TOP = 0;
    private final static int RIGHT = 1;
    private final static int BOTTOM = 2;
    private final static int LEFT = 3;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final int caseCount = scanner.nextInt();

        for(int i = 0; i < caseCount; i++){
            rowSize = scanner.nextInt();
            colSize = scanner.nextInt();
            cabageCount = scanner.nextInt();
            map = new int[colSize][rowSize];
            for(int j = 0; j < cabageCount; j++){
                map[scanner.nextInt()][scanner.nextInt()] = 1;
            }
            dfsAll();

        }
    }

    private static void dfsAll(){
        for(int i = 0; i < colSize; i++){
            for(int j = 0; j < rowSize; j++){
                if(map[i][j] == UNVISITED)
                    dfs(i, j);
            }
        }
    }

    //-1 colSize, rowSize 이면 indexOver
    private static void dfs(int hereI, int hereJ){
        map[hereI][hereJ] = VISITED;
        for(int i = 0; i < 4; i++){
            if(i == TOP && hereI-1 != -1 && map[hereI-1][hereJ] == UNVISITED){ //위 쪽 인덱스 참조 가능하며 방문 안 해본 배추가 있으면
                dfs(hereI-1, hereJ);
            }
        }
    }
}


