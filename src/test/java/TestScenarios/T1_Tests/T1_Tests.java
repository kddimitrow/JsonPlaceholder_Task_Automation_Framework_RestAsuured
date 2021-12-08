package TestScenarios.T1_Tests;

import RestAssuredUtils.RestAssuredUtilMethods;
import TestScenarios.BaseTest;
import org.testng.annotations.Test;

public class T1_Tests extends BaseTest {


    @Override
    public RestAssuredUtilMethods getRestAssuredUtilMethods() {
        return super.getRestAssuredUtilMethods();
    }



    @Test
    public void T1_GetRequest_AllPosts_200_OK(){


            getRestAssuredUtilMethods().setEndpointPath(endpointPaths.getGetPostsPath());
            getRestAssuredUtilMethods().checkStatusCodeIs200(getRestAssuredUtilMethods().getResponse());
            getRestAssuredUtilMethods().getResponseAsString(RestAssuredUtilMethods.getResponse());



    }


}
