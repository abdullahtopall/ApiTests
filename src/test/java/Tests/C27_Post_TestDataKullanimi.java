package Tests;

import TestDatalari.TestDataHerokuapp;
import baseUrl.BaseUrlHerokuapp;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.replaceFiltersWith;

public class C27_Post_TestDataKullanimi extends BaseUrlHerokuapp {

    @Test
    public void test01() {
        // 1-endpoint ve request body olustur
        specHerokuapp.pathParam("pp1","booking");
        JSONObject requestBody = TestDataHerokuapp.jsonBodyOlustur("Ahmet","Bulut",500,false,
                "2021-06-01","2021-06-10","wi-fi");

        // 2-expected data olustur
        JSONObject expectedData = TestDataHerokuapp.expectedJsonBodyOlustur("Ahmet","Bulut",500,false,
                "2021-06-01","2021-06-10","wi-fi");

        // 3-request gonder donen response'i kaydet
        Response response = given().spec(specHerokuapp).contentType(ContentType.JSON)
                .when().body(requestBody.toString())
                .post("/{pp1}");

        // 4-assertions
        JsonPath responseJsonPath = response.jsonPath();

        Assert.assertEquals(expectedData.getJSONObject("booking").get("firstname"),responseJsonPath.get("booking.firstname"));
        Assert.assertEquals(expectedData.getJSONObject("booking").get("lastname"),responseJsonPath.get("booking.lastname"));
        Assert.assertEquals(expectedData.getJSONObject("booking").get("totalprice"),responseJsonPath.get("booking.totalprice"));
        Assert.assertEquals(expectedData.getJSONObject("booking").get("depositpaid"),responseJsonPath.get("booking.depositpaid"));
        Assert.assertEquals(expectedData.getJSONObject("booking").getJSONObject("bookingdates").get("checkin"),
                responseJsonPath.get("booking.bookingdates.checkin"));
        Assert.assertEquals(expectedData.getJSONObject("booking").getJSONObject("bookingdates").get("checkout"),
                responseJsonPath.get("booking.bookingdates.checkout"));

    }
}
