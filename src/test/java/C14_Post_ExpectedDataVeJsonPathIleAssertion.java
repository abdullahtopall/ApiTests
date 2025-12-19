import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C14_Post_ExpectedDataVeJsonPathIleAssertion {

    @Test
    public void test01() {

        // 1-endpoint ve request body hazirla
        String url = "https://restful-booker.herokuapp.com/booking";

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
        JSONObject expectedData = new JSONObject();

        expectedData.put("bookingid",24);
        expectedData.put("booking",requestBody);


        // 3-request gonder, response'u kaydet
        Response response = given().contentType(ContentType.JSON)
                .when().body(requestBody.toString())
                .post(url);

        JsonPath responseJsonPath = response.jsonPath();

        // 4-assertion

        assertEquals(expectedData.getJSONObject("booking").get("firstname"), responseJsonPath.get("booking.firstname"));
        assertEquals(expectedData.getJSONObject("booking").get("lastname"), responseJsonPath.get("booking.lastname"));
        assertEquals(expectedData.getJSONObject("booking").get("totalprice"), responseJsonPath.get("booking.totalprice"));
        assertEquals(expectedData.getJSONObject("booking").get("depositpaid"), responseJsonPath.get("booking.depositpaid"));
        assertEquals(expectedData.getJSONObject("booking").getJSONObject("bookingdates").get("checkin"),responseJsonPath.get("booking.bookingdates.checkin"));
        assertEquals(expectedData.getJSONObject("booking").getJSONObject("bookingdates").get("checkout"),responseJsonPath.get("booking.bookingdates.checkout"));
        assertEquals(expectedData.getJSONObject("booking").get("additionalneeds"), responseJsonPath.get("booking.additionalneeds"));


    }
}
