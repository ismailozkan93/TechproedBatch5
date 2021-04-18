package TechproedBatch5;

import Utilities.JsonUtil;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class ObjectMapperWithPojo extends TestBase{
//Java Objesini Json formatina Pojo ile cevirecegiz.

    JsonUtil jsonUtil=new JsonUtil();
    @Test
    public void JavaToJson(){
        Bookingdates bookingdates=new Bookingdates("2020-10-20","2020-10-25");
        System.out.println(bookingdates);

        System.out.println(jsonUtil.convertJavaToJson(bookingdates));

    }

    @Test
            public void jsonToJava() {
        Response response = given().
                spec(spec01).
                when().
                get("booking/3");
            response.prettyPrint();

        //json datayi POJO class ile java formatina cevirecegiz.
        Booking jsonToPojoApi=jsonUtil.convertJsontoJava(response.asString(),Booking.class);

        System.out.println(jsonToPojoApi);

        Bookingdates bookingdates=new Bookingdates("2016-08-07","2019-12-12");
        Booking booking=new Booking("Mary","Smith",973,true,bookingdates,"");

        response.then().assertThat().statusCode(200);
        assertEquals(booking.getBookingdates().getCheckin(),jsonToPojoApi.getBookingdates().getCheckin());
                                //TestCaseden gelen tarih                   //veritabanindan gelen tarih
        assertEquals(booking.getBookingdates().getCheckout(),jsonToPojoApi.getBookingdates().getCheckout());



    }
}
