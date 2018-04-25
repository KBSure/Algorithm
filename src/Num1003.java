import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Num1003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine());

        int [][] arr0 = new int [testcase][41];
        int [][] arr1 = new int [testcase][41];

        for(int i = 0; i < testcase; i++){
            arr0[i][0] = 1;
            arr1[i][0] = 0;
            arr0[i][1] = 0;
            arr1[i][1] = 1;
            int a = Integer.parseInt(br.readLine());
            for(int j = 0; j <= a; j++){
                if(j != 0 && j != 1) {
                    arr1[i][j] = arr1[i][j - 1] + arr1[i][j - 2];
                    arr0[i][j] = arr0[i][j - 1] + arr0[i][j - 2];
                }
            }

            System.out.println(arr0[i][a] + " " + arr1[i][a]);

        }
        br.close();
    }
}
