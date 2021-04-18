package TechproedBatch5;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import netscape.javascript.JSObject;
import org.json.JSONObject;
import org.junit.Test;
import org.testng.asserts.SoftAssert;
import io.restassured.path.json.exception.JsonPathException;
import static io.restassured.RestAssured.*;
public class PostRequest02 extends TestBase {
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

                       JSON formatlar icin bir obje olusturunuz ve objeleri body olarak kullaniniz
* */

    @Test
    public void post01(){
/*
 "bookingdates": {
                         "checkin": "2019-02-17"
                         "checkout":"2020-05-05"
                         },
 */
        JSONObject jsonBookingDatesBody=new JSONObject();

        jsonBookingDatesBody.put("checkin","2019-02-17");
        jsonBookingDatesBody.put("checkout","2020-05-05");

        JSONObject jsonRequestrtBody = new JSONObject();
        jsonRequestrtBody.put("firstname","susan");
        jsonRequestrtBody.put("lastname","ericson");
        jsonRequestrtBody.put("totalprice","123");
        jsonRequestrtBody.put("depositpaid","true");
        jsonRequestrtBody.put("bookingdates",jsonBookingDatesBody);
        jsonRequestrtBody.put("additionalneeds","Wifi");



        Response response=given().contentType(ContentType.JSON).spec(spec01).
                auth().basic("admin","password123").
                body(jsonRequestrtBody.toString()).//Jsonobject class in body methodu string kabul ettigi icin bu kismi stringe cevrilir
                when().
                post("/booking");
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
        softAssert.assertEquals(jsonPath.getInt("booking.totalprice"),"123");
        softAssert.assertEquals(jsonPath.getBoolean("booking.depositpaid"),"true");
        softAssert.assertEquals(jsonPath.getString("booking.bookingdates.checkin"),"2019-02-17");
        softAssert.assertEquals(jsonPath.getString("booking.bookingdates.checkout"),"2020-05-05");

        softAssert.assertAll();

    }
    }














