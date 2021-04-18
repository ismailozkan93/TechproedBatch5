package TechproedBatch5;
import com.google.gson.Gson;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import org.testng.asserts.SoftAssert;

import java.util.*;

import static io.restassured.RestAssured.given;
import org.junit.Test;



import static io.restassured.RestAssured.given;

public class GetRequest12 extends TestBase {
   // GSON 1) Json formatindaki datalari Java Object lerine donusturur. (De Serialization)
     //       2) Java Object lerini Json formatina donusturur. (Serialization)

@Test
    public void get01(){

    Response response = given().
            spec(spec03).
            when().
            get();
    response.prettyPrint();

    List<Map<String,String>> listOfMap=response.as(ArrayList.class);
    System.out.println(listOfMap);
    System.out.println(listOfMap.get(0));

//200 tane id oldugunu verify ediniz
    SoftAssert softAssert=new SoftAssert();
    softAssert.assertTrue(listOfMap.size()==200,"id sayisi uyusmuyor");



//Sondan 1 önceki elemanin title degerinin "numquam repellendus a magnam" verify ediniz
    softAssert.assertEquals(listOfMap.get(listOfMap.size()-2).get("title"),"numquam repellendus a magnam","eslesmiyor");


//121nci elemanin  true oldugunu verify ediniz
    softAssert.assertEquals(listOfMap.get(120).get("completed"),"true","sonuc true degil");






    softAssert.assertAll();

    Gson gson =new Gson();
    System.out.println(gson.toJson(listOfMap));







}
}
