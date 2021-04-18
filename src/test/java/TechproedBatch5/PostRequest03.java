package TechproedBatch5;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import org.testng.asserts.SoftAssert;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class PostRequest03 extends TestBase {

        /*
    *Post Scenario
    Content Type Json olsun
    When
    POST request yolladigimda
             1)https://restful-booker.herokuapp.com/booking
            2)Request body
                "firstname": "susan",
                        "lastname ": "ericson",
                        "totalprice": "123",
                        "depositpaid": "true",
                        "bookingdates": {
                         "checkin": "2019-02-17"
                         "checkout":"2020-05-05"
                         },
                           "addionalneeds":"Wifi"
                            }
                        Then
                        Status Code 200 olmali
                        Response Body,Request Body ile ayni oldugunu verify ediniz.

* */

    @Test
    public void post01() {
        // "checkin": "2019-02-17"
        //"checkout":"2020-05-05"

        Map bookingDatesMap = new HashMap<>();
        bookingDatesMap.put("checkin", "2019-02-17");
        bookingDatesMap.put("checkout", "2020-05-05");

        Map requestBodyMap = new HashMap<>();
        requestBodyMap.put("firstname", "susan");
        requestBodyMap.put("lastname", "ericson");
        requestBodyMap.put("totalprice", 123);
        requestBodyMap.put("depositpaid", true);
        requestBodyMap.put("bookingdates", bookingDatesMap);
        requestBodyMap.put("additionalneeds", "Wifi");

        Response response = given().contentType(ContentType.JSON).
                spec(spec01).auth().
                basic("admin", "password").
                body(requestBodyMap).
                when().post("/booking");

        response.prettyPrint();

        //status code 200 olmali
        response.then().
                assertThat().
                statusCode(200);//hard assertion

        //jsonPath kullanarak assertion

        JsonPath jsonPath = response.jsonPath();

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(jsonPath.getString("booking.firstname"), "susan");
        softAssert.assertEquals(jsonPath.getString("booking.lastname"), "ericson");
        softAssert.assertEquals(jsonPath.getInt("booking.totalprice"), 123);
        softAssert.assertEquals(jsonPath.getBoolean("booking.depositpaid"), true);
        softAssert.assertEquals(jsonPath.getString("booking.bookingdates.checkin"), "2019-02-17");
        softAssert.assertEquals(jsonPath.getString("booking.bookingdates.checkout"), "2020-05-05");

        softAssert.assertAll();

    }


}












