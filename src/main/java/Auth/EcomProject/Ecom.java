package Auth.EcomProject;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;

import java.io.File;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

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

        System.out.println(LoginResponse.getToken());
        String token =LoginResponse.getToken();
        System.out.println(LoginResponse.getUserId());
        System.out.println(LoginResponse.getMessage());
//Create Product

        RequestSpecification addProductBaseRequest= new RequestSpecBuilder()
                .setBaseUri("https://rahulshettyacademy.com")
                .addHeader("authorization",token)
                .build();

        RequestSpecification addproduct =given().log().all().spec(addProductBaseRequest).param("productName", "Laptop")
                .param("productAddedBy", "6a27c47517ee3e78bac9984a")
                .param("productCategory", "fashion")
                .param("productSubCategory", "shirts")
                .param("productPrice", "11500")
                .param("productDescription", "Addias Originals")
                .param("productFor", "women")
                .multiPart("productImage",new File("C:\\Users\\Asus\\Downloads\\pexels-jakubzerdzicki-21299740.jpg"));
        String AddProductResp=  addproduct.when().post("/api/ecom/product/add-product")
                                .then().log().all().extract().response().asString();
        JsonPath js = new JsonPath(AddProductResp);
        String productid=js.get("productId");
        String Message= js.get("message");

//Order Placement

        RequestSpecification addRequest= new RequestSpecBuilder()
                .setBaseUri("https://rahulshettyacademy.com")
                .addHeader("authorization",token)
                .setContentType(ContentType.JSON)
                .build();

OrderDetails OrderDetail= new OrderDetails();
OrderDetail.setCountry("India");
OrderDetail.setProductId(productid);

List<OrderDetails> orderDetailList = new ArrayList<OrderDetails>();
orderDetailList.add(OrderDetail);
Order orders = new Order();
orders.setOrder(orderDetailList);

        RequestSpecification orderproduct =given().log().all().spec(addRequest)
                .body(orders);
                String placeorder=orderproduct.when().post("api/ecom/order/create-order")
                        .then().log().all().extract().response().asString();
        System.out.println(placeorder);

//Delete product
        RequestSpecification DeleteProdBaseURL= new RequestSpecBuilder()
                .setBaseUri("https://rahulshettyacademy.com")
                .addHeader("authorization",token)
                .setContentType(ContentType.JSON)
                .build();

        RequestSpecification DeleteRpod =given().log().all().spec(DeleteProdBaseURL)
                .pathParam("productId",productid);
        String Delete= DeleteRpod.when().delete("/api/ecom/product/delete-product/{productId}")
                .then().log().all().extract().response().asString();
        System.out.println(Delete);


    }
}
