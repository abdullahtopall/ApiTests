package Tests;

import TestDatalari.TestDataDummyExample;
import TestDatalari.TestDataJsonPlaceholder;
import baseUrl.BaseUrlDummyExample;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C26_Get_TestDataKullanimi extends BaseUrlDummyExample {

    @Test
    public void test01() {
        // 1-endpoint ve request body oluştur
        specDummyExample.pathParams("pp1","employee","pp2","3");

        // 2-expected data oluştur
        JSONObject expectedData =
                TestDataDummyExample.jsonBodyOlustur(3,"Ashton Cox","86000","66","");

        // 3-request gonder donen response'i kaydet
        Response response = given().spec(specDummyExample)
                .when()
                .get("/{pp1}/{pp2}");
        JsonPath responseJsonPath = response.jsonPath();

        // 4-assertions
        assertEquals(response.getStatusCode(),TestDataDummyExample.basariliSorguStatusCode);
        assertEquals(response.getContentType(),TestDataDummyExample.contentType);
        assertEquals(expectedData.getString("status"),responseJsonPath.getString("status"));
        assertEquals(expectedData.getJSONObject("data").getInt("id"),responseJsonPath.getInt("data.id"));
        assertEquals(expectedData.getJSONObject("data").getString("employee_name"),responseJsonPath.getString("data.employee_name"));
        assertEquals(expectedData.getJSONObject("data").getString("employee_salary"),responseJsonPath.getString("data.employee_salary"));
        assertEquals(expectedData.getJSONObject("data").getString("employee_age"),responseJsonPath.getString("data.employee_age"));
        assertEquals(expectedData.getJSONObject("data").getString("profile_image"),responseJsonPath.getString("data.profile_image"));
        assertEquals(expectedData.getString("message"),responseJsonPath.getString("message"));

    }
}
