package TechproedBatch5;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.*;

public class GetRequest02 {
/*Positive Senaryo
when()Bir Get Request assagida verilen Endpoint e yollanir.
"https://restful-booker.herokuapp.com/booking"
And()(Kabul edilcek)Accept Type i "application/json" dir.
then()status code 200dur
and()content type="application/json"dir.
 */

@Test
    public void get01() {
    given().
            accept("application/json").
            when().
            get("https://restful-booker.herokuapp.com/booking").
            then().
            assertThat().statusCode(200).contentType("application/json");
}

 //Negative Senaryo
    //when()Bir Get Request assagida verilen Endpoint e yollanir.
    //"https://restful-booker.herokuapp.com/booking/1001"
    //And()(Kabul edilcek)Accept Type i "application/json" dir.
    //then()status code 404dur


@Test
    public void get02(){
           Response response= given().
            accept("application/json").
            when().
            get("https://restful-booker.herokuapp.com/booking/1001");

           response.prettyPrint();


           response.then().assertThat().statusCode(404);
           //contentType("application/json");//Negative senaryolarda content type olmaz.
            //contetn type("text/plain: charset=utf-8")
}

//Negativ Scenario:
// when() Bir Get Request asagida verilen Endpoint'e yollanir
 //"https://restful-booker.herokuapp.com/booking/1001"
 //then()status code 404 dur
 //And()Response Body de "Not Found" var
 //And() Response Body de "TechProed" yok

  @Test
  public void get03(){
    Response response=given().when().get("https://restful-booker.herokuapp.com/booking/1001");
    response.prettyPrint();

    assertTrue(response.asString().contains("Not Found"));
    assertFalse(response.asString().contains("Techproed"));
   // assertEquals("404",response.getStatusCode());


  }










}
