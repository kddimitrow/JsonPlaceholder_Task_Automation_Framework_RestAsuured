package RestAssuredHelpers;

public class RestAssuredUtilMethods {





    public String titleForBodyForSettledParameters = "Great QA Engineer";
    public int userIdForBodyForSettledParameters = 987;



    public String returnJsonBodyAsString(){

        String jsonBody = "{\n" +
                "    \"title\": \"GGG\",\n" +
                "    \"body\": \"bar\",\n" +
                "    \"userId\": 333\n" +
                "  }";

        return jsonBody;

    }


    public String returnJsonBodyAsStringWithSettledParameters(){

        String jsonBody = "{\n" +
                "    \"title\": \""+ titleForBodyForSettledParameters +"\",\n" +
                "    \"body\": \"bar\",\n" +
                "    \"userId\": \""+ userIdForBodyForSettledParameters +"\"\n" +
                "  }";


        return jsonBody;

    }


    public String wrongJsonBodyAsString(){

        String jsonBody = "{\n" +
                "    \"title\": \"\",\n" +
                "    \"body\": \"\",\n" +
                "    \"userId\": \n" +
                "  }";

        return jsonBody;

    }



}
