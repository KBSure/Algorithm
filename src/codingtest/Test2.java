package codingtest;

public class Test2 {
    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        int[] solution = solution2.solution(5, new int[]{2, 1, 2, 6, 2, 4, 3, 3});
        for(int i = 0; i < solution.length; i++){
            System.out.println(solution[i]);
        }

    }
}
