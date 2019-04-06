package street11;

public class Num2 {
    public int solution(String S) {
        String[] sentences = S.split("[.]|[?]|!");
        int answer = 0;
        for(String sentence : sentences){
            String[] words = sentence.trim().split(" ");
            int wordCount = words.length;
            for(String word : words){
                word.trim();
                if("".equals(word)) wordCount--;
            }
            if(answer < wordCount) answer = wordCount;
        }
        return answer;
    }
}
