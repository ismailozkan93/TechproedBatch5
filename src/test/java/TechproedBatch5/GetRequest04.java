package TechproedBatch5;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;
import static io.restassured.RestAssured.given;

public class GetRequest04 {

@Test
    public void get01(){

    Response response = given().
    accept("application/json").
            when().
            get("http://dunny.restapi.example.com/api/v1/employees");
            response.prettyPrint();
            response.
                    then().
                    assertThat().
                    statusCode(200).contentType(ContentType.JSON).
            body("data.id", Matchers.hasSize(24)).//body den bütün data idlerini al ve mathers.hasSize ile kiyasla
            body("data.employee_name",Matchers.hasItem("Asthon Cox")).
           //bütün isimlerin bir list icersinde alinir ve icersinden arana deger bakilir
                    body("data.employee.age",Matchers.hasItems("21","61","23"));




}











}
