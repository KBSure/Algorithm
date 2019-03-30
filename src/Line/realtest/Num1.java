package Line.realtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Num1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int mark = (int)Math.sqrt((double)n);
        for(int i = mark; i >= 1; i--){
            if(n % i == 0){
                int w = i;
                int h = n / w;
                System.out.println(h - w);
                break;
            }
        }
    }
}
