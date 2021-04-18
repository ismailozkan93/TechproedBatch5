package TechproedBatch5;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import org.testng.asserts.SoftAssert;
import io.restassured.path.json.exception.JsonPathException;
import static io.restassured.RestAssured.*;
public class PostRequest01 extends TestBase{
    /*
        Get Request olusturmak icin sadece endpoint gerekiyordu
        Post Request olusturmak icin gerekenler
        #1)Endpoint sart
        #2)Request Body yani kaydedilcek olan data
        3)Autorization sart(eger verilmemisse)
        4)Accept type istege bagli
        5)Content Type (icerik tipi)

        Interview sorusu:get ile post request arasindaki farklar nelerdir?
                        get endpoint gereklidir,autorization her test icin zorunlu olmayabilir.
                        *post request icin endpoint ve body(data) gereklidir.
                        get var olan datalari görmek icin kullanilir
                        Post ise olmayan datayi olusturmak icin kullanilir

       NOTE: SQL'de doldurulmasi zorunlu alanlar vardir.Not null, primary key,foregin key vb constrains denir.
            API developer olusturulacak datanin hangi bölümlerini zorunlu kildi ise o kisimlar bos gecilmez
             Post request olusturulurken bu kisimlar kesinlikle doldurulmali.
             Sweger dokumantasyonunda bu kisimlar acikca yazilir
             Eger bos gecilirse "400 Bad Request" hatasi aliriz

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

    */

            @Test
            public void post01(){
               //1.yol iyi ancak tavsiye edilmez
                String jsonReqBody = "{\n"+
                        "\"firstname\": \"susan\",\n" +
                        "                \"lastname \": \"ericson\",\n" +
                        "                \"totalprice\": \"123\",\n" +
                        "                \"depositpaid\": \"true\",\n" +
                        "                \"bookingdates\": {\n" +
                        "                \"checkin\": \"2019-02-17\"\n" +
                        "                \"checkout\":\"2020-05-05\"\n" +
                        "                },\n" +
                        "                \"addionalneeds\":\"Wifi\"\n" +
                        "                }";

                Response response=given().contentType(ContentType.JSON).spec(spec01).
                        auth().basic("admin","password123").
                        body(jsonReqBody).when().
                        post("/booking");
                response.prettyPrint();
                //status code 200 olmali
                response.then().
                        assertThat().
                        statusCode(400);//hard assertion

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
