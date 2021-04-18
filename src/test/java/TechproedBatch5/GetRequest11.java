package TechproedBatch5;
import com.google.gson.Gson;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import org.testng.asserts.SoftAssert;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.given;
public class GetRequest11 extends TestBase {
        /*
    GSON 1) Json formatindaki datalari Java Object lerine donusturur. (De Serialization)
         2) Java Object lerini Json formatina donusturur. (Serialization)
         json --> GSON ---> Java (maplere yada listlere cevrilis.) // De Serialization
         Java --> GSON -->Json  // Serialization
    */

@Test
    public void Test01(){
    Response response= given().
            spec(spec03).
            when().
            get("/2");
    response.prettyPrint();

    HashMap<String,String>map=response.as(HashMap.class);//De Seriziliation

    System.out.println(map.keySet());//id,completed,title...

    System.out.println(map.values());//1.0,2.0,false......

    //completed degerinin verify ediniz

        SoftAssert softAssert=new SoftAssert();
        softAssert.assertEquals(map.get("completed"),false,"False degerinde degil");

    //userId, title ve id degerlerini verify ediniz.(Hashmap de double alir.)
    softAssert.assertEquals(map.get("userId"),1.0,"1 degerinde degil");
    softAssert.assertEquals(map.get("title"),"quis ut nam facilis et officia qui","quis ut nam facilis et officia qui degil");
    softAssert.assertEquals(map.get("id"),2.0,"2 degerinde degil");


        softAssert.assertAll();
//Map Objesini Json formatina cevirme
    Gson gson =new Gson();
    System.out.println(gson.toJson(map));


















}







}
