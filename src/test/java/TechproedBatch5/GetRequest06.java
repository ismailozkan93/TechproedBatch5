package TechproedBatch5;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class GetRequest06 extends TestBase{

    @Test
    public void get01(){
        Response response=given().
               spec(spec01).when().get("/booking/5");

        response.prettyPrint();

        response.then().assertThat().statusCode(200).contentType(ContentType.JSON).
                body("firstname",Matchers.equalTo("Susan"),
                        "lastname",Matchers.equalTo("Jones"),
                        "totalprice",Matchers.equalTo(372),
                        "depositpaid",Matchers.equalTo("true"),
                        "bookingdates.checkin",Matchers.equalTo("2016-08-27"),
                        "bookingdates.checkout",Matchers.equalTo("2018-07-24"));








    }

}
