import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Num9095 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testcase = Integer.parseInt(br.readLine());

        int [][] arr = new int [testcase][12];

        for (int i = 0; i <testcase; i++){
            int a = Integer.parseInt(br.readLine());
            for(int j = 1; j <= a; j++){
                arr[i][1] = 1;
                arr[i][2] = 2;
                arr[i][3] = 4;
                if(j != 1 && j != 2 && j != 3) {
                    arr[i][j] = arr[i][j - 1] + arr[i][j - 2] + arr[i][j-2];
                }
            }
            System.out.println(arr[i][a]);
        }
    }
}
