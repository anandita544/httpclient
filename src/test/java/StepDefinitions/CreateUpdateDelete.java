package StepDefinitions;

import Reader.ConfigReader;
import com.google.gson.JsonParser;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CreateUpdateDelete {
    public String postRequestUrl = ConfigReader.getBaseUrl() + ConfigReader.getPostUrl();
    public String putRequestUrl = ConfigReader.getBaseUrl() + ConfigReader.getPutUrl();
    public String deleteRequestUrl=ConfigReader.getBaseUrl() + ConfigReader.getDeleteUrl();
public String requestBody= String.valueOf(ConfigReader.getRequestBody());



    HttpRequest request= null;
    HttpResponse<String> response;
    HttpClient client=HttpClient.newHttpClient();
    @Given("user sends a request body")
    public void userSendsARequestBody() {
        System.out.println("Request Body: " + requestBody);
    }

    @When("user hit the url of post api")
    public void userHitTheUrlOfPostApi() throws URISyntaxException {



        try {
            request = HttpRequest.newBuilder().uri(new URI(postRequestUrl)).POST(HttpRequest.BodyPublishers.ofString(requestBody)).header("Content-Type", "application/json").build();
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }

        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println("Response Status Code: " + response.statusCode());
            System.out.println("Response Body: " + response.body());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Then("user should receive a valid status code {}")
    public void userShouldReceiveAValidStatusCode(int statusCode) {
        System.out.println(response.statusCode());
        assertEquals(response.statusCode(), statusCode);
    }

    @And("user should receive a valid responseBody")
    public void userShouldReceiveAValidResponseBody() {
        System.out.println(response.body());
        assertTrue(response.body().contains("id"));
    }

    @When("user hit the url of put api")
    public void userHitTheUrlOfPutApi() {
        try {
            request = HttpRequest.newBuilder().uri(new URI(putRequestUrl)).PUT(HttpRequest.BodyPublishers.ofString(requestBody)).header("Content-Type","application/json").build();
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
        try {
            response= client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @When("user hit the url of delete api")
    public void userHitTheUrlOfDeleteApi() {
        HttpClient client=HttpClient.newHttpClient();
        try {
            HttpRequest request= HttpRequest.newBuilder().uri(new URI(deleteRequestUrl)).DELETE().build();


            try {
                response = client.send(request, HttpResponse.BodyHandlers.ofString());
            } catch (IOException | InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }

    }

    @And("user get a response which contains {}")
    public void userGetAResponseWhichContainsUpdatedAt(String a) {
        assertTrue(response.body().contains(a));
    }
}
