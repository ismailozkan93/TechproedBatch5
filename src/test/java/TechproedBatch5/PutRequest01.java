package TechproedBatch5;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class PutRequest01 extends TestBase{
/*
Var olan bodyi komple degistiriyoruz,
put yapmak icin body,content Type ve Endpoint ihtiyacimiz vardir.
authorization istenirse girmeliyiz.
 */

@Test
 public void put01(){
    Response response=given().spec(spec03).when().get("200");
    response.prettyPrint();

    JSONObject jsonObject=new JSONObject();
    jsonObject.put("title","Ali");
    jsonObject.put("userId",201);
    jsonObject.put("completed",true);
                                                                            //Json Object her zaman String olmaz
                                                                            //Body ici String olmasi gerektigi icin
                                                                            //toString()methodu kullanilir.
                                                                           //toString()anlik mesaji gösterir.
    Response responseAfterPut=given().contentType(ContentType.JSON).
            spec(spec03).body(jsonObject.toString()).
            when().put("200");
    responseAfterPut.prettyPrint();

    responseAfterPut.then().assertThat().statusCode(200);

    JsonPath jsonPath=responseAfterPut.jsonPath();








}



}
