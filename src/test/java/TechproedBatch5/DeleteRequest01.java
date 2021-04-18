package TechproedBatch5;

import io.restassured.response.Response;
import org.junit.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertTrue;

public class DeleteRequest01 extends TestBase{

    //delete icin endpoint gerekli
    @Test
    public void DeleteRequest(){
        Response responseGet=given().spec(spec03).when().get("/198");

        responseGet.prettyPrint();

        Response responseDel=given().spec(spec03).when().delete("/198");

        responseDel.prettyPrint();

        //responseDel yazdirildiginda "Not Found" cavabi gelirse status code 404 ile test edilir.
        //bos bir satir dönerse status code 200 ile test edilir.

        responseDel.then().statusCode(200);

        //Hard Assert
        assertTrue(responseDel.getBody().asString().contains(" "));

        //Soft Assert
        SoftAssert softAssert=new SoftAssert();
        System.out.println(responseDel.getBody().asString());
        softAssert.assertTrue(responseDel.getBody().asString().contains(" "));//asString jsonValue sunu Stringe cevirir


    }



}
