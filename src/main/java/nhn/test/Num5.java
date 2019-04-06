package nhn.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Num5 {
    private static int size;
    private static List<Man> manList;
    private static List<Integer> orderList;

    public static void main(String[] args) throws IOException {
        init();
        manList.sort(new EscapeComparator());
        for(Man man : manList){
            System.out.println(man);
        }
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        orderList = new ArrayList<>();
        for(int i = 0; i < 3; i++){
            orderList.add(Integer.parseInt(split[i]));
        }
        size = Integer.parseInt(br.readLine());

        manList = new ArrayList<>();
        for(int i = 0; i < size; i++){
            Man man = new Man();
            String[] split2 = br.readLine().split(" ");
            if(split2.length == 2){
                man.setGender(split2[0]);
                man.setAge(Integer.parseInt(split2[1]));
            }else if(split2.length == 3){
                man.setGender(split2[0]);
                man.setAge(Integer.parseInt(split2[1]));
                man.setEtc(split2[2]);
            }
            manList.add(man);
        }
    }
    static class Man{
        private String gender;
        private int age;
        private String etc;

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getEtc() {
            return etc;
        }

        public void setEtc(String etc) {
            this.etc = etc;
        }

        @Override
        public String toString() {
            return etc == null ? gender + " " + age : gender + " " + age + " " + etc;
        }
    }

    static class EscapeComparator implements Comparator<Man>{
        //양수면 this가 앞쪽에
        @Override
        public int compare(Man o1, Man o2) {
            for(int i = 0; i < 3; i++){
                Integer condition = orderList.get(i);
                if(condition == 1){
                    if(o1.getGender() != o2.getGender()){
                        if("F".equals(o1.getGender())){
                            return -1;
                        }else{
                            return 1;
                        }
                    }else{
                        continue;
                    }
                }else if(condition == 2){
                    if(o1.getAge() == o2.getAge()) continue;
                    if(o1.getAge() <= 7 && o2.getAge() <= 7){
                        return o1.getAge()- o2.getAge();
                    }else if(o1.getAge() > 7 && o2.getAge() > 7){
                        return o2.getAge() - o1.getAge();
                    }else{
                        return o1.getAge() - o2.getAge(); // 작으면 앞에
                    }
                }else if(condition == 3){
                    if(o1.getEtc() == null && o2.getEtc() == null){
                        continue;
                    }else if(o1.getEtc() == null){
                        return 1;
                    }else if(o2.getEtc() == null){
                        return -1;
                    }else{ //둘 다 노약자
                        if(o1.getEtc().equals(o2.getEtc())){
                            continue;
                        }else if("PW".equals(o1.getEtc())){
                            return -1;
                        }else if("DP".equals(o1.getEtc()) && "P".equals(o2.getEtc())){
                            return -1;
                        }else{
                            return 1;
                        }
                    }
                }
            }
            return 0;
        }
    }
}



