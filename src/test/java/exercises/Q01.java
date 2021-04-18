package exercises;

import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

public class Q01 {
    @Test
    public void get01(){
        Response response=given().
                accept("application/json").
                when().
                get("https://restful-booker.herokuapp.com/booking/2");

        response.prettyPrint();

        response.
                then().
                assertThat().
                contentType("application/JSON").
                body("firstname", Matchers.equalTo("Susan"),
                        "lastname",Matchers.equalTo("Jones"),
                        "bookingdates.checkin",Matchers.equalTo("2020-08-10"),
                        "bookingdates.checkout",Matchers.equalTo("2020-08-17"));



    }






}
