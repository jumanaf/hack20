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

    public static SearchResults SearchNews (String searchQuery) throws Exception {
        static String subscriptionKey = "enter key here";
        static String host = "https://api.cognitive.microsoft.com";
        static String path = "/bing/v7.0/news/search";
        static String searchTerm = "Microsoft";
        //...
    }

    public ArrayList<JsonObject> allNews(){

        BING_ENDPOINT = "https://api.cognitive.microsoft.com/bing/v7.0/news";
        API_KEY_COOKIE   = "bing-search-api-key";
        CLIENT_ID_COOKIE = "bing-search-client-id";


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