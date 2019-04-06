package Line.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Num1 {
    private static int size;
    private static List<Integer> list;
    public static void main(String[] args) throws Exception {
        init();
        Collections.sort(list);
        System.out.println(list.get(size - 1));
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        size = Integer.parseInt(br.readLine());
        String[] split = br.readLine().split(" ");
        list = new ArrayList<>();
        for(int i = 0; i < size; i++){
            list.add(Integer.parseInt(split[i]));
        }
    }
}
