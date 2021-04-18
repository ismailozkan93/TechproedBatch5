package TechproedBatch5;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import org.testng.asserts.SoftAssert;

import java.util.Collections;
import java.util.List;

import static io.restassured.RestAssured.given;

public class GetRequest10 extends TestBase {

    @Test
    public void Test01(){
        Response response=
                        given().spec(spec02).
                        when().
                        get();
        response.prettyPrint();

        response.then().assertThat().statusCode(200);

        JsonPath jsonPath=response.jsonPath();
        //1)10 dan büyük tüm idleri konsola yazdir
        //2)18 den büyük 14 tane id oldugunu verify et//VERIFY DEYINCE aklimiza softassertion gelir

        SoftAssert softAssert=new SoftAssert();

        List<String> idList = jsonPath.getList("data.findAll{Integer.valueOf(it.id)>10}.id");
        //bütün herseyi al buradaki idleri string den int cevir ve 10 dan büyükleri getir.
        System.out.println(idList);

        List<String> idList2= jsonPath.getList("data.findAll{Integer.valueOf(it.id)>18}.id");
        System.out.println(idList2);
        System.out.println(idList2.size());
        softAssert.assertEquals(idList2.size(), 6,"14 TANE DEGILDIR");

        //30'dan kücük tüm yaslari console'a yazdirin
        List<String> idList3=jsonPath.getList("data.findAll{Integer.valueOf(it.employee_age)<30}.employee_age");
        System.out.println(idList3);

        //30'dan kücük en büyük yasin 23oldugunu verify ediniz

        Collections.sort(idList3);//listsiralama
        System.out.println(idList3);

        softAssert.assertTrue(idList3.get(idList3.size()-1).equals("23"),"yas istenen degerde degildir");

        //Maasi 350.000 den fazla olan iscilerin isimlerini konsola yazdirin.
        List<String> idList4=jsonPath.getList("data.findAll{Integer.valueOf(it.employee_salary)>350000}.employee_name");
        System.out.println(idList4);
        //Charde Marshall in listede oldugunu verify ediniz
        softAssert.assertTrue(idList4.contains("Charde Marshall"));

        softAssert.assertAll();











    }
}
