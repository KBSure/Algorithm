package study.acmicpc.samsung; //나무 재테크

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Num16235 {
    private static int N;
    private static int M;
    private static int K;
    private static int[][] currentEnergyArray;
    private static int[][] winterEnergyArray;
    private static List<Tree> fallTreeList;
    private static int[][] summerEnergyArray;
    private static LinkedList<Tree>[][] treeListArray;
//    (r-1, c-1), (r-1, c), (r-1, c+1), (r, c-1), (r, c+1), (r+1, c-1), (r+1, c), (r+1, c+1)
    private static final int[][] DIRECTION = {  {-1,-1,-1,0,0,1,1,1},
                                                {-1,0,1,-1,1,-1,0,1}};

    static class Tree{
        int age;
        int hereI;
        int hereJ;

        Tree(int hereI, int hereJ, int age){
            this.age = age;
            this.hereI = hereI;
            this.hereJ = hereJ;
        }
    }

    public static void main(String[] args) throws IOException {
        initClass.init();

        for(int h = 0; h < K; h++){
            initClass.summerEnergyArrayInit();
            initClass.fallTreeListInit();
            // 봄
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    LinkedList<Tree> treeList = treeListArray[i][j];
                    for (int k = 0; k < treeList.size(); k++) {
                        Tree tree = treeList.get(k);
                        if (currentEnergyArray[i][j] >= tree.age) {
                            currentEnergyArray[i][j] -= tree.age;
                            tree.age++;
                            if (tree.age % 5 == 0) {
                                fallTreeList.add(tree);
                            }
                        } else {
                            summerEnergyArray[i][j] += tree.age / 2;
                            treeList.remove(k--); // 제거하게 되어 treeList size가 줄어들었으므로, index를 다시 조정해야 한다.
                        }
                    }
                }
            }


            //여름
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    currentEnergyArray[i][j] += summerEnergyArray[i][j];
                }
            }

            //가을
            for (Tree tree : fallTreeList) {
                for (int k = 0; k < 8; k++) {
                    int thereI = tree.hereI + DIRECTION[0][k];
                    int thereJ = tree.hereJ + DIRECTION[1][k];
                    if (thereI >= 0 && thereI <= N - 1 && thereJ >= 0 && thereJ <= N - 1) {
                        treeListArray[thereI][thereJ].addFirst(new Tree(thereI, thereJ, 1));
                    }
                }
            }

            //겨울
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    currentEnergyArray[i][j] += winterEnergyArray[i][j];
                }
            }
        }

        int answer = 0;

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                answer += treeListArray[i][j].size();
            }
        }

        System.out.println(answer);

    }

    private static class initClass{

//        private static void printSomething(){
////            printCurrentEnergy();
//            printAge();
////            printTreeSize();
////            printFallTreeAge();
////            printSummerEnergyArray();
////            printWinterEnergyArray();
//        }
//
//        private static void printAge(){
//            for(int i = 0; i < N; i++){
//                for(int j = 0; j < N; j++){
//                    LinkedList<Tree> trees = treeListArray[i][j];
//                    System.out.println("-------(" + i  + "," + j + ")------");
//                    for(Tree tree : trees){
//                        System.out.print(tree.age + " ");
//                    }
//                    System.out.println();
//                }
//                System.out.println();
//            }
//        }
//
//        private static void printCurrentEnergy(){
//            for(int i = 0; i < N; i++){
//                for(int j = 0; j < N; j++){
//                    System.out.print(currentEnergyArray[i][j] + " ");
//                }
//                System.out.println();
//            }
//            System.out.println();
//        }
//
//        private static void printTreeSize(){
//            for(int i = 0; i < N; i++){
//                for(int j = 0; j < N; j++){
//                    System.out.print(treeListArray[i][j].size() + " ");
//                }
//                System.out.println();
//            }
//            System.out.println();
//        }
//
//        private static void printSummerEnergyArray(){
//            for(int i = 0; i < N; i++){
//                for(int j = 0; j < N; j++){
//                    System.out.print(summerEnergyArray[i][j] + " ");
//                }
//                System.out.println();
//            }
//            System.out.println();
//        }
//
//        private static void printWinterEnergyArray(){
//            for(int i = 0; i < N; i++){
//                for(int j = 0; j < N; j++){
//                    System.out.print(winterEnergyArray[i][j] + " ");
//                }
//                System.out.println();
//            }
//            System.out.println();
//        }
//
//        private static void printFallTreeAge(){
//            for(Tree tree : fallTreeList){
//                System.out.print(tree.age + " ");
//            }
//            System.out.println();
//        }

        private static void summerEnergyArrayInit(){
            for(int i = 0; i < N; i++){
                Arrays.fill(summerEnergyArray[i], 0);
            }
        }
        private static void fallTreeListInit(){
            fallTreeList.clear();
        }
        private static void init() throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String[] split = br.readLine().split(" ");
            N = Integer.parseInt(split[0]);
            M = Integer.parseInt(split[1]);
            K = Integer.parseInt(split[2]);

            currentEnergyArray = new int[N][];
            treeListArray = new LinkedList[N][];
            summerEnergyArray = new int[N][];
            fallTreeList = new LinkedList<>();

            for(int i = 0; i < N; i++){
                currentEnergyArray[i] = new int[N];
                treeListArray[i] = new LinkedList[N];
                summerEnergyArray[i] = new int[N];
                for(int j = 0; j < N; j++){
                    currentEnergyArray[i][j] = 5; // 처음 양분 모두 5
                    treeListArray[i][j] = new LinkedList<>();
                }
            }

            winterEnergyArray = new int[N][];
            for(int i = 0; i < N; i++){
                String[] splitA = br.readLine().split(" ");
                winterEnergyArray[i] = new int[N];
                for(int j = 0; j < N; j++){
                    winterEnergyArray[i][j] = Integer.parseInt(splitA[j]);
                }
            }

            for(int i = 0; i < M; i++){
                String[] splitTree = br.readLine().split(" ");
                int x = Integer.parseInt(splitTree[0]);
                int y = Integer.parseInt(splitTree[1]);
                int z = Integer.parseInt(splitTree[2]);
                int r = x - 1;
                int c = y - 1;
                treeListArray[r][c].addFirst(new Tree(r, c, z));
            }

        }
    }


}
