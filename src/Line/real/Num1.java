package Line.real;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Num1 {
    private static List<Integer> list;
    private static List<Integer> useMoneyLIst;
    private static int totalMoney;
    public static void main(String[] args) throws Exception {
        init();
        for(int i = 0; i < list.size(); i++){
            if(useMoneyLIst.get(i) < 0){
                System.out.println(totalMoney);
            }else{
                if(totalMoney - useMoneyLIst.get(i) > 0) {
                    totalMoney -= useMoneyLIst.get(i);
                }else{
                    System.out.println(totalMoney);
                    return;
                }
            }
        }
        System.out.println(totalMoney);
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        list = new ArrayList<>();
        for(String str : split) {
            list.add(Integer.parseInt(str));
        }
        totalMoney = 20000;
        useMoneyLIst = new ArrayList<>();
        for(int i = 0; i < list.size(); i++){
            if(list.get(i) <= 40){
                useMoneyLIst.add(720);
            }else if(list.get(i) < 4 || list.get(i) > 178){
                useMoneyLIst.add(-1);
            }else{
                useMoneyLIst.add(720 + (((list.get(i) - 41) / 8 + 1) * 80));
            }
        }
    }
}
