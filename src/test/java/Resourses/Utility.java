package Resourses;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import java.io.*;
import java.util.Properties;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class Utility {
    RequestSpecification req;

    public RequestSpecification RequestSpecification() throws IOException {
        PrintStream log = new PrintStream(new File("Logging.txt"));
        req = new RequestSpecBuilder().setBaseUri(getGlobleVlaue("baseURI"))
                .addQueryParam("key", "qaclick123")
                .addFilter(RequestLoggingFilter.logRequestTo(log))
                .addFilter(ResponseLoggingFilter.logResponseTo(log))
                .setContentType(ContentType.JSON).build();
        return req;
    }
    public static  String getGlobleVlaue(String key) throws IOException {
        Properties prop =new Properties();
        FileInputStream fis = new FileInputStream("D:\\Java\\eclipseProjects\\API_Framework\\src\\test\\java\\Resourses\\globle.properties");
        prop.load(fis);
        return prop.getProperty(key);

    }
}
