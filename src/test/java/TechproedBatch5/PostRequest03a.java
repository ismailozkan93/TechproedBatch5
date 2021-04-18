package TechproedBatch5;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.given;

public class PostRequest03a extends TestBase {
    @Test
    public void post01(){

        Response response=createRequestBodyByMap();

        response.prettyPrint();

        //status code 200 olmali
        response.then().
                assertThat().
                statusCode(200);//hard assertion

        //jsonPath kullanarak assertion

        JsonPath jsonPath=response.jsonPath();

        SoftAssert softAssert=new SoftAssert();

        softAssert.assertEquals(jsonPath.getString("booking.firstname"),"susan");
        softAssert.assertEquals(jsonPath.getString("booking.lastname"),"ericson");
        softAssert.assertEquals(jsonPath.getInt("booking.totalprice"),123);
        softAssert.assertEquals(jsonPath.getBoolean("booking.depositpaid"),true);
        softAssert.assertEquals(jsonPath.getString("booking.bookingdates.checkin"),"2019-02-17");
        softAssert.assertEquals(jsonPath.getString("booking.bookingdates.checkout"),"2020-05-05");

        softAssert.assertAll();

    }
}


