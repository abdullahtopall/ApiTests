package Tests;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C15_Get_SoftAssertIleExpectedDataTesti {

    @Test
    public void test01() {

        // 1- endpoint ve request body olustur
        String url = "http://dummy.restapiexample.com/api/v1/employee/3";


        // 2- expected data olustur
        JSONObject expectedData = new JSONObject();
        JSONObject dataJson = new JSONObject();

        dataJson.put("id",3);
        dataJson.put("employee_name","Ashton Cox");
        dataJson.put("employee_salary","86000");
        dataJson.put("employee_age","66");
        dataJson.put("profile_image","");

        expectedData.put("status","success");
        expectedData.put("data",dataJson);
        expectedData.put("message","Successfully! Record has been fetched.");

        // 3- request gonder, donen response'i kaydet
        Response response = given().contentType(ContentType.JSON)
                .when()
                .get(url);

        JsonPath responseJsonPath = response.jsonPath();

        // 4- assertions
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(responseJsonPath.get("status"),expectedData.get("status"));
        softAssert.assertEquals(responseJsonPath.get("message"),expectedData.get("message"));
        softAssert.assertEquals(responseJsonPath.get("data.id"),expectedData.getJSONObject("data").get("id"));
        softAssert.assertEquals(responseJsonPath.get("data.employee_name"),expectedData.getJSONObject("data").get("employee_name"));
        softAssert.assertEquals(responseJsonPath.get("data.employee_salary"),expectedData.getJSONObject("data").get("employee_salary"));
        softAssert.assertEquals(responseJsonPath.get("data.employee_age"),expectedData.getJSONObject("data").get("employee_age"));
        softAssert.assertEquals(responseJsonPath.get("profile_image"),expectedData.getJSONObject("data").get("profile_image"));

        softAssert.assertAll();
    }
}
