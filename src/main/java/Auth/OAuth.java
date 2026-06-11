package Auth;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import pojo.Api;
import pojo.GetCourse;
import pojo.webAutomation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static io.restassured.RestAssured.given;

public class OAuth {

    public static void main(String[]args) {

        String [] ExpectedCourses= {"Selenium Webdriver Java", "Cypress", "Protractor"};

        String Response = given().formParam("client_id", "692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
                .formParam("client_secret", "erZOWM9g3UtwNRj340YYaK_W")
                .formParam("grant_type", "client_credentials")
                .formParam("scope", "trust")
                .when().log().all().post("https://rahulshettyacademy.com/oauthapi/oauth2/resourceOwner/token").asString();
        System.out.println(Response);
        JsonPath js = new JsonPath(Response);
        String Response2 = js.getString("access_token");
        System.out.println(Response2);


        GetCourse Response3 = given().param("access_token", Response2)
                .when().log().all().get("https://rahulshettyacademy.com/oauthapi/getCourseDetails").as(GetCourse.class);
        System.out.println(Response3.getServices());

        // want to print price": "50"
        System.out.println(Response3.getCourses().getApi().get(1).getCourseTitle());

        //2nd way
        List<Api> getApi=Response3.getCourses().getApi();
        for (int i=0;i<getApi.size();i++){
            if(getApi.get(i).getCourseTitle().equalsIgnoreCase("Rest Assured Automation using Java"))
            {
                System.out.println(getApi.get(i).getPrice());
            }

        }
        //get the courses name of the WebAutomation;
        System.out.println("get the courses name of the WebAutomation");

        ArrayList<String> a = new ArrayList<String>();

        List<webAutomation> actualAllCourses=Response3.getCourses().getWebAutomation();

        for (int j=0;j<actualAllCourses.size();j++)
        {
             a.add(actualAllCourses.get(j).getCourseTitle());// adding all courses inside a



        }
        System.out.println(a);
        // compare actualcurses to expectedcourses
        //we can compare only arraylist to another arraylist here expectedcourses is a array only we need to convert it to arraylist

       List<String> X= Arrays.asList(ExpectedCourses);

        //now expected & actual
       System.out.println("Expected to actual");
        Assert.assertTrue(a.equals(X));
    }
}
























//
//    {
//        "instructor": "RahulShetty",
//            "url": "rahulshettycademy.com",
//            "services": "projectSupport",
//            "expertise": "Automation",
//            "courses": {
//        "webAutomation": [
//        {
//            "courseTitle": "Selenium Webdriver Java",
//                "price": "50"
//        },
//        {
//            "courseTitle": "Cypress",
//                "price": "40"
//        },
//        {
//            "courseTitle": "Protractor",
//                "price": "40"
//        }
//    ],
//        "api": [
//        {
//            "courseTitle": "Rest Assured Automation using Java",
//                "price": "50"
//        },
//        {
//            "courseTitle": "SoapUI Webservices testing",
//                "price": "40"
//        }
//    ],
//        "mobile": [
//        {
//            "courseTitle": "Appium-Mobile Automation using Java",
//                "price": "50"
//        }
//    ]
//    },
//        "linkedIn": "https://www.linkedin.com/in/rahul-shetty-trainer/"
//    }
//}



