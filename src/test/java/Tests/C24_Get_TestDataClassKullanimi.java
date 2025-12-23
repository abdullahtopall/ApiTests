package Tests;

import TestDatalari.TestDataJsonPlaceholder;
import baseUrl.BaseUrlJsonPlaceholder;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C24_Get_TestDataClassKullanimi extends BaseUrlJsonPlaceholder {

    @Test
    public void test01() {

        // 1-endpoint ve request body olustur
        specJsonPlaceholder.pathParams("pp1","posts","pp2",40);

        // 2-expected data
        JSONObject expectedData = TestDataJsonPlaceholder.JsonBodyOlustur(4,40,"enim quo cumque","ut voluptatum aliquid illo tenetur nemo sequi quo facilis\n" +
                "ipsum rem optio mollitia quas\n" +
                "voluptatem eum voluptas qui\n" +
                "unde omnis voluptatem iure quasi maxime voluptas nam");

        // 3-request gonder, donen response'i kaydet
        Response response = given().spec(specJsonPlaceholder)
                .when()
                .get("/{pp1}/{pp2}");
        JsonPath responseJsonPath = response.jsonPath();

        // 4-assertions
        Assert.assertEquals(TestDataJsonPlaceholder.basariliSorguStatusCode,response.getStatusCode());
        Assert.assertEquals(expectedData.getInt("userId"),responseJsonPath.getInt("userId"));
        Assert.assertEquals(expectedData.getInt("id"),responseJsonPath.getInt("id"));
        Assert.assertEquals(expectedData.getString("title"),responseJsonPath.getString("title"));
        Assert.assertEquals(expectedData.getString("body"),responseJsonPath.getString("body"));

    }
}
