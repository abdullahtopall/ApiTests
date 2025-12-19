import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C02_GetRequest_ResponseBilgilerininManuelTestEdilmesi {

    @Test
    public void test02() {

        // 1-gerekli body ve end point hazirla
        String url = "https://restful-booker.herokuapp.com/booking/10";

        // 2-expected body olustur

        // 3-request gönder ve dönen response'i kaydet
        Response response = given().when().get(url);
        System.out.println("status code: "+response.getStatusCode()+
                "\nContent type: "+response.getContentType()+
                "\nServer Header degeri: "+response.getHeader("Server")+
                "\nStatus line: "+response.getStatusLine()+
                "\nResponse suresi: "+response.getTime());

        // 4- assertions

    }
}
