package Line.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Num4 {
    private static int n;
    // request String[]
    private static Request[] requestArray;
//    private static List<String> idList;
    private static Map<String, String> idDataMap;
    private static StringBuilder sb;
    // id 리스트 저장 : list -> id
    // id별 data 저장 : map -> key:id value:data
    public static void main(String[] args) throws IOException {
        init();

        for(int i = 0; i < n; i++) {
            Request request = requestArray[i];
            String id = null;
            if (request.endpoints.length > 1 && "users".equals(request.endpoints[1])) { // 0은 "" //ㄱ
                if (request.endpoints.length > 2 && !"data".equals(request.endpoints[2])) { // ㄴ
                    id = request.endpoints[2];
                    if (request.endpoints.length == 3) { // /data가 안 붙어 있으면 //ㄷ
                        if ("POST".equals(request.method.toUpperCase())) { //ㄹ
                            if (!idDataMap.containsKey(id)) { //ㅁ
                                idDataMap.put(id, null);
                                sb.append("201 CREATED\n");
                            } else { //이미 존재
                                sb.append("403 FORBIDDEN\n");
                            }
                        } else {
                            sb.append("405 METHOD_NOT_ALLOWED\n");
                        }
                    } else if ("data".equals(request.endpoints[3])) { //data가 붙어 있으려면 4
                        if (request.endpoints.length == 4) { //ㅂ
                            if ("POST".equals(request.method.toUpperCase())) {//ㅅ
                                if (request.value != null) { //ㅇ
                                    if (idDataMap.containsKey(id)) { ///ㅈ
                                        idDataMap.put(id, request.value);
                                        sb.append("200 OK\n");
                                    } else {
                                        sb.append("403 FORBIDDEN\n");
                                    }
                                } else {
                                    sb.append("405 METHOD_NOT_ALLOWED\n");
                                }
                            } else if ("GET".equals(request.method.toUpperCase())) { //ㅅ
                                if (request.value == null) { //ㅊ
                                    if (idDataMap.containsKey(id)) { //ㅋ
                                        if (idDataMap.get(id) != null) { //ㅌ
                                            sb.append("200 OK " + idDataMap.get(id) + "\n");
                                        } else {
                                            sb.append("404 NOT_FOUND\n");
                                        }
                                    } else {
                                        sb.append("403 FORBIDDEN\n");
                                    }
                                } else {
                                    sb.append("405 METHOD_NOT_ALLOWED\n");
                                }
                            } else {
                                sb.append("405 METHOD_NOT_ALLOWED\n");
                            }
                        } else { // 4보다 크거나 하면
                            sb.append("404 NOT_FOUND\n");
                        }
                    } else {
                        sb.append("404 NOT_FOUND\n");
                    }
                } else {
                    sb.append("404 NOT_FOUND\n");
                }
            } else {
                sb.append("404 NOT_FOUND\n");
            }
        }


        // if문으로 분기해서 해당 출력문구 출력
        System.out.println(sb.toString());
    }//main

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        requestArray = new Request[n];
        for(int i = 0 ; i < n; i++){
            // request 저장
            String request = br.readLine();
//            int index = request.indexOf(" ");
            String[] splitRequest = request.split(" ");
            if(splitRequest.length == 2){
                // method 넣고
                String method = splitRequest[0];
                String endpoint = splitRequest[1];
                requestArray[i] = new Request(method, endpoint, null);
            } else if(splitRequest.length == 3){
                String method = splitRequest[0];
                String endpoint = splitRequest[1];
                String parameter = splitRequest[2];
                requestArray[i] = new Request(method, endpoint, parameter);
            } else{
                requestArray[i] = new Request(null, null, null);
            }
        }

//        idList = new LinkedList<>();
        idDataMap = new HashMap<>();
        sb = new StringBuilder();

    }

    static class Request{
        String method; // method
        String[] endpoints; // endpoint
        String parameter; // parameter
        String value;

        Request(String method, String endpoint, String parameter){
            this.method = method;
            this.endpoints = endpoint.split("/");
            this.parameter = parameter;
            if(parameter != null && parameter.startsWith("value=")){
                this.value = parameter.substring("value=".length());
            }
        }
    }
}
