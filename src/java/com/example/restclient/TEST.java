package java.com.example.restclient;

import java.util.HashMap;
import java.util.Map;

public class TEST {
    public static void main(String[] args) {
        String url = "http://jsonplaceholder.typicode.com/posts";
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");

        String body = "{ \"title\": \"Test\", \"body\": \"Hello World!\", \"userId\": 1 }";

        try {
            RestResponse response = RestClient.request(url, HttpMethod.POST, body, headers);
            System.out.println(response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}