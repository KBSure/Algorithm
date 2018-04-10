import java.util.Scanner;

public class Num1012 {

    private static int rowSize;
    private static int colSize;
    private static int cabageCount;
    private static int map [][];
    private final static int VISITED = 2;
    private final static int UNVISITED = 1;
    private final static int UNVISITABLE = 0;

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

    private static void dfs(int startI, int startJ){

        for(int i = 0; i < 4; i++){

        }
    }
}


