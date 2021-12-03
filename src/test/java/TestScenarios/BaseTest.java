package TestScenarios;

import RestAssuredHelpers.RestAssuredUtilMethods;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class BaseTest {


    //RestAssured.baseURI = "";

    String url = "https://jsonplaceholder.typicode.com";

    public static RequestSpecification requestSpec ;

    public static RestAssured restAssured ;

   public static RestAssuredUtilMethods assuredUtilMethods = new RestAssuredUtilMethods();

    @BeforeTest
    public void setBaseTestSettings(){

        requestSpec = new RequestSpecBuilder().
                setBaseUri(url).
                build().and().contentType("application/json");




    }


}
