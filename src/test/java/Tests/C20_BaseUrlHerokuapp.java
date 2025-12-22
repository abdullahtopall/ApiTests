package Tests;

import baseUrl.BaseUrlHerokuapp;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C20_BaseUrlHerokuapp extends BaseUrlHerokuapp {

    @Test
    public void test01() {
        // 1-endpoint ve request body olustur
        specHerokuapp.pathParam("pp1","booking");
        JSONObject requestBody = new JSONObject();
        JSONObject rezervasyonTarihleri = new JSONObject();

        rezervasyonTarihleri.put("checkin","2021-06-01");
        rezervasyonTarihleri.put("checkout","2021-06-10");

        requestBody.put("firstname","Ahmet");
        requestBody.put("lastname","Bulut");
        requestBody.put("totalprice",500);
        requestBody.put("depositpaid",false);
        requestBody.put("bookingdates",rezervasyonTarihleri);
        requestBody.put("additionalneeds","wi-fi");

        // 2-expected data olustur

        // 3-request gonder,donen response kaydet
        Response response = given().contentType(ContentType.JSON)
                .when().spec(specHerokuapp).body(requestBody.toString())
                .post("/{pp1}");

        // 4-assertions
        response
                .then()
                .assertThat()
                .statusCode(200)
                .body("booking.firstname", Matchers.equalTo("Ahmet"));

    }
}
