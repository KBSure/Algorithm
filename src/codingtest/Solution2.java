package codingtest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class StageComparator implements Comparator<Stage> {
    @Override
    public int compare(Stage o1, Stage o2) {

        if(o1.getLoseRatio() - o2.getLoseRatio() > 0.0){
            return -1;
        }else if(o1.getLoseRatio() - o2.getLoseRatio() < 0.0){
            return 1;
        }

        return o1.getNum() - o2.getNum();
    }
}

class Stage{
    int num;
    double loseRatio;

    Stage(int num, double loseRatio){
        this.num = num;
        this.loseRatio = loseRatio;
    }

    public int getNum() {
        return num;
    }

    public double getLoseRatio() {
        return loseRatio;
    }
}

class Solution2 {
    public int[] solution(int N, int[] stages) {
        int[] check = new int[N+1];
        List<Stage> stageList = new ArrayList<>();

        for(int i = 0; i < stages.length; i++){
            if(stages[i] > N) continue;
            check[stages[i]]++;
        }

        int challenger = stages.length;
        for(int i = 1; i <= N; i++){
            challenger -= check[i-1];
            stageList.add(new Stage(i, (double)check[i] / (double)challenger ) );
        }

        Collections.sort(stageList, new StageComparator());

        int[] answer = new int[N];

        for(int i = 0; i < stageList.size(); i++){
            answer[i] = stageList.get(i).getNum();
        }

        return answer;
    }

}