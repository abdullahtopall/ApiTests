package Tests;

import TestDatalari.TestDataJsonPlaceholder;
import baseUrl.BaseUrlJsonPlaceholder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class C28_Put_DeSerialization extends BaseUrlJsonPlaceholder {

    @Test
    public void test01() {
        // 1-endpoint ve request body
        specJsonPlaceholder.pathParams("pp1","posts","pp2",70);
        Map<String,Object> requestBodyMap = TestDataJsonPlaceholder.bodyOlusturMap();

        // 2-expected data
        Map<String,Object> expectedData = TestDataJsonPlaceholder.bodyOlusturMap();

        // 3-request gonder donen response kaydet
        Response response = given().spec(specJsonPlaceholder).contentType(ContentType.JSON)
                .when().body(requestBodyMap)
                .put("/{pp1}/{pp2}");

        // 4-assertion
        // assertion yapabilmemiz icin response'i Map'e cevirmemiz gerekir(de-serialization)

        Map<String,Object> responseMap = response.as(HashMap.class);
        // expectedData (Map) <==> responseMap(Map)

        Assert.assertEquals(expectedData.get("title"),responseMap.get("title"));
        Assert.assertEquals(expectedData.get("body"),responseMap.get("body"));
        Assert.assertEquals(expectedData.get("userId"),responseMap.get("userId"));
        Assert.assertEquals(expectedData.get("id"),responseMap.get("id"));

    }

}
