package street11;

public class Num3 {
    public int solution(int[] A) {
        int head = 0;
        int tail = 0;
        for(int coin : A){
            if(coin == 0) head++;
            else tail++;
        }
        return Math.min(head, tail);
    }
}
