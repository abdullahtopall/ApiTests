import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C13_Get_ExpectedDataOlusturma {

    @Test
    public void test01() {
        // 1-endpoint ve request body hazirla
        String url = "https://jsonplaceholder.typicode.com/posts/22";

        // 2- expected data olustur
        JSONObject expectedData = new JSONObject();
        expectedData.put("userId",3);
        expectedData.put("id",22);
        expectedData.put("title","dolor sint quo a velit explicabo quia nam");
        expectedData.put("body","eos qui et ipsum ipsam suscipit aut\n" +
                "sed omnis non odio\n" +
                "expedita earum mollitia molestiae aut atque rem suscipit\n" +
                "nam impedit esse");

        // 3-request gonder, donen response'i kaydet
        Response response = given()
                            .when()
                            .get(url);
        // 4-assertions

        /*
        response
                .then()
                .assertThat()
                .body("userId", Matchers.equalTo(3),
                        "id",Matchers.equalTo(22),
                        "title",Matchers.equalTo("dolor sint quo a velit explicabo quia nam")
                        );
        */

        JsonPath responseJsonPath = response.jsonPath();

        Assert.assertEquals(expectedData.get("id"),responseJsonPath.get("id"));
        Assert.assertEquals(expectedData.get("userId"),responseJsonPath.get("userId"));
        Assert.assertEquals(expectedData.get("title"),responseJsonPath.get("title"));
        Assert.assertEquals(expectedData.get("body"),responseJsonPath.get("body"));


    }
}
