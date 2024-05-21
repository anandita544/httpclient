package org.example;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Put {
    public static void main(String args[])
    {
        HttpClient client=HttpClient.newHttpClient();
        String requestBody = "{\"name\": \"John\", \"job\": \"Developer\"}";
        HttpRequest request= null;
        try {
            request = HttpRequest.newBuilder().uri(new URI("https://reqres.in/api/users/2")).PUT(HttpRequest.BodyPublishers.ofString(requestBody)).header("Content-Type","application/json").build();
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
        try {
            HttpResponse reponse= client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(reponse.body());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
