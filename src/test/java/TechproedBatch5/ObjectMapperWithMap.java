package TechproedBatch5;

import Utilities.JsonUtil;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class ObjectMapperWithMap extends TestBase {

    //Java ile olusturdugumuz objeyi JsonUtil icinde olusturdugumuz converter methodu ile json a cevirecegiz.

    @Test
    public void javaToJson(){
        HashMap<Integer,String> map = new HashMap<>();

        map.put(101,"Ali");
        map.put(102,"Veli");
        map.put(103,"Can");
        System.out.println(map);//{101=Ali, 102=Veli, 103=Can}

        //Map Objesini Json Formatina cevirme ==>Seriliziation.

    JsonUtil jsonUtil=new JsonUtil();
        System.out.println(jsonUtil.convertJavaToJson(map));

    }

    //API'dan get methodu ile gelen JSON formatindaki datayi map'e cevirecegiz ve verification yapacagiz.

    @Test
    public void jsonToJava(){
        Response response=given().spec(spec01).
                when().get("booking/3");
                response.prettyPrint();

          //Object Mapper class ile bu json dat'yi Java map formatina cevirelim.
        JsonUtil jsonUtil=new JsonUtil();
        Map<String,Object>jsonToMapApi = jsonUtil.convertJsontoJava(response.asString(), Map.class);
        System.out.println(jsonToMapApi);
     //1)API dan gelen Json formatini map e cevirdik.
     //2)Test Case'den gelen datalari map ile Object yapicaz.
     //3)Olusan bu 2 Map objeyi verification yapacagiz.

      //2.Adim
      Map <String, Object> jsonToMapTestCase = new HashMap<>();

      jsonToMapTestCase.put("firstname","Susan");
      jsonToMapTestCase.put("lastname","Wilson");
      jsonToMapTestCase.put("totalprice",217);
      jsonToMapTestCase.put("depositpaid",true);
      jsonToMapTestCase.put("additionalneeds","Breakfast");

      response.then().assertThat().statusCode(200);
      assertEquals(jsonToMapTestCase.get("firstname"),jsonToMapApi.get("firstname"));
      assertEquals(jsonToMapTestCase.get("lastname"),jsonToMapApi.get("lastname"));
      assertEquals(jsonToMapTestCase.get("totalprice"),jsonToMapApi.get("totalprice"));
      assertEquals(jsonToMapTestCase.get("depositpaid"),jsonToMapApi.get("depositpaid"));
      //assertEquals(jsonToMapTestCase.get("additionalneeds"),jsonToMapApi.get("additionalneeds"));

        //Mapler tek boyutlu (Nested Json Olmayan) Jsonlar icin kolay bir yöntemdir.


    }



}
