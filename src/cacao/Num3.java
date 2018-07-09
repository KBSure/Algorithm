package cacao;

import java.util.LinkedList;

public class Num3 {
    public static void main(String[] args) {
        // 주입 받았다고 가정하고
        int cacheSize = 0;
        String [] cities = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA"};
        int citiesSize = cities.length;

        LinkedList<String> lruQ = new LinkedList<>();
        int executeTime = 0;

        if (cacheSize == 0) {
            executeTime = 5*citiesSize;
        }else {
            for (int i = 0; i < citiesSize; i++) {
                if (lruQ.contains(cities[i])) {
                    lruQ.remove(cities[i]);
                    lruQ.addLast(cities[i]);
                    executeTime += 1;
                } else {
                    if (lruQ.size() == cacheSize) { //cacheSize가 0일 때 예외 처리 필요
                        lruQ.removeFirst();
                    }
                    lruQ.addLast(cities[i]);
                    executeTime += 5;
                }

                System.out.println(lruQ);
            }
        }
        System.out.println(executeTime);
    }
}
