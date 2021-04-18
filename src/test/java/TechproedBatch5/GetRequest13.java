package TechproedBatch5;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class GetRequest13 extends TestBase {

    @Test
    public void get01(){
        Response response=given().
                spec(spec02).
                when().
                get();
    response.prettyPrint();

    //Ilk 5 ismin "Tiger Nixon","Garrett Winters","Ashton Cox","Cedric Kelly","Airi Satou", OLDUGUNU verify ediniz


        JsonPath jsonPath=response.jsonPath();

        SoftAssert softAssert=new SoftAssert();

    //1.yol istenilmeyen tavsiye ediniz

        softAssert.assertEquals(jsonPath.getString("data[0].employee_name"),"Tiger Nixon");
        softAssert.assertEquals(jsonPath.getString("data[1].employee_name"),"Garrett Winters");
        softAssert.assertEquals(jsonPath.getString("data[2].employee_name"),"Ashton Cox");
        softAssert.assertEquals(jsonPath.getString("data[3].employee_name"),"Cedric Kelly");
        softAssert.assertEquals(jsonPath.getString("data[4].employee_name"),"Airi Satou");

        //2.yol alabilir

        List<String> isimlist= new ArrayList<>();

        isimlist.add("Tiger Nixon");
        isimlist.add("Garrett Winters");
        isimlist.add("Ashton Cox");
        isimlist.add("Cedric Kelly");
        isimlist.add("Airi Satou");

        for(int i=0;i<isimlist.size();i++){
            softAssert.assertEquals(jsonPath.getString("data["+i+"].employee_name"),isimlist.get(i));
        }

        //3,yol

        List<Map> actualList = jsonPath.getList("data");//bütün data alinmis oldu
        System.out.println(actualList);

        Map<Integer,String> expectedMap =new HashMap<>();

        expectedMap.put(0,"Tiger Nixon");
        expectedMap.put(1,"Garrett Winters");
        expectedMap.put(2,"Ashton Cox");
        expectedMap.put(3,"Cedric Kelly");
        expectedMap.put(4,"Airi Satou");

        for (int i=0;i<expectedMap.size();i++){
            softAssert.assertEquals(actualList.get(i).get("employee_name"),expectedMap.get(i));
        }


        softAssert.assertAll();

    }














}
