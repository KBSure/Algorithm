package study.acmicpc.review; //암호코드

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Num2011 {
    private static String pw;
    private static boolean isImpossible;
    private static int[] cache;
    public static void main(String[] args) throws IOException {
        init();
        int answer = countCase(pw, 0);
        System.out.println(isImpossible ? "0" : answer);
    }

    private static int countCase(String pw, int index) {
        if(isImpossible) return 0;
        if(index == pw.length()) return 1;
        if(cache[index] != 0) return cache[index];

        char hereChar = pw.charAt(index);
        char nextChar = 0;
        if(index != pw.length()-1) nextChar = pw.charAt(index + 1);
        if('0' == hereChar){ //0으로 시작하거나, 00 연속으로 나오거나  30 이상부터는 impossible
            if(index == 0 || nextChar == '0' || '2' < pw.charAt(index-1)) isImpossible = true;
            return 0;
        }
        if(index == pw.length()-1) return 1;

        int ret = 0;
        ret += countCase(pw, index + 1);
        switch (hereChar){
            case '1':
                ret += countCase(pw, index + 2);
                break;
            case '2':
                if(nextChar <= '6' && nextChar >= '0') ret += countCase(pw, index + 2);
                break;
            default :
                break;
        }
        return cache[index] = ret % 1000000;
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        pw = br.readLine();
        cache = new int[pw.length()];
    }
}
