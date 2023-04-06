package ApiAutomation;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PostsBlog {
    private final String URL = "https://test-stand.gb.ru/";
    private final String apiKey = "c52007b76e33c18155c5b61bc259808d";


    RequestSpecification requestSpecification = null;


    @BeforeEach
    @Test
    void beforeTest1() {
        requestSpecification = new RequestSpecBuilder()
                .addQueryParam("apiKey", "c52007b76e33c18155c5b61bc259808d")
                .addQueryParam("owner", "false")
                .log(LogDetail.ALL)
                .build();
    }


    @BeforeEach
    void beforeTest() {
        Object responseSpecification = new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectStatusLine("HTTP/1.1 200 OK")
                .expectContentType(ContentType.JSON)
                .expectResponseTime(Matchers.lessThan(5000L))
                .expectHeader("Access-Control-Allow-Credentials", "true")
                .build();
    }







}
