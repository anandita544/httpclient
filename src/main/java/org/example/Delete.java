package org.example;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Delete {
    public static void main(String args[]){
        HttpClient client=HttpClient.newHttpClient();
        try {
            HttpRequest request= HttpRequest.newBuilder().uri(new URI("https://reqres.in/api/users/2")).DELETE().build();

            HttpResponse response= null;
            try {
                response = client.send(request, HttpResponse.BodyHandlers.ofString());
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(response.statusCode());}
        catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }

    }
}
