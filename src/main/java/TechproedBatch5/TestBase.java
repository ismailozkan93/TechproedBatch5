package TechproedBatch5;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.junit.Before;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class TestBase {
    protected RequestSpecification spec01; //cocuklarin  hepsi kullanabilsin diye
    protected RequestSpecification spec02;
    protected RequestSpecification spec03;
    protected JSONObject jsonBookingDatesBody;
    JSONObject jsonRequestrtBody;


    @Before
    public void setUp01() {
        spec01 = new RequestSpecBuilder().
                setBaseUri("https://restful-booker.herokuapp.com").
                build();
        //Uri olusturduk ve spec01 icerisine depoladik.
        // Amacimiz kod tekrarindan kurtulma ve guncellemeleri daha hizli yapabilmek
    }
    @Before
        public void setUp02(){
     spec02=new RequestSpecBuilder().
             setBaseUri("http://dummy.restapiexample.com/api/v1/employees").
             build();
}
    @Before
        public void setUp03(){
            spec03 = new  RequestSpecBuilder().
                    setBaseUri("https://jsonplaceholder.typicode.com/todos").
                    build();
        }

    protected Response createRequestBodyByJsonObjectClass() {
        jsonBookingDatesBody = new JSONObject();

        jsonBookingDatesBody.put("checkin", "2019-02-17");
        jsonBookingDatesBody.put("checkout", "2020-05-05");

        jsonRequestrtBody = new JSONObject();
        jsonRequestrtBody.put("firstname", "susan");
        jsonRequestrtBody.put("lastname", "ericson");
        jsonRequestrtBody.put("totalprice", "123");
        jsonRequestrtBody.put("depositpaid", "true");
        jsonRequestrtBody.put("bookingdates", jsonBookingDatesBody);
        jsonRequestrtBody.put("additionalneeds", "Wifi");


        Response response = given().contentType(ContentType.JSON).spec(spec01).
                auth().basic("admin", "password123").
                body(jsonRequestrtBody).//Jsonobject class in body methodu string kabul ettigi icin bu kismi stringe cevrilir
                when().
                post("/booking");
        response.prettyPrint();

        return response;
    }
    protected Response createrequestBodyByMap(){

        Map bookingDatesMap = new HashMap<>();
        bookingDatesMap.put("checkin", "2019-02-17");
        bookingDatesMap.put("checkout", "2020-05-05");

        Map requestBodyMap = new HashMap<>();
        requestBodyMap.put("firstname", "susan");
        requestBodyMap.put("lastname", "ericson");
        requestBodyMap.put("totalprice", 123);
        requestBodyMap.put("depositpaid", true);
        requestBodyMap.put("bookingdates", bookingDatesMap);
        requestBodyMap.put("additionalneeds", "Wifi");

        Response response = given().contentType(ContentType.JSON).
                spec(spec01).auth().
                basic("admin", "password").
                body(requestBodyMap).
                when().post("/booking");

        return response;
    }

    protected Response createRequestBodyByMap(){
        Map bookingDatesMap = new HashMap<>();
        bookingDatesMap.put("checkin", "2019-02-17");
        bookingDatesMap.put("checkout", "2020-05-05");

        Map requestBodyMap = new HashMap<>();
        requestBodyMap.put("firstname", "susan");
        requestBodyMap.put("lastname", "ericson");
        requestBodyMap.put("totalprice", 123);
        requestBodyMap.put("depositpaid", true);
        requestBodyMap.put("bookingdates", bookingDatesMap);
        requestBodyMap.put("additionalneeds", "Wifi");

        Response response = given().contentType(ContentType.JSON).
                spec(spec01).auth().
                basic("admin", "password").
                body(requestBodyMap).
                when().post("/booking");

                return response;
    }

}
