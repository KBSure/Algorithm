import java.util.Scanner;

public class Num1012 {

    private static int rowSize;
    private static int colSize;
    private static int cabageCount;
    private static int map [][];

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
                if(visited[i][j] !=null)
                    dfs(i, j);
            }
        }
    }

    private static void dfs(int startI, int startJ){

    }
}


