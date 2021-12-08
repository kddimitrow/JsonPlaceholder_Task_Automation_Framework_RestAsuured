package TestScenarios;

import RestAssuredHelpers.EndpointPaths;
import RestAssuredHelpers.RestAssuredUtilMethods;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeTest;

public class BaseTest {


    //RestAssured.baseURI = "";

    public String url = "https://jsonplaceholder.typicode.com";

    public static RequestSpecification requestSpec ;

    public static RestAssured restAssured ;

    public EndpointPaths endpointPaths = new EndpointPaths();

    public RestAssuredUtilMethods assuredUtilMethods = new RestAssuredUtilMethods();


    @BeforeTest
    public void setBaseTestSettings(){

        requestSpec = new RequestSpecBuilder().
                setBaseUri(url).
                build().and().contentType("application/json");



    }


}
