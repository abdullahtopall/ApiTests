package TestDatalari;

import org.json.JSONObject;

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
}
