package TechproedBatch5;

import io.restassured.response.Response;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static io.restassured.RestAssured.*;

public class GetRequest07 extends TestBase {


    @Test
    public void get01(){
        Response response=given().spec(spec01).when().get("booking?firstname=Eric&depositpaid=true");

        response.prettyPrint();

        assertTrue(response.getBody().asString().contains("bookingid"));

    }
    @Test
    public void get02(){
        spec01.queryParam("firstname","Eric");
        spec01.queryParam("lastname","Brown");

        //spec01.queryParams("firstname","Eric","lastname","Brown");

        Response response =given().spec(spec01).get("/booking");

        response.prettyPrint();

        assertTrue(response.getBody().asString().contains("bookingid"));


    }

}
