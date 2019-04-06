package nhn.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class Num2 {
    public static void main(String[] args) throws Exception{
        // 97
        //더하고, 횟수만큼 돌리고
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        String type = split[0];
        String secretKey = split[1];
        int rotationCount = Integer.parseInt(split[2]);
        String message = split[3];
        int size = secretKey.length();

        char[] secretKeyChars = secretKey.toCharArray();
        char[] messageChars = message.toCharArray();
        LinkedList<Character> charList = new LinkedList<>();
//        char[] result = new char[size];

        if("encrypt".equals(type)){ //암호화
            //secretKey 이용해 message 암호화
            for(int i = 0; i < size; i++){
                charList.add((char)((secretKeyChars[i]-97 + messageChars[i]-97) % 26 + 97));
            }
            for(int i = 0; i < rotationCount; i++){
                charList.add(charList.pollFirst());
            }
        }else{ //복호화
            //secretKey 이용해 message 복호화
            //charList에 넣어주기
            for(int i = 0; i < size; i++){
                charList.add(message.charAt(i));
            }
            //로테이션
            for(int i = 0; i < rotationCount; i++){
                charList.addFirst(charList.pollLast());
            }

            //secretKey 빼주기
            LinkedList<Character> charList2 = (LinkedList<Character>)charList.clone();
            charList.clear();
            int temp = 0;
            for(int i = 0; i < size; i++){
                charList.add((char)((temp = charList2.get(i)-97 - (secretKeyChars[i]-97)) >= 0 ? temp + 97 : temp + 26 + 97));
            }
        }

        for(Character character : charList){
            System.out.print(character);
        }
    }
}
