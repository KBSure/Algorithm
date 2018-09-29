package nhn.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Num1 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> result = new ArrayList<>();

        String[] split = br.readLine().split(" ");
        for(int i = 0; i < split.length; i++){
            Integer item = Integer.valueOf(split[i]);
            if(queue.size() == 3){
                if(queue.contains(item)){ //친구한테 주기
                    queue.remove(item);
                    queue.add(item);
                }else{ //버리기
                    result.add(queue.peek());
                    queue.poll();
                    queue.add(item);
                }
            }else{
                queue.add(item);
            }
        }

        if(result.size() == 0){
            System.out.println(0);
            return;
        }
        for(Integer integer : result){
            System.out.println(integer);
        }
    }
}
