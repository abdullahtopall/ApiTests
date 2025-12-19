import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class C09_Get_BodyTekrarlardanKurtulma {

    @Test
    public void test01() {
        // 1-endpoint ve body hazirla
        String url = "https://restful-booker.herokuapp.com/booking/10";

        // 2-expected data olustur

        // 3- request gonder ve donen response'i kaydet
        Response response = given().contentType(ContentType.JSON)
                            .when()
                            .get(url);
        response.prettyPrint();

        // 4-assertions
        response
                .then()
                .assertThat()
                .statusCode(200)
                .body("firstname", equalTo("Mary"),
                        "lastname", equalTo("Wilson"),
                        "totalprice", equalTo(607),
                        "depositpaid", equalTo(false)
                        );

    }
}
