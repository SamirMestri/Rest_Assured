package StepDefinition;

import Resourses.TestDataBuild;
import Resourses.Utility;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import pojo.Addplace;
import pojo.location;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class StepDefination extends Utility {

    RequestSpecification giv;
    ResponseSpecification res;
    Response Response;
    TestDataBuild testdata= new TestDataBuild();

    @Given("Add Place Payload")
    public void add_palce_payload() throws FileNotFoundException {
        // Write code here that turns the phrase above into concrete actions

        giv=given().spec(RequestSpecification()).body(testdata.AddPlacePayload());
    }
    @When("user calls {string} with {string} http request")
    public void user_calls_with_http_request(String string, String string2) {
        // Write code here that turns the phrase above into concrete actions
        res =new ResponseSpecBuilder().expectStatusCode(200).build();
        Response = giv.when().post("/maps/api/place/add/json")
                .then().spec(res).extract().response();

    }
    @Then("the API call got success with status code {int}")
    public void the_api_call_got_success_with_status_code(Integer int1) {
        // Write code here that turns the phrase above into concrete actions
        assertEquals(Response.getStatusCode(),200);
    }
    @Then("{string} in response body is {string}")
    public void in_response_body_is(String ActualValue, String ExpectedValue) {
        // Write code here that turns the phrase above into concrete actions
        String status=Response.asString();
        JsonPath js = new JsonPath(status);
        assertEquals(js.get(ActualValue).toString(),ExpectedValue);
    }
}
