package Tests;

import TestDatalari.TestDataJsonPlaceholder;
import baseUrl.BaseUrlJsonPlaceholder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.given;

public class C25_Put_TestDataClassKullanimi extends BaseUrlJsonPlaceholder {

    @Test
    public void test01() {
        // 1-endpoint ve request body olustur
        specJsonPlaceholder.pathParams("pp1","posts","pp2",70);
        JSONObject requestBody = new JSONObject();
        requestBody.put("title","Ahmet");
        requestBody.put("body","Merhaba");
        requestBody.put("userId",10);
        requestBody.put("id",70);


        // 2-expected data olustur
        JSONObject expectedData = new JSONObject();
        expectedData.put("title","Ahmet");
        expectedData.put("body","Merhaba");
        expectedData.put("userId",10);
        expectedData.put("id",70);

        // 3-request gonder, donen response'i kaydet
        Response response = given().contentType(ContentType.JSON)
                .when().spec(specJsonPlaceholder).body(requestBody.toString())
                .put("/{pp1}/{pp2}");
        JsonPath responseJsonPath = response.jsonPath();

        // 4-assertions
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(response.getStatusCode(), TestDataJsonPlaceholder.basariliSorguStatusCode);
        softAssert.assertEquals(response.getHeader("Connection"),TestDataJsonPlaceholder.headerConnection);
        softAssert.assertEquals(responseJsonPath.get("id"),expectedData.get("id"));
        softAssert.assertEquals(responseJsonPath.get("title"),expectedData.get("title"));
        softAssert.assertEquals(responseJsonPath.get("body"),expectedData.get("body"));
        softAssert.assertEquals(responseJsonPath.get("userId"),expectedData.get("userId"));


    }
}
