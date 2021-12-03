package RestAssuredHelpers;

public class RestAssuredUtilMethods {





    public String titleForBodyOptionTwo = "WgW";
    public int userIdForBodyOptionTwo = 987;



    public String returnJsonBodyAsString(){

        String jsonBody = "{\n" +
                "    \"title\": \"GGG\",\n" +
                "    \"body\": \"bar\",\n" +
                "    \"userId\": 333\n" +
                "  }";

        return jsonBody;

    }


    public String returnJsonBodyAsStringOptionTwo(){

        String jsonBody = "{\n" +
                "    \"title\": \""+titleForBodyOptionTwo +"\",\n" +
                "    \"body\": \"bar\",\n" +
                "    \"userId\": \""+ userIdForBodyOptionTwo +"\"\n" +
                "  }";


        return jsonBody;

    }





}
