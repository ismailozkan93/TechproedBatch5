package TechproedBatch5;

import com.google.gson.JsonObject;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.given;


public class PostRequest04 extends TestBase{
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

        * POJO:Plain Old Java Object
          POJO:Json formatindaki data'yi Class lara cevirme islemi denir.
          http://www.jsonschema2pojo.org/ adresine gidilir.
          Data parantezden diger paranteze kopyalanip siteye tasinir.
          sol tarafta class name -->Booking  target-->Java source type--->Json olacak
          daha sonra preview ile class olusturulacak.
          Keylerin hepsine variable olarak tanimlandi.


* */
        @Test
    public void post01(){
       Bookingdates bookingdates=new Bookingdates("2019-02-17","2020-05-05");
       Booking booking=new Booking("susan","ericson",123,true,bookingdates,"Wifi");

       Response response=given().contentType(ContentType.JSON).spec(spec01).auth().
               basic("admin","password123").body(booking).when().post("booking");
               response.prettyPrint();

               response.then().assertThat().statusCode(200);

            JsonPath jsonPath=response.jsonPath();

            SoftAssert softAssert=new SoftAssert();

            softAssert.assertEquals(jsonPath.getString("booking.firstname"), booking.getFirstname());
            softAssert.assertEquals(jsonPath.getString("booking.lastname"), booking.getLastname());
            softAssert.assertEquals(jsonPath.getInt("booking.totalprice"), booking.getTotalprice());
            softAssert.assertEquals(jsonPath.getBoolean("booking.depositpaid"), booking.getDepositpaid());
            softAssert.assertEquals(jsonPath.getString("booking.bookingdates.checkin"), booking.getBookingdates().getCheckin());
            softAssert.assertEquals(jsonPath.getString("booking.bookingdates.checkout"), booking.getBookingdates().getCheckout());
            softAssert.assertEquals(jsonPath.getString("booking.additionalneeds"),booking.getAddionalneeds());
            softAssert.assertAll();





        }



}
