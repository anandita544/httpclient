package org.example;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Post {
    public static void main(String args[]){
        HttpClient client =HttpClient.newHttpClient();
        try {
            String requestBody = "{\"name\": \"John\", \"job\": \"Developer\"}";
            HttpRequest request= HttpRequest.newBuilder().uri(new URI("https://reqres.in/api/users")).POST(HttpRequest.BodyPublishers.ofString(requestBody)).header("Content-Type", "application/json").build();
            HttpResponse<String> response = null;
            try {
                response = client.send(request, HttpResponse.BodyHandlers. ofString());
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(response.body());
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }
}
