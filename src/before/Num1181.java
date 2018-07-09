package before;

import java.util.Scanner;

public class Num1181 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int wordsCount = Integer.valueOf(scanner.nextLine());
        String [] words = new String[wordsCount];

        for(int i = 0; i < wordsCount; i++){
            words[i] = scanner.nextLine();
        }

        for(int i = 0; i < wordsCount; i++){
            for(int j = 0; j < wordsCount - i - 1; j++){
                if(words[j].length() > words[j+1].length()){
                    String tmp = words[j];
                    words[j] = words[j+1];
                    words[j+1] = tmp;
                }else if(words[j].length() == words[j+1].length()){
                    //알파벳순
                    for(int k = 0; k < words[j].length(); k++){
                        if(words[j].charAt(k) == words[j+1].charAt(k)){
                            continue;
                        }else if(words[j].charAt(k) > words[j+1].charAt(k)){
                            String tmp = words[j];
                            words[j] = words[j+1];
                            words[j+1] = tmp;
                            break;
                        }else if(words[j].charAt(k) < words[j+1].charAt(k)){
                            break;
                        }
                    }
                }
            }
        }

        for(int i = 0; i < wordsCount - 1; i++){
            if(words[i].equals(words[i+1])) continue;
            System.out.println((words[i]));
        }
        System.out.println(words[wordsCount-1]);
    }
}
