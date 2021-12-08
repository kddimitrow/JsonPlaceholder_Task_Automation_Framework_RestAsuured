package TestScenarios.T4_Tests;

import TestScenarios.BaseTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class T4_Tests extends BaseTest {

     private int wrongUserId = 33333;


    @Test
    public void T4_GetRequest_AllPosts_404_BadRequest(){

        restAssured.given().
                spec(requestSpec).log().all().
                when().
                get(endpointPaths.getGetPostsWrongPath()).
                then().
                log().all().assertThat().statusCode(404).extract().response();



    }

    @Test
    public void T4_PutRequest_UpdateWrongPostIdWithNewBodyAndTitle_500_BadRequest() throws IOException {


        restAssured.given().
                spec(requestSpec)
                .header("Content-Type","application/json")
                .header("Accept","application/json" ).
                pathParam("idOfPost", wrongUserId ).
                body(new String(Files.readAllBytes(Paths.get("src/main/java/RestAssuredHelpers/BodyForRequest.json")))).log().all().
                when().
                put(endpointPaths.getPutSpecificPostPath()).
                then().
                statusCode(500).log().all().extract().response();
    }


    @Test
    public void T4_PostRequest_CreateUserWithWrongBodyInformation_500_BadRequest(){

        restAssured.given().
                spec(requestSpec).
                body(assuredUtilMethods.wrongJsonBodyAsString()).log().all().
                when().
                post(endpointPaths.getPostCreatePostPath()).
                then().
                statusCode(500).log().all().extract().response();

    }


    @Test
    public void T4_PostRequest_CreateUserWithWrongHeaderFormat_404_BadRequest(){

        restAssured.given().
                baseUri(url).
                header("Content-Type","xml").
                body(assuredUtilMethods.returnJsonBodyAsStringWithSettledParameters()).log().all().
                when().
                post(endpointPaths.getPostCreatePostPath()).
                then().
                statusCode(201).log().all().extract().response();

    }

    @Test
    public void T4_DeleteRequest_WrongUserId_404_BadRequest(){
        restAssured.given().
                spec(requestSpec).
                pathParam("idOfPost", -333).
                when().
                delete(endpointPaths.getDeleteSpecificPostPath()).
                then().
                statusCode(200).log().all().extract().response();

    }



}
