package Tests;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import pojos.HavaDurumu.*;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class C34_Post_Pojo {

    @Test
    public void test01() {
        // 1-endpoint ve request body
        String url = "https://api.openweathermap.org/data/2.5/weather?q=London&appid=f4ffe3b2ef1fcb3600ab1d7fbc88c2f0";

        // 2-expected data
        Coord coordPojo = new Coord(-0.1257f,51.5085f);
        List<Weather> weatherList = new ArrayList<>();
        Weather weatherPojo = new Weather(804,"Clouds","overcast clouds","04d");
        weatherList.add(weatherPojo);
        Main mainPojo = new Main(278.86f,275.82f,278.1f,279.4f,1029,76,1029,1025);
        Wind windPojo = new Wind(4.12f,70);
        Clouds cloudsPojo = new Clouds(100);
        Sys sysPojo = new Sys(2,2075535,"GB",1766995571,1767023920);

        PojoHavaDurumu expectedResponseBody = new PojoHavaDurumu(
                coordPojo,weatherList,"stations",mainPojo,
                10000,windPojo,cloudsPojo,1767005311,sysPojo,0,2643743,"London",200);

        // 3-request response
        Response response = given()
                .when()
                .post(url);

        JsonPath responseJsonPath = response.jsonPath();

        // 4-assertions
        Assert.assertEquals(expectedResponseBody.getCoord().getLon(),responseJsonPath.get("coord.lon"));
        Assert.assertEquals(expectedResponseBody.getCoord().getLat(),responseJsonPath.get("coord.lat"));
        Assert.assertEquals(expectedResponseBody.getBase(),responseJsonPath.get("base"));
        Assert.assertEquals(expectedResponseBody.getSys().getCountry(),responseJsonPath.get("sys.country"));
        Assert.assertEquals(expectedResponseBody.getName(),responseJsonPath.get("name"));



    }
}
