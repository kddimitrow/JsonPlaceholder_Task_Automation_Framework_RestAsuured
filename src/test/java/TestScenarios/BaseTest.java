package TestScenarios;

import RestAssuredUtils.RestAssuredUtilMethods;
import io.restassured.http.ContentType;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {

    String baseURL = "https://jsonplaceholder.typicode.com";




    public static RestAssuredUtilMethods restAssuredUtilMethods;

    public  RestAssuredUtilMethods getRestAssuredUtilMethods() {
        return restAssuredUtilMethods;
    }

    public EndpointPaths endpointPaths = new EndpointPaths();

    @BeforeTest
    public void setUpMethod(){
            restAssuredUtilMethods.setBaseURI(baseURL);
        restAssuredUtilMethods.setContentType(ContentType.JSON);

    }


    @AfterTest
    public void tearDownMethod(){
    restAssuredUtilMethods.resetBaseURI();
    restAssuredUtilMethods.resetEndpointPath();
    }

}
