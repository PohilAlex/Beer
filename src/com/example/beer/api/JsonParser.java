package com.example.beer.api;

import com.example.beer.model.BottleType;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class JsonParser {

    public static ArrayList<BottleType> parseTypeList(String data) {
        ArrayList<BottleType> types = null;
        try {
            types = new ArrayList<BottleType>();
            JSONArray array = new JSONArray(data);
            for (int i = 0; i < array.length(); i++) {
                BottleType type = new BottleType();
                JSONObject object = array.getJSONObject(i);
                type.name = object.getString("Name");
                type.volume = object.getDouble("Volume");
                type.price = object.getDouble("Price");
                types.add(type);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return types;
    }

}
