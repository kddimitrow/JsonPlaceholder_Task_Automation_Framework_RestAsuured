package RestAssuredHelpers;

public class EndpointPaths {


    // correct paths
    private String getPostsPath = "/posts";

    private String getPostByNumberPath = "/posts/{UserIdNumber}";

    private String getCommentsOfPostByUserIdPath = "/posts/{UserIdNumber}/comments";

    private String postCreatePostPath = "/posts";

    private String deleteSpecificPostPath = "posts/{idOfPost}";

    private String putSpecificPostPath = "posts/{idOfPost}";


    // wrong paths for T4 test scenarios
    private String getPostsWrongPath = "/posts1";



    public String getGetPostsPath() {
        return getPostsPath;
    }

    public String getGetPostByNumberPath() {
        return getPostByNumberPath;
    }

    public String getGetCommentsOfPostByUserIdPath() {
        return getCommentsOfPostByUserIdPath;
    }

    public String getPostCreatePostPath() {
        return postCreatePostPath;
    }

    public String getDeleteSpecificPostPath() {
        return deleteSpecificPostPath;
    }

    public String getPutSpecificPostPath() {
        return putSpecificPostPath;
    }



    public String getGetPostsWrongPath() {
        return getPostsWrongPath;
    }

}
