package Auth;

import files.DispatchBody;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class TrueLogin {

    public static void main(String[]args) {

        RequestSpecification request= new RequestSpecBuilder().setBaseUri("https://stage-integration.truemedsapi.in/OauthService/customlogin").setContentType(ContentType.JSON)
                .addQueryParam("ankush.mhala@truemeds.in","Truemeds@2024").build();

        DispatchBody DispatchBody =new DispatchBody();
        DispatchBody.setPortal("WAREHOUSE_MULTIORDER_null");
        DispatchBody.setLoginId("ankush.mhala@truemeds.in");
        DispatchBody.setEncPassword("09/4i8RP7csKAOTR6B1c+ix8fTqMBdfoqICRDXpr+FY=");;
        DispatchBody.setEncSecretKey("D8Jng9tWgyMySzCiwpMhxDBIk0IEMvuTeR39KN7EtPqD6fa280Og7BqWjjf8prfUd20Vl9AnJQnD4IgikC8t1M74UHtmdyU4uRKWLHhWYHU1V+U5cnLrMuuny6ZE6ooKi/1QABe2Q6Mvi7t2ZbDN02csvqXLiUT/iwWZ5QuVEwY=");

        RequestSpecification Req= given().spec(request).body(DispatchBody);

        Req.when().post("doctorId=9413&isSuperDoctor=false").then().log().all().extract().response()


    }
}
