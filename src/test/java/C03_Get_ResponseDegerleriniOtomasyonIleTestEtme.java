import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C03_Get_ResponseDegerleriniOtomasyonIleTestEtme {
    @Test
    public void test02() {
        // 1-end point ve request body olustur
        String url = "https://restful-booker.herokuapp.com/booking/10";

        // 2- expected body olustur

        // 3- request gonderip, donen response'i kaydet
        Response response = given().when().get(url);

        // 4- assertion
        response
                .then()
                .assertThat()
                .statusCode(200)
                .contentType("application/json; charset=utf-8")
                .header("Server","Heroku")
                .statusLine("HTTP/1.1 200 OK");
    }
}
