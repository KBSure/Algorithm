package Line.real;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Num4 {
    private static int size;
    private static List<Request> requestList;
    private static List<Response> responseList;
    private static List<User> userList;
    private static Map<String, User> userMap;
    public static void main(String[] args) throws IOException {
        init();
        for(int i = 0; i < requestList.size(); i++){
            Request request = requestList.get(i);
            Response response = responseList.get(i);
            String[] split = request.getMessage().split("/");
            if("POST".equals(request.getMethod())){
                if(split.length == 3){ //id등록
                    //id 있는지 비교
                    //id등록인데 data가 같이 오면
                    if(request.getBody() != null){ // 있으면 method 오류
                        response.setMETHOD_NOT_ALLOWED(true);
                        if(userMap.containsKey(split[2])){//이미 존재
                            response.setFORBIDDEN(true);
                        }
                    }else{ //없어야 정상
                        if(userMap.containsKey(split[2])){//이미 존재
                            response.setFORBIDDEN(true);
                        }else{ //정상 등록
                            User user = new User();
                            user.setName(split[2]);
                            userList.add(user);
                            userMap.put(split[2], user);
                            response.setCREATED(true);
                        }
                    }
                }else if(split.length == 4){//4 data등록
                    //data 없으면 안됨
                    if(request.getBody() == null){ //없으면 method오류
                        response.setMETHOD_NOT_ALLOWED(true);
                        if(!userMap.containsKey(split[2])) {
                            response.setFORBIDDEN(true);
                        }
                    }else{ //data 있으면
                        //사용자 없는 경우
                        if(!userMap.containsKey(split[2])){
                            response.setFORBIDDEN(true);
                        }else{//사용자 있으면 data추가
                            userMap.get(split[2]).setData(request.getBody());
                            response.setOK(true);
                        }
                    }
                }else{ //3, 4안되면
                    response.setNOT_FOUND(true);
                }
            }else{//Get
                //data body가 들어오면 Method405
                if(request.getBody() != null){
                    response.setMETHOD_NOT_ALLOWED(true);
                    if(!userMap.containsKey(split[2])){
                        response.setFORBIDDEN(true);
                    }else {
                        //userId있는데 data없으면 404
                        String data = userMap.get(split[2]).getData();
                        if (data == null) {
                            response.setNOT_FOUND(true);
                        }
                    }
                }else{ //body는 없다
                    //userid 없으면 403
                    if(!userMap.containsKey(split[2])){
                        response.setFORBIDDEN(true);
                    }else{
                        //userId있는데 data없으면 404
                        String data = userMap.get(split[2]).getData();
                        if(data == null){
                            response.setNOT_FOUND(true);
                        }else{
                            response.setData(data);
                            response.setOK(true);
                        }
                    }
                }
            }
        }
        for(Response response : responseList){
            System.out.println(response);
        }
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        size = Integer.parseInt(br.readLine());
        userList = new ArrayList<>();
        userMap = new HashMap<>();
        requestList = new ArrayList<>();
        responseList = new ArrayList<>();
        for(int i = 0; i < size; i++){
            String[] split = br.readLine().split(" ");
            Request request = new Request();
            Response response = new Response();
            if(split.length == 2){
                request.setMessage(split[0]);
                request.setMessage(split[1]);
            }else{//3
                request.setMessage(split[0]);
                request.setMessage(split[1]);
                String[] split2 = split[2].split("=");
                request.setBody(split2[1]);
            }
            requestList.add(request);
            responseList.add(response);
        }
    }

    static class User{
        private String name;
        private String data;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getData() {
            return data;
        }

        public void setData(String data) {
            this.data = data;
        }
    }

    static class Request{
        private String method;
        private String message;
        private String body;

        public String getMethod() {
            return method;
        }

        public void setMethod(String method) {
            this.method = method;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public String getBody() {
            return body;
        }

        public void setBody(String body) {
            this.body = body;
        }
    }

    static class Response{
        private boolean OK;
        private boolean CREATED;
        private boolean FORBIDDEN;
        private boolean NOT_FOUND;
        private boolean METHOD_NOT_ALLOWED;
        private String data;

        public String getData() {
            return data;
        }

        public void setData(String data) {
            this.data = data;
        }

        public boolean isOK() {
            return OK;
        }

        public void setOK(boolean OK) {
            this.OK = OK;
        }

        public boolean isCREATED() {
            return CREATED;
        }

        public void setCREATED(boolean CREATED) {
            this.CREATED = CREATED;
        }

        public boolean isFORBIDDEN() {
            return FORBIDDEN;
        }

        public void setFORBIDDEN(boolean FORBIDDEN) {
            this.FORBIDDEN = FORBIDDEN;
        }

        public boolean isNOT_FOUND() {
            return NOT_FOUND;
        }

        public void setNOT_FOUND(boolean NOT_FOUND) {
            this.NOT_FOUND = NOT_FOUND;
        }

        public boolean isMETHOD_NOT_ALLOWED() {
            return METHOD_NOT_ALLOWED;
        }

        public void setMETHOD_NOT_ALLOWED(boolean METHOD_NOT_ALLOWED) {
            this.METHOD_NOT_ALLOWED = METHOD_NOT_ALLOWED;
        }

        @Override
        public String toString() {
            if(OK){
                return data == null ? "200 OK" : "200 OK " + data;
            }else if(CREATED){
                return "201 CREATED";
            }else if(FORBIDDEN){
                return "403 FORBIDDEN";
            }else if(NOT_FOUND){
                return "404 NOT_FOUND";
            }else if(METHOD_NOT_ALLOWED){
                return "405 METHOD_NOT_ALLOWED";
            }
            return null;
        }
    }
}
