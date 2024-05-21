package StepDefinitions;

import Reader.ConfigReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class GetUsers {
    private HttpResponse<String> httpResponse;


    @Then("user should receive a valid response {int}")
    public void userShouldReceiveAValidResponse(int statusCode) {
        assertEquals(httpResponse.statusCode(), statusCode);
        assertTrue(httpResponse.body() != null && !httpResponse.body().isEmpty());
    }

    @Given("user send a GET request to {string}")
    public void userSendAGETRequestTo(String url) {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = null;
        try {
            request = HttpRequest.newBuilder()
                    .uri(new URI(url))
                    .GET()
                    .build();
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }

        try {
            httpResponse = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}