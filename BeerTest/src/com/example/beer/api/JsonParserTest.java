package com.example.beer.api;

import android.test.AndroidTestCase;
import com.example.beer.model.BottleType;
import junit.framework.Assert;
import org.json.JSONArray;

import java.util.ArrayList;

public class JsonParserTest extends AndroidTestCase {

    private static final String GET_BOTTLE_RESPONSE = "[" +
            "  {" +
            "    \"Name\":\"Obolon\"," +
            "    \"Volume\":\"0.5\"," +
            "    \"Price\":\"3\"" +
            "  }" +
            "]";

    public void testParseTypeList() {
        String response = GET_BOTTLE_RESPONSE;
        ArrayList<BottleType> typeList = JsonParser.parseTypeList(response);
        assertNotNull(typeList);
        assertEquals(typeList.size(), 1);
        BottleType type = typeList.get(0);
        assertEquals(type.name, "Obolon");
        assertEquals(type.volume, 0.5);
        assertEquals(type.price, 3.0);


        response = GET_BOTTLE_RESPONSE.replace("Name", "Name1");
        typeList = JsonParser.parseTypeList(response);
        assertNotNull(typeList);
        assertEquals(typeList.size(), 0);
    }
}
