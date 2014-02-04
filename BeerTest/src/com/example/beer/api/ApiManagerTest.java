package com.example.beer.api;


import android.test.AndroidTestCase;
import junit.framework.Assert;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ApiManagerTest extends AndroidTestCase {

    private static final String GET_BOTTLE_RESPONSE = "[" +
            "  {" +
            "    \"Name\":\"Obolon\"," +
            "    \"Volume\":\"0.5\"," +
            "    \"Price\":\"3\"" +
            "  }," +
            "  {" +
            "    \"Name\":\"Bud\"," +
            "    \"Volume\":\"0.5\"," +
            "    \"Price\":\"5\"" +
            "  }" +
            "]";

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        MockitoAnnotations.initMocks(this);
    }

    public void testReadResponse() throws IOException {
        HttpResponse testResponse = Mockito.mock(HttpResponse.class);
        HttpEntity testEntity = Mockito.mock(HttpEntity.class);

        InputStream input = new ByteArrayInputStream(GET_BOTTLE_RESPONSE.getBytes("UTF-8"));
        Mockito.when(testEntity.getContent()).thenReturn(input);
        Mockito.when(testResponse.getEntity()).thenReturn(testEntity);

        String response = null;
        try {
            response = ApiManager.readResponse(testResponse);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Assert.assertNotNull(response);
        Assert.assertEquals(GET_BOTTLE_RESPONSE, response);

        Mockito.verify(testResponse).getEntity();
        Mockito.verify(testEntity).getContent();
    }
}
