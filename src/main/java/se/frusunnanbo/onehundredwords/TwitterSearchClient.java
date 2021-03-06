package se.frusunnanbo.onehundredwords;

import twitter4j.*;

import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;

public class TwitterSearchClient implements SearchClient
{
    private static final int MAX_TWEETS = 100;

    @Override
    public Collection<String> getSearchResult(String query)
    {
        Twitter twitter = TwitterFactory.getSingleton();
       try
        {
            QueryResult result = twitter.search(new Query(query).count(MAX_TWEETS));
            return result.getTweets().stream()
                    .map(tweet -> tweet.getText())
                    .collect(Collectors.toList());
        }
        catch (TwitterException e)
        {
            return Collections.emptyList();
        }
    }
}
