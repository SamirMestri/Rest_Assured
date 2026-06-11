package files;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import restAssured.ReUsableMethods;

import javax.naming.Name;

import static io.restassured.RestAssured.*;

public class DynamicJson {

    @Test(dataProvider = "fetch")
    public void addBook (String isbn ,String aisle , String author) {
        RestAssured.baseURI = "http://216.10.245.166";
        String response = given().body(Body.AddBook(isbn, aisle, author))
                .when().post("Library/Addbook.php")
                .then().log().all().assertThat().statusCode(200)
                .extract().response().asString();
        JsonPath js = ReUsableMethods.rawToJson(response);
        String ID = js.get("ID");
        System.out.println(ID);

        given().body("{\n" +
                        "    \"ID\": \""+ID+"\"\n" +
                        "}")
                .when().delete("Library/DeleteBook.php")
                .then().log().all().assertThat().statusCode(200);
    }
    @DataProvider(name="fetch")
    public Object[][] BookData(){

        return new Object[][] {{"pra","8890","prasad"},{"pra","5653","prashik"},{"vish","3526","vishnu"}};
    }
}
