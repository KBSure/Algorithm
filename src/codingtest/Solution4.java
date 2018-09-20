package codingtest;

import java.util.LinkedList;
import java.util.List;


class Food{
    int num;
    int value;

    Food(int num, int value){
        this.num = num;
        this.value = value;
    }

    public int getNum() {
        return num;
    }

    public int getValue() {
        return value;
    }

    void minusValue(){
        value--;
    }
}

public class Solution4 {

    public int solution(int[] food_times, long k) {
        int turn = 0; // 인덱스
        int circle = food_times.length;

        while(circle > 0 && k-- > 0){
            if(food_times[turn] == 0){
                k++;
                turn++;
                if(turn == food_times.length) turn = 0;
                circle--;
                continue;
            }
            circle = food_times.length;
            food_times[turn++]--;

            if(turn == food_times.length) turn = 0;
        }

        //circle을 가지고 출력하는 방법 없을까?

        //먹을 게 없으면 -1
        for(int i = 0; i < food_times.length; i++){
            if(turn == food_times.length) turn = 0;
            if(food_times[turn] == 0){
                turn++;
                continue;
            }
            return turn + 1;
        }

        return -1;
    }
}
