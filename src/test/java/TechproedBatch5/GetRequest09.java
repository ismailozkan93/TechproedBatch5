package TechproedBatch5;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class GetRequest09 extends TestBase{

    @Test
            public void get01(){
    Response response=given().spec(spec02).
            when().
            get();
    response.prettyPrint();
//json path objesini olusturunuz.

        JsonPath jsonPath=response.jsonPath();

//tüm employee isimlerini console yazdirin

        System.out.println(jsonPath.getString("data.employee_name"));
        System.out.println(jsonPath.getList("data.employee_name"));
    //2.iscinin Garrett Winters oldugunu 'verify' ediniz

        assertEquals("isim istedigi gibi degil","Garrett Winters",
                jsonPath.getString("data[1].employee_name"));//bu method hard assertion

        //*Soft Assertion icin 3 adimi takip edilir
        //1)SoftAssert class'indan bir obje(Softassert) verilir
        //2)Objeyi kullanarak assertion yapilir
        //3)SoftAssert.assertAll ile test bitirilir.


        SoftAssert softAssert=new SoftAssert();
        softAssert.assertEquals(jsonPath.getString("data[1].employee_name"),"Garrett Winters",
                "isim istediginiz gibi degil");
        softAssert.assertAll();

        //Assertion hard test
        //verification "verify" soft test

        //isciler arasinda "Hernod Chandler" isminin varoldugunu 'verify' ediniz

        softAssert.assertTrue(jsonPath.getList("data.employee_name").contains("Herrod Chandler"),
                "Herrod Chandler isminde isci yoktur");

        //24 tane isci oldugunu "verify" ediniz
        softAssert.assertEquals(jsonPath.getList("data.id").size(),24,"isci sayisi 24 degildir");

        //7nci iscinin maasinin "137500" oldugunu verify ediniz

        softAssert.assertEquals(jsonPath.getString("data[6].employee_salary"),
                "137500","istenildigi gibi degil");





        softAssert.assertAll();
















}
}
