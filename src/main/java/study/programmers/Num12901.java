package study.programmers;

public class Num12901 {
    private String[] weeks;
    private int[] days;
    private final int START_WEEK_IDX = 4; // 목요일이 제로
    public String solution(int a, int b) {
        init();
        int nthOfYear = START_WEEK_IDX;
        for(int i = 0; i < a-1; i++){
            nthOfYear += days[i];
        }
        nthOfYear += b;

        return weeks[nthOfYear%7];
    }
    private void init(){
        weeks = new String[]{"SUN","MON","TUE","WED","THU","FRI","SAT"};
        days = new int[]{31,29,31,30,31,30,31,31,30,31,30,31};
    }
}
