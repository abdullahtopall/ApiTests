package Tests;

import baseUrl.BaseUrlDummyExample;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import pojos.Dummy.PojoDummyExampleData;
import pojos.Dummy.PojoDummyResponseBody;

import static io.restassured.RestAssured.given;

public class C33_Get_Pojo extends BaseUrlDummyExample {

    @Test
    public void test01() {

        // 1-endpoint ve request body
        specDummyExample.pathParams("pp1","employee","pp2",3);

        // 2-expected data
        PojoDummyExampleData dataPojo = new PojoDummyExampleData
                (3,"Ashton Cox","86000","66","");

        PojoDummyResponseBody expectedDataPojo = new PojoDummyResponseBody
                ("success",dataPojo,"Successfully! Record has been fetched.");

        // 3-request response
        Response response = given().spec(specDummyExample)
                .when()
                .get("/{pp1}/{pp2}");

        JsonPath responseJsonPath = response.jsonPath();

        // 4-assertion
        Assert.assertEquals(expectedDataPojo.getStatus(),responseJsonPath.get("status"));
        Assert.assertEquals(expectedDataPojo.getData().getId(),responseJsonPath.get("data.id"));
        Assert.assertEquals(expectedDataPojo.getData().getEmployeeName(),responseJsonPath.get("data.employee_name"));
        Assert.assertEquals(expectedDataPojo.getData().getEmployeeSalary(),responseJsonPath.get("data.employee_salary"));
        Assert.assertEquals(expectedDataPojo.getData().getEmployeeAge(),responseJsonPath.get("data.employee_age"));
        Assert.assertEquals(expectedDataPojo.getData().getProfileImage(),responseJsonPath.getString("data.profile_image"));
        Assert.assertEquals(expectedDataPojo.getMessage(),responseJsonPath.get("message"));
    }
}
