package RestAssuredUtils;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;

import static io.restassured.RestAssured.given;


public class RestAssuredUtilMethods {


    public static   void setBaseURI(String baseURI){
        RestAssured.baseURI = baseURI;
    }

    public static void resetBaseURI(){
        RestAssured.baseURI = null;
    }


    public static void setEndpointPath(String basePath){
        RestAssured.basePath = basePath;
    }

    public static   void resetEndpointPath(){
        RestAssured.basePath = null;
    }


    public  static void setContentType(ContentType contentType){
        given().contentType(contentType).log().all();
    }

    public static void setHeaderParameters(String object, String type){
        given().header(object, type).log().all();
    }

    public static void  setPathParam(String pathName, Object typeElement){
        given().pathParam(pathName,typeElement).log().all();
    }


    ///!!!
    public static Response getResponse(String uriPath){
        return given().get(uriPath);
    }
    ///!!!
    public static Response getResponse(){
        return given().get();
    }

    public static void getResponseAsString(Response response){
        System.out.println(response.asString());
    }

    public static   void checkStatusCodeIs200(Response response){
        Assert.assertEquals(response.getStatusCode(), 200);

    }

    public  static JsonPath getJsonPath(Response response){
        String jsonConverted = response.asString();
        return new JsonPath(jsonConverted);
    }

}
