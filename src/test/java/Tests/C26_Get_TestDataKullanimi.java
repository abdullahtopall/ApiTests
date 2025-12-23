package Tests;

import TestDatalari.TestDataDummyExample;
import TestDatalari.TestDataJsonPlaceholder;
import baseUrl.BaseUrlDummyExample;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.given;

public class C26_Get_TestDataKullanimi extends BaseUrlDummyExample {

    @Test
    public void test01() {
        // 1-endpoint ve request body oluştur
        specDummyExample.pathParams("pp1","employee","pp2","3");

        // 2-expected data oluştur
        JSONObject expectedData =
                TestDataDummyExample.jsonBodyOlustur(3,"Ashton Cox",86000,66,"");

        // 3-request gonder donen response'i kaydet
        Response response = given().spec(specDummyExample)
                .when()
                .get("/{pp1}/{pp2}");

        JsonPath responseJsonPath = response.jsonPath();

        // 4-assertions
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(TestDataDummyExample.basariliSorguStatusCode,response.getStatusCode());
        softAssert.assertEquals(TestDataDummyExample.contentType,response.getContentType());
        softAssert.assertEquals(responseJsonPath.get("status"),expectedData.get("status"));
        softAssert.assertEquals(responseJsonPath.get("data.id"),expectedData.getJSONObject("data").get("id"));
        softAssert.assertEquals(responseJsonPath.get("data.employee_name"),expectedData.getJSONObject("data").get("employee_name"));
        softAssert.assertEquals(responseJsonPath.get("data.employee_salary"),expectedData.getJSONObject("data").get("employee_salary"));
        softAssert.assertEquals(responseJsonPath.get("data.employee_age"),expectedData.getJSONObject("data").get("employee_age"));
        softAssert.assertEquals(responseJsonPath.get("data.profile_image"),expectedData.getJSONObject("data").get("profile_image"));
        softAssert.assertEquals(responseJsonPath.get("message"),expectedData.get("message"));


    }
}
