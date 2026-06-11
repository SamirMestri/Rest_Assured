package Auth;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import pojo.Addplace;
import pojo.location;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

public class SpecBuilderTest {

    public static void main(String []args){

        Addplace a = new Addplace();
        a.setAddress("29, side layout, cohen 09");
        a.setName("Frontline house");
        a.setPhone_number("(+91) 983 893 3937");
        a.setWebsite("http://google.com");
        a.setLanguage("French-IN");
        a.setAccuracy(50);

        location b = new location();
        b.setLat(-38.383494);
        b.setLng(33.427362);
        a.setLocation(b);

        List<String> mylist= new ArrayList<>();
        mylist.add("shoe park");
        mylist.add("shop");
        a.setTypes(mylist);


        RequestSpecification req =new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").addQueryParam("key","qaclick123").build();
        RequestSpecification giv = given().spec(req).body(a);

        ResponseSpecification res =new ResponseSpecBuilder().expectStatusCode(200).build();
        Response Response = giv.when().post("/maps/api/place/add/json")
               .then().spec(res).extract().response();

        String re = Response.asString();
        System.out.println(re);

    }
}


//
//
//{
//        "location": {
//        "lat": -38.383494,
//        "lng": 33.427362
//        },
//        "accuracy": 50,
//        "name": "Frontline house",
//        "phone_number": "(+91) 983 893 3937",
//        "address": "29, side layout, cohen 09",
//        "types": [
//        "shoe park",
//        "shop"
//        ],
//        "website": "http://google.com",
//        "language": "French-IN"
//        }