package study.programmers; //완주하지 못한 선수

import java.util.HashMap;
import java.util.Map;

public class Num42576 {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> completionCountMap = new HashMap<>();
        for(int i = 0; i < completion.length; i++){
            if(completionCountMap.containsKey(completion[i])){
                completionCountMap.replace(completion[i], completionCountMap.get(completion[i]) + 1);
                continue;
            }
            completionCountMap.put(completion[i], 1);
        }

        for(int i = 0; i < participant.length; i++){
            if(!completionCountMap.containsKey(participant[i])){
                return participant[i];
            }
            if(completionCountMap.get(participant[i]) == 1){
                completionCountMap.remove(participant[i]);
            }else{
                completionCountMap.replace(participant[i], completionCountMap.get(participant[i]) - 1);
            }
        }
        return null;
    }
}
