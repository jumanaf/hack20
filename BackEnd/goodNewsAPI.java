package com.backend;

import java.net.*;
import java.util.*;
import java.io.*;
import javax.net.ssl.HttpsURLConnection;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

public class goodNewsAPI {

    ArrayList<JsonObject> allPositive;

    public goodNewsAPI(){

        // get all news
        // filter positive
        // store in field
    }

    public ArrayList<JsonObject> allNews(){
        BING_ENDPOINT = "https://api.cognitive.microsoft.com/bing/v7.0/news";
        API_KEY_COOKIE   = "bing-search-api-key";
        CLIENT_ID_COOKIE = "bing-search-client-id";


    }

    public boolean bingNewsSearch(query, options, key) {

        // scroll to top of window
        window.scrollTo(0, 0);
        //if (!query.trim().length) return false;     // empty query, do nothing

        showDiv("noresults", "Working. Please wait.");
        hideDivs("results", "related", "_json", "_http", "paging1", "paging2", "error");

        var request = new XMLHttpRequest();
        if (category.valueOf() != "all".valueOf()) {
            var queryurl = BING_ENDPOINT + "?" + options;
        }
        else {
            if (query){
                var queryurl = BING_ENDPOINT + "/search" + "?q=" + encodeURIComponent(query) + "&" + options;
            }
            else {
                var queryurl = BING_ENDPOINT + "?" + options;
            }
        }

        // open the request
        try {
            request.open("GET", queryurl);
        }
        catch (e) {
            renderErrorMessage("Bad request (invalid URL)\n" + queryurl);
            return false;
        }

        // add request headers
        request.setRequestHeader("Ocp-Apim-Subscription-Key", key);
        request.setRequestHeader("Accept", "application/json");
        var clientid = retrieveValue(CLIENT_ID_COOKIE);
        if (clientid) request.setRequestHeader("X-MSEdge-ClientID", clientid);

        // event handler for successful response
        request.addEventListener("load", handleBingResponse);

        // event handler for erorrs
        request.addEventListener("error", function() {
            renderErrorMessage("Error completing request");
        });

        // event handler for aborted request
        request.addEventListener("abort", function() {
            renderErrorMessage("Request aborted");
        });

        // send the request
        request.send();
        return false;
    }

    public ArrayList<JsonObject> filterPositive(){


    }

    @GetMapping("/getallnth")
    public ArrayList<JsonObject> getallnth(@RequestParam(value = "n" int n), @RequestParam(value = "number_posts") int number_posts)
    {
        List<JsonObject> results = new ArrayList<>();
        for(int x = 0; x < number_posts; x++){
            results.add(allPostive.get(x+(n*number_posts)));
        }

        return results;
    }
}