package org.example;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Get {

    public static void main(String[] args) {
        try {HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI("https://reqres.in/api/users?page=2"))
                    .GET()
                    .build();
            HttpResponse httpResponse= null;
            try {
                httpResponse = client.send(request, HttpResponse.BodyHandlers. ofString());
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(httpResponse.body());
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }
}