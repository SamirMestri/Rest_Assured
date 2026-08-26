package Resourses;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

public class Utility {

    public static RequestSpecification req;

    public RequestSpecification requestSpecification() throws IOException {

        if (req == null) {

            PrintStream log = new PrintStream(new File("Logging.txt"));

            req = new RequestSpecBuilder()
                    .setBaseUri(getGlobalValue("baseURI"))
                    .addQueryParam("key", "qaclick123")
                    .addFilter(RequestLoggingFilter.logRequestTo(log))
                    .addFilter(ResponseLoggingFilter.logResponseTo(log))
                    .setContentType(ContentType.JSON)
                    .build();
        }

        return req;
    }

    public static String getGlobalValue(String key) throws IOException {

        Properties prop = new Properties();

        try (FileInputStream fis = new FileInputStream(
                "D:\\Java\\eclipseProjects\\API_Framework\\src\\test\\java\\Resourses\\globle.properties")) {

            prop.load(fis);
        }

        return prop.getProperty(key);
    }
}