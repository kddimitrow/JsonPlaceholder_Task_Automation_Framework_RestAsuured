package TestScenarios.T1_Tests;

import RestAssuredHelpers.RestAssureBodySerialize;
import TestScenarios.BaseTest;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.equalTo;

public class T1_Tests extends BaseTest {

    //additional information
    String userOneTitleText = "sunt aut facere repellat provident occaecati excepturi optio reprehenderit";

    int   numberOfUserDetails = 1;

    //body information
    public int id = 33;
    public String title = "Updated Title";
    public String body = "Updated Body";
    public int userId = 33;

    private RestAssureBodySerialize assuredUtilMethodsSerialize = new RestAssureBodySerialize(id, title, body, userId);



    @Test
    public void T1_Get_AllPosts_200_OK(){

        restAssured.given().
                    spec(requestSpec).log().all().
                when().
                    get(endpointPaths.getGetPostsPath()).
                then().
                    log().all().assertThat().statusCode(200).extract().response();



    }



    @Test
    public void T1_Get_PostBySpecificNumber_ValidateTitleLength(){

        Response response =  restAssured.given().
                                        spec(requestSpec).
                                        pathParam("UserIdNumber", numberOfUserDetails).log().all().
                                    when().
                                        get(endpointPaths.getGetPostByNumberPath() ).
                                    then()
                                        .log().all().assertThat().statusCode(200).extract().response();


        String responseAsString = response.asString();

        JsonPath jsonObjConvert = new JsonPath(responseAsString);
        Assert.assertEquals(jsonObjConvert.getString("title").length(), userOneTitleText.length());


    }

    @Test
    public void T1_Get_CommentsFromPostBySpecificNumber_AssertEmail(){

                            restAssured.given().
                                                spec(requestSpec).
                                                pathParam("UserIdNumber", numberOfUserDetails).log().all().
                                         when().
                                                get(endpointPaths.getGetCommentsOfPostByUserIdPath()).
                                        then().
                                            statusCode(200).
                                                body("email[2]", equalTo("Nikita@garfield.biz")).log().all();

    }



    @Test
    public void T1_Get_CommentsFromPostBySpecificNumber_AssertEmail_ByStringResponse(){

        String responseEmail =  restAssured.given().
                                                spec(requestSpec).
                                                pathParam("UserIdNumber", numberOfUserDetails).log().all().
                                            when().
                                                get(endpointPaths.getGetCommentsOfPostByUserIdPath()).
                                            then().
                                                statusCode(200).log().all().
                                                and().
                                                extract().path("email[2]");

        Assert.assertEquals(responseEmail, "Nikita@garfield.biz");

    }


    @Test
    public void T1_Put_UpdatePostWithNewBodyAndTitle(){


        restAssured.given().
                        spec(requestSpec)
                .header("Content-Type","application/json")
                .header("Accept","application/json" ).
                        pathParam("idOfPost", id).
                        body(assuredUtilMethodsSerialize).log().all().
                when().
                        put(endpointPaths.getPutSpecificPostPath()).
                then().
                statusCode(200).log().all().extract().response();
    }


    @Test
    public void T1_Post_CreateUserWithBodyAndTitle(){

        restAssured.given().
                            spec(requestSpec).
                            body(assuredUtilMethods.returnJsonBodyAsStringWithSettledParameters()).log().all().
                    when().
                            post(endpointPaths.getPostCreatePostPath()).
                    then().
                            statusCode(201).log().all().extract().response();

    }


    @Test
    public void T1_Delete_User(){
        restAssured.given().
                        spec(requestSpec).
                        pathParam("idOfPost", assuredUtilMethods.userIdForBodyForSettledParameters).
                when().
                        delete(endpointPaths.getDeleteSpecificPostPath()).
                then().
                        statusCode(200).log().all().extract().response();

    }





}
