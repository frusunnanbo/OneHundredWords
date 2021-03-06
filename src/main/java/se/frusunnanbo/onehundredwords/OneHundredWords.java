package se.frusunnanbo.onehundredwords;


import com.google.gson.Gson;
import spark.Request;
import spark.Spark;

public class OneHundredWords
{
    public static void main(String argv[])
    {
        final Gson gson = new Gson();
        final SearchService searchService = new SearchService(new TwitterSearchClient());

        Spark.get("/v1/commonwords", (req, res) -> searchService.countWordsForQuery(query(req)), gson::toJson);
    }

    private static String query(Request request)
    {
        return request.queryParams("q");
    }
}
