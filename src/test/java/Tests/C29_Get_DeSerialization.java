package Tests;

import TestDatalari.TestDataDummyExample;
import baseUrl.BaseUrlDummyExample;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class C29_Get_DeSerialization extends BaseUrlDummyExample {

    @Test
    public void test01() {
        // 1-endpoint ve request body olustur
        specDummyExample.pathParams("pp1","employee","pp2","3");

        // 2-expected data
        Map<String,Object> expectedData = TestDataDummyExample.mapBodyOlustur();

        // 3-request gonder donen response'i kaydet
        Response response = given().spec(specDummyExample)
                .when()
                .get("/{pp1}/{pp2}");

        Map<String,Object> responseMap = response.as(HashMap.class);

        // 4-assertions
        Assert.assertEquals(TestDataDummyExample.basariliSorguStatusCode,response.statusCode());
        Assert.assertEquals(TestDataDummyExample.contentType,response.contentType());
        Assert.assertEquals(expectedData.get("message"),responseMap.get("message"));
        Assert.assertEquals(expectedData.get("status"),responseMap.get("status"));

        Assert.assertEquals( ((Map)expectedData.get("data")).get("profile_image"), ((Map)responseMap.get("data")).get("profile_image") );
        Assert.assertEquals( ((Map)expectedData.get("data")).get("employee_age"), ((Map)responseMap.get("data")).get("employee_age") );
        Assert.assertEquals( ((Map)expectedData.get("data")).get("employee_salary"), ((Map)responseMap.get("data")).get("employee_salary") );
        Assert.assertEquals( ((Map)expectedData.get("data")).get("employee_name"), ((Map)responseMap.get("data")).get("employee_name") );
        Assert.assertEquals( ((Map)expectedData.get("data")).get("id"), ((Map)responseMap.get("data")).get("id") );


    }
}
