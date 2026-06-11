package Auth;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import pojo.LoginResponse;
import pojo.cred;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

public class Ecom {

    public static void main (String[]args){

       RequestSpecification Req= new RequestSpecBuilder()
               .setBaseUri("https://rahulshettyacademy.com").setContentType(ContentType.JSON)
               .build();

       cred cred = new cred();
       cred.setUserEmail("ssm8882@gmail.com");
       cred.setUserPassword("Samir8882@");


       RequestSpecification req1 = given().log().all().spec(Req).body(cred);
        LoginResponse LoginResponse = req1.log().all().when().post("/api/ecom/auth/login")
                .then().log().all().extract().response().as(LoginResponse.class);

//        System.out.println(LoginResponse.getToken());
//        System.out.println(LoginResponse.getUserId());
//        System.out.println(LoginResponse.getMessage());


    }
}
