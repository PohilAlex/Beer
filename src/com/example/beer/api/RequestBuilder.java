package com.example.beer.api;

import org.apache.http.client.methods.HttpGet;

public class RequestBuilder {

    private static final String BEER_LIST_URL = "https://dl.dropboxusercontent.com/s/9ax7mat35r60p02/TestBeer.txt?dl=1&token_hash=AAFk8VwC24hsYj-IESJkkHYx7pTmoTPT94ZkddVN-I1zXQ";

    public static HttpGet getBeerList() {
        return new HttpGet(BEER_LIST_URL);
    }

}
