package codingtest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class User{
    String id;
    String nickName;

    User(String id, String nickName){
        this.id = id;
        this.nickName = nickName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
}
class Log{
    User user;
    String inOut;

    Log(User user, String inOut){
        this.user = user;
        this.inOut = inOut;
    }

    public User getUser() {
        return user;
    }

    public String getInOut() {
        return inOut;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(user.getNickName());
        sb.append("님이 ");
        if("Enter".equals(inOut)) sb.append("들어왔습니다.");
        else sb.append("나갔습니다.");
        return sb.toString();
    }
}
class Solution {
    public String[] solution(String[] record) {

        Map<String, User> userMap = new HashMap();
        List<Log> logList = new ArrayList<>();
        for(int i = 0; i < record.length; i++){
            String[] split = record[i].split(" ");
            if("Change".equals(split[0])){
                userMap.get(split[1]).setNickName(split[2]);
            }else if("Enter".equals(split[0])){
                if(userMap.containsKey(split[1])){
                    User user = userMap.get(split[1]);
                    user.setNickName(split[2]);
                    Log log = new Log(user, split[0]);
                    logList.add(log);
                }else{
                    User user = new User(split[1], split[2]);
                    Log log = new Log(user, split[0]);
                    userMap.put(user.getId(), user);
                    logList.add(log);
                }
            }else{
                User user = userMap.get(split[1]);
                Log log = new Log(user, split[0]);
                logList.add(log);
            }
        }

        String[] answer = new String[logList.size()];

        for(int i = 0; i< answer.length; i++){
            answer[i] = logList.get(i).toString();
        }

        return answer;
    }
}