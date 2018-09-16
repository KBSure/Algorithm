package codingtest;

public class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] solution1 = solution.solution(new String[]{"Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo", "Change uid4567 Ryan"});

        for(int i = 0; i < solution1.length; i++){
            System.out.println(solution1[i]);
        }

    }
}
