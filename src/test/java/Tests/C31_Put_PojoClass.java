package Tests;

import TestDatalari.TestDataJsonPlaceholder;
import baseUrl.BaseUrlJsonPlaceholder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import pojos.JsonPlaceholder.PojoJsonPlaceholder;

import static io.restassured.RestAssured.given;

public class C31_Put_PojoClass extends BaseUrlJsonPlaceholder {


    @Test
    public void test01() {

        // 1-endpoint ve request body olustur
        specJsonPlaceholder.pathParams("pp1","posts","pp2","70");
        PojoJsonPlaceholder requestBodyPojo = new PojoJsonPlaceholder("Ahmet","Merhaba",10,70);

        // 2-expected data
        PojoJsonPlaceholder expectedDataPojo = new PojoJsonPlaceholder("Ahmet","Merhaba",10,70);

        // 3-request gonder response kaydet
        Response response = given().spec(specJsonPlaceholder).contentType(ContentType.JSON)
                .when().body(requestBodyPojo)
                .put("/{pp1}/{pp2}");

        PojoJsonPlaceholder responsePojo = response.as(PojoJsonPlaceholder.class);

        // 4-assertions
        Assert.assertEquals(TestDataJsonPlaceholder.basariliSorguStatusCode,response.statusCode());
        Assert.assertEquals(TestDataJsonPlaceholder.contentType,response.contentType());
        Assert.assertEquals(TestDataJsonPlaceholder.headerConnection,response.header("Connection"));
        Assert.assertEquals(expectedDataPojo.getTitle(),responsePojo.getTitle());
        Assert.assertEquals(expectedDataPojo.getBody(),responsePojo.getBody());
        Assert.assertEquals(expectedDataPojo.getUserId(),responsePojo.getUserId());
        Assert.assertEquals(expectedDataPojo.getId(),responsePojo.getId());

    }
}
