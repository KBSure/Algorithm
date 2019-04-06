package nhn.real;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Num2 {
    private static int size;
    private static int rotation;
    private static List<LinkedList<String>> list;
    private static String[][] map;
    private static String[][] result;

    public static void main(String[] args) throws IOException {
        init();
        for(int i = 0; i < list.size(); i++){
            //rotation이 0보다 크면
            rotation(list.get(i));
        }
        mapping();

        for(int i = 0; i < size; i++){
            for(int j = 0; j <size; j++){
                if(j == 0){
                    System.out.print(result[i][j]);
                }else{
                    System.out.print(" " + result[i][j]);
                }
            }
            System.out.println();
        }
    }

    private static void mapping(){
        int start = 0;
        int end = size - 1;

        for(int k = 0; k < list.size(); k++){
            LinkedList<String> line = list.get(k);
            for(int j = start; j < end; j++){
                result[start][j] = line.pollFirst();
//                line.addLast(map[start][j]);
            }

            for(int i = start; i < end; i++){
                result[i][end] = line.pollFirst();
//                line.addLast(map[i][end]);
            }

            for(int j = end; j > start; j--){
                result[end][j] = line.pollFirst();
//                line.addLast(map[end][j]);
            }

            for(int i = end; i > start; i--){
                result[i][start] = line.pollFirst();
//                line.addLast(map[i][start]);
            }

            if(size % 2 == 1 && k == list.size()-1){
                result[start][start] = line.pollFirst();
            }

            start += 1;
            end -= 1;
        }
    }

    private static void rotation(LinkedList<String> line){
        int count = rotation;
        rotation *= -1; //rotation -1로 방향 바꿈
        if(count > 0) {
            while (count-- > 0) { //시계 방향 count가 양수
                //꼬리가 앞으로
                line.addFirst(line.peekLast());
                line.pollLast();
            }
            return;
        }else if(count < 0){
            while (count++ < 0) { //반시계 방향 count가 음수
                //머리가 꼬리로
                line.addLast(line.peekFirst());
                line.pollFirst();
            }
            return;
        }else{
            return;
        }
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        size = Integer.parseInt(split[0]);
        rotation = Integer.parseInt(split[1]);

        map = new String[size][size];
        for(int i = 0; i < size; i++){
            String[] split1 = br.readLine().split(" ");
            for(int j = 0; j < size; j++){
                map[i][j] = split1[j];
            }
        }

        int row = size;
        list = new ArrayList<>();

        int start = 0;
        int end = size - 1;
//        (size % 2 == 0 && row > 0) || (size % 2 == 1) && row >= 0
        while(row > 0){
            LinkedList<String> line = new LinkedList<>();
            list.add(line);
            for(int j = start; j < end; j++){
                line.addLast(map[start][j]);
            }

            for(int i = start; i < end; i++){
                line.addLast(map[i][end]);
            }

            for(int j = end; j > start; j--){
                line.addLast(map[end][j]);
            }

            for(int i = end; i > start; i--){
                line.addLast(map[i][start]);
            }

            if(size % 2 == 1 && row == 1){
                line.addLast(map[start][start]);
            }

            start += 1;
            end -= 1;
            row -= 2;
        }

        result = new String[size][size];

    }
}
