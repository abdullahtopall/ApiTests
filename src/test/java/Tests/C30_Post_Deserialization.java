package Tests;

import TestDatalari.TestDataHerokuapp;
import baseUrl.BaseUrlHerokuapp;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C30_Post_Deserialization extends BaseUrlHerokuapp {

    @Test
    public void test01() {

        // 1-endpoint ve request body
        specHerokuapp.pathParam("pp1","booking");
        Map<String,Object> requestBody = TestDataHerokuapp.mapRequestBodyOlustur();

        // 2-expected data
        Map<String,Object> expectedData = TestDataHerokuapp.mapExpectedDataOlustur();

        // 3-request gonder donen response kaydet
        Response response = given().spec(specHerokuapp).contentType(ContentType.JSON)
                .when().body(requestBody)
                .post("/{pp1}");
        Map<String,Object> responseMap = response.as(HashMap.class);

        // 4-assertions
        assertEquals( ((Map)expectedData.get("booking")).get("firstname"), ((Map)responseMap.get("booking")).get("firstname") );
        assertEquals( ((Map)expectedData.get("booking")).get("lastname"), ((Map)responseMap.get("booking")).get("lastname") );
        assertEquals( ((Map)expectedData.get("booking")).get("totalprice"), ((Map)responseMap.get("booking")).get("totalprice") );
        assertEquals( ((Map)expectedData.get("booking")).get("depositpaid"), ((Map)responseMap.get("booking")).get("depositpaid") );
        assertEquals(  ((Map)((Map)expectedData.get("booking")).get("bookingdates")).get("checkin"), ((Map)((Map)responseMap.get("booking")).get("bookingdates")).get("checkin") );
        assertEquals(  ((Map)((Map)expectedData.get("booking")).get("bookingdates")).get("checkout"), ((Map)((Map)responseMap.get("booking")).get("bookingdates")).get("checkout") );
        assertEquals( ((Map)expectedData.get("booking")).get("additionalneeds"), ((Map)responseMap.get("booking")).get("additionalneeds") );


    }
}
