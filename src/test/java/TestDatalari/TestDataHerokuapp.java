package TestDatalari;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class TestDataHerokuapp {

    public static JSONObject jsonBodyOlustur(String firstname, String lastname, int totalprice, boolean depositpaid,
                                             String checkin, String checkout, String additionalneeds)
    {
        JSONObject requestBody = new JSONObject();
        JSONObject rezervasyonTarihleri = new JSONObject();

        rezervasyonTarihleri.put("checkin",checkin);
        rezervasyonTarihleri.put("checkout",checkout);

        requestBody.put("firstname",firstname);
        requestBody.put("lastname",lastname);
        requestBody.put("totalprice",totalprice);
        requestBody.put("depositpaid",depositpaid);
        requestBody.put("bookingdates",rezervasyonTarihleri);
        requestBody.put("additionalneeds","wi-fi");

        return requestBody;

    }

    public static JSONObject expectedJsonBodyOlustur(String firstname, String lastname, int totalprice, boolean depositpaid,
                                                     String checkin, String checkout, String additionalneeds)
    {
        JSONObject responseBody = new JSONObject();

        JSONObject bookingBody = jsonBodyOlustur(firstname,lastname,totalprice,depositpaid,checkin,checkout,additionalneeds);
        responseBody.put("bookingid",24);
        responseBody.put("booking",bookingBody);

        return responseBody;
    }

    public static Map<String,Object> mapRequestBodyOlustur() {
        Map<String,Object> requestBody = new HashMap<>();
        Map<String,Object> bookingdates = new HashMap<>();

        bookingdates.put("checkin","2021-06-01");
        bookingdates.put("checkout","2021-06-10");

        requestBody.put("firstname","Ahmet");
        requestBody.put("lastname","Bulut");
        requestBody.put("totalprice",500);
        requestBody.put("depositpaid",false);
        requestBody.put("bookingdates",bookingdates);
        requestBody.put("additionalneeds","wi-fi");

        return  requestBody;

    }

    public static Map<String,Object> mapExpectedDataOlustur() {
        Map<String,Object> expectedData = new HashMap<>();
        expectedData.put("bookingid",24);
        expectedData.put("booking",mapRequestBodyOlustur());
        return expectedData;
    }
}
