package Tests;

import baseUrl.BaseUrlHerokuapp;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import pojos.Herokuapp.PojoHerokuappBookingDates;
import pojos.Herokuapp.PojoHerokuappRequestBody;
import pojos.Herokuapp.PojoHerokuappResponseBody;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;


public class C32_Post_Pojo extends BaseUrlHerokuapp {

    @Test
    public void test01() {
        // 1-endpoint ve request body
        specHerokuapp.pathParam("pp1","booking");
        PojoHerokuappBookingDates bookingDatesPojo = new PojoHerokuappBookingDates("2021-06-01","2021-06-10");
        PojoHerokuappRequestBody requestBodyPojo = new PojoHerokuappRequestBody("Ahmet","Bulut",
                500,false,bookingDatesPojo,"wi-fi");
        /*
        PojoHerokuappRequestBody
            {firstname='Ahmet',
            lastname='Bulut',
            totalPrice=500,
            depositpaid=false,
            bookingdates=PojoHerokuappBookingDates
                {checkin='2021-06-01',
                checkout='2021-06-10'},
            additionalneeds='wi-fi'}

         */
        // 2-expected data
        PojoHerokuappResponseBody expectedDataPojo = new PojoHerokuappResponseBody(24,requestBodyPojo);
        /*
        PojoHerokuappResponseBody
        {bookingId=24,
        booking=PojoHerokuappRequestBody
            {firstname='Ahmet',
            lastname='Bulut',
            totalPrice=500,
            depositpaid=false,
            bookingdates=PojoHerokuappBookingDates
                {checkin='2021-06-01',
                checkout='2021-06-10'},
            additionalneeds='wi-fi'}}

         */

        // 3-request response
        Response response = given().spec(specHerokuapp).contentType(ContentType.JSON)
                .when().body(requestBodyPojo)
                .post("/{pp1}");

        PojoHerokuappResponseBody responsePojo = response.as(PojoHerokuappResponseBody.class);
        System.out.println(responsePojo);

        // 4-assertions
        assertEquals(expectedDataPojo.getBooking().getFirstname(),responsePojo.getBooking().getFirstname());
        assertEquals(expectedDataPojo.getBooking().getLastname(),responsePojo.getBooking().getLastname());
        assertEquals(expectedDataPojo.getBooking().getTotalprice(),responsePojo.getBooking().getTotalprice());
        assertEquals(expectedDataPojo.getBooking().isDepositpaid(),responsePojo.getBooking().isDepositpaid());
        assertEquals(expectedDataPojo.getBooking().getBookingdates().getCheckin(),responsePojo.getBooking().getBookingdates().getCheckin());
        assertEquals(expectedDataPojo.getBooking().getBookingdates().getCheckout(),responsePojo.getBooking().getBookingdates().getCheckout());

    }

}
