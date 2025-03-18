package java.com.example.restclient;

public class RestResponse {

    private final int statusCode;
    private final String body;

    public RestResponse(int statusCode , String body) {
        this.statusCode = statusCode;
        this.body = body;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public String getBody() {
        return body;
    }

    @Override
    public String toString() {
        return "Status: " + statusCode + "\nResponse: " + body;
    }
}
