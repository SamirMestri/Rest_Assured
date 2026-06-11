package Auth;

import io.restassured.RestAssured;
import pojo.Addplace;
import pojo.location;
import pojo.types;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class Serialization {

    public static void main(String []args){

        RestAssured.baseURI = "https://rahulshettyacademy.com";

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

       String postman = given().queryParam("key","qaclick123")
                .body(a)
                .when().post("/maps/api/place/add/json")
               .then().assertThat().statusCode(200).extract().response().asString();

       System.out.println(postman);

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