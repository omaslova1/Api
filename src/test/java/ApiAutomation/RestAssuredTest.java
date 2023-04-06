package ApiAutomation;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import jdk.internal.net.http.ResponseSubscribers;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.testng.annotations.BeforeClass;

import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;

public class RestAssuredTest {

    @Test
    @DisplayName("Тестирование тестового запроса Post с проверкой status code = 500")
    public void postRequestCheckStatusCode() {
        given()
                .spec(requestSpecification())
                .body(new Posts("login", "password"))
                .post("https://test-stand.gb.ru/gateway/login")
                .then()
                .statusCode(HttpStatus.SC_CREATED);
        ResponseSubscribers.HttpResponseInputStream response = null;
        System.out.println(response.getBody().toString());
//        Assert.assertEquals(statusCode,500);

    }

    private RequestSpecification requestSpecification() {
        return null;
    }

    @Test
    void getSpecificationPositiveTest() {
        given()
                .spec(requestSpecification)
                .when()
                .get("https://test-stand.gb.ru/api/posts?owner=notMe&sort=createdAt&order=ASC&page=1")
                .then()
                .spec(responseSpecification);
        HttpResponse<Object> response = null;
        assertThat(response.body(), equalTo("Контент"));

    }

    @BeforeClass
    public void setBaseUri() {

        RestAssured.baseURI = "https://test-stand.gb.ru/api/posts?owner=notMe&sort=createdAt&order=ASC&page=1";
    }


//    @Test
//    public void postString() {
//        Map<String, Object> jsonAsMap = new HashMap<>();
//        jsonAsMap.put("username", "active");
//        jsonAsMap.put("password", "c76a5e84e4");
//
//        given()
//                .contentType("application/json")
//                .body(jsonAsMap)
//                .when()
//                .post("login")
//                .then().statusCode(200).log().all();
//    }


    @BeforeClass
    public void setStringUri() {
        RestAssured.baseURI = "https://test-stand.gb.ru/api/posts";
    }

    @Test
    public void postString1() {
        given()
                .params("password", "active")
                .params("username", "c76a5e84e4")
                .when()
                .contentType(ContentType.JSON)
                .post("/login")
                .then().statusCode(500).log().all();

    }


    @Test
    void getRecipePositiveTest() {
        given().spec(getRequestSpecification())
                .when()
                .get("https:/api/posts?owner=notMe&sort=createdAt&order=ASC&page=1")
                .then()
                .spec(responseSpecification);
    }

    private RequestSpecification getRequestSpecification() {
        return null;
    }

    @Test
    public void get() {
        given().spec(getRequestSpecification());
        RestAssured.baseURI = "https://test-stand.gb.ru/";
        given()
                .param("sort", "createdAt")
                .when()
                .get("/get")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("meta", equalTo("prevPage"));


    }

    @Test
    public void getWithExtract() {
        baseURI = "https://test-stand.gb.ru/";

        Response response = given()
                .param("owner", "notMe")
                .param("sort", "createdAt")
                .when()
                .get("/get")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("draft", equalTo("false"))
                .extract()
                .as(Response.class);;

        assertThat(response.getBody(), equalTo("Page"));

    }
}


