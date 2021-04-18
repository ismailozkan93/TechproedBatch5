package TechproedBatch5;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import netscape.javascript.JSObject;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class PatchRequest01 extends TestBase{

    @Test
    public void patch01(){
        Response responseBeforePatch=given().spec(spec03).
                when().get("/200");

        responseBeforePatch.prettyPrint();

        JSONObject jsonObject=new JSONObject();
        jsonObject.put("title","Hasan");

        Response responseAfterPatch=given().contentType(ContentType.JSON).
                spec(spec03).body(jsonObject.toString()).when().patch("/200");//body her zaman toString kabul eder.
                responseAfterPatch.prettyPrint();

        JsonPath jsonPath=responseAfterPatch.jsonPath();

        //title hard assertion
        System.out.println(jsonObject.getString("title"));
        System.out.println(jsonPath.get("title"));
        assertEquals(jsonObject.getString("title"),jsonPath.get("title"));



    }





}
