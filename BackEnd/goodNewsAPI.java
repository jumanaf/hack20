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
        
    }

    public ArrayList<JsonObject> filterPositive(){


    }

    @GetMapping("/getallnth")
    public ArrayList<Entry> getallnth(@RequestParam(value = "n" int n))
    {


    }
}