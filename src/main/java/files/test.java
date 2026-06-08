package files;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.given;

public class test {
    public static void main(String args[])
    {
        RestAssured.baseURI=("https://stage-integration.truemedsapi.in/CustomerService/v1/getAllCustomerOrders");
        String Save= given().param("customerId","52993").body("{\n" +
                        "    \"message\": \"Successfully fetched all orders for customer : 52993 and statusIds : [Delivered Orders]\",\n" +
                        "    \"statusValue\": \"OK\",\n" +
                        "    \"statusCode\": 200,\n" +
                        "    \"timeTakenInMs\": 33,\n" +
                        "    \"responseData\": {\n" +
                        "        \"ordersList\": [],\n" +
                        "        \"patientList\": null,\n" +
                        "        \"recordsCount\": 0,\n" +
                        "        \"pageCount\": 0\n" +
                        "    }\n" +
                        "}")
                .header("Authorization","Bearer eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiI1Mjk5MyIsImVudGl0eVR5cGUiOiJJRCIsInJvbGVMaXN0IjpbIlJPTEVfQ1VTVE9NRVIiXSwiaXNzIjoiY29tLnRydWVtZWRzLmF1dGhfc2VydmljZSIsImV4cCI6MTc3NjQwNjE1MiwiaWF0IjoxNzc2MzE5NzUyfQ.x8GI16OP3Fnt460JugsPLZ1yJh900Y6Yjlgo2BHPIRS7r9k2WLkmG7gPsFo8QNup-dpzs7BCcJDkRp-zrmFrmu4scy64cIHXH_vFkWK8CrtSma0bnFX3dArVQ8JEkUFx2FEIuJtSZWbR0K-gKrmai_Jd1qzaJBL5Ah3anZuxrPfAbYLL0dBXAlgLEXxwnyKFKpyhKzsMFYkyYhm6oODrkK79sbh6U2swak5gNI5-JnW7Rul7Ykg3EgcKy6M3f3MrxhZkyTm5QnboPE8v28AUdWylSbS1YYFP_tBUT6tWSrAtKyByypHJNmdX1HU2QPwaWVlXAvuaY4kFFMza3SMBSw")
                .when().get("customerId=52993&page=0&patientIds=&result=5")
.then().log().all().assertThat().statusCode(404).extract().response().asString();
        System.out.println(Save);
        JsonPath js = new JsonPath(Save);
        String New =js.get("error");
        System.out.println(New);

    }
}
