package Tests;

import baseUrl.BaseUrlDummyExample;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import pojos.Dummy.PojoDummyDataResponse;
import pojos.Dummy.PojoDummyResponseBody;

import static io.restassured.RestAssured.given;

public class C33_Get_Pojo extends BaseUrlDummyExample {

    @Test
    public void test01() {
        // 1-endpoint ve request body
        specDummyExample.pathParams("pp1","employee","pp2", "3");

        // 2-expected data
        PojoDummyDataResponse expectedDataBilgileri = new PojoDummyDataResponse(3,"Ashton Cox",
                "86000","66","");

        PojoDummyResponseBody expectedDataPojo = new PojoDummyResponseBody("success",
                "Successfully! Record has been fetched.",expectedDataBilgileri);

        // 3-request ve response
        Response response = given().spec(specDummyExample)
                .when()
                .get("/{pp1}/{pp2}");
        PojoDummyResponseBody responsePojo = response.as(PojoDummyResponseBody.class);
        System.out.println(responsePojo);

        // 4-assert
        Assert.assertEquals(expectedDataPojo.getStatus(),responsePojo.getStatus());
        Assert.assertEquals(expectedDataPojo.getData().getId(),responsePojo.getData().getId());
        Assert.assertEquals(expectedDataPojo.getData().getEmployee_name(),responsePojo.getData().getEmployee_name());
        Assert.assertEquals(expectedDataPojo.getData().getEmployee_salary(),responsePojo.getData().getEmployee_salary());
        Assert.assertEquals(expectedDataPojo.getData().getEmployee_age(),responsePojo.getData().getEmployee_age());
        Assert.assertEquals(expectedDataPojo.getData().getProfile_image(),responsePojo.getData().getProfile_image());
        Assert.assertEquals(expectedDataPojo.getMessage(),responsePojo.getMessage());

    }
}
