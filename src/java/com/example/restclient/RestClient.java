package java.com.example.restclient;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

public class RestClient {

    public static RestResponse request(String url , HttpMethod method, String body, Map<String, String> headers) throws IOException {
        HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
        connection.setRequestMethod(method.name());
        connection.setDoInput(true);

        if (headers != null) {
            for (Map.Entry<String , String> entry : headers.entrySet()) {
                connection.setRequestProperty(entry.getKey() , entry.getValue());
            }
        }
        if (method == HttpMethod.POST || method == HttpMethod.PUT) {
            connection.setDoOutput(true);
            try (OutputStream os = connection.getOutputStream()) {
                os.write(body.getBytes());
                os.flush();
            }
        }

        int status = connection.getResponseCode();
        InputStream stream = (status < 400) ? connection.getInputStream() : connection.getErrorStream();
        String response = readStream(stream);

        return new RestResponse(status , response);



    }
    private static String readStream(InputStream stream) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
        StringBuilder result = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            result.append(line);
        }
        return result.toString();
    }
}
