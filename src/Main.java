import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //받은 숫자에서 배열에 넣고 인덱스 비교 하자.
        //String이니까 자르자 split

        //한 번도 교환 안 일어나면, break
        //한 번 이상 교환 일어나면 다시 for문
        String[] numbers = br.readLine().split(" ");
        while(true) {
            Boolean isChange = false;
            for (int i = 0; i < numbers.length - 1; i++) {
                if (Integer.valueOf(numbers[i + 1]) < Integer.valueOf(numbers[i])) {
                    String tmp = numbers[i + 1];
                    numbers[i + 1] = numbers[i];
                    numbers[i] = tmp;
                    System.out.println(String.join(" ", numbers));
                    isChange = true;
                }
            }
            if(!isChange) break;
        }
    }
}