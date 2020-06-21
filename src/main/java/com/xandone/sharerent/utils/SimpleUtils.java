package com.xandone.sharerent.utils;


import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class SimpleUtils {
    private final static ObjectMapper mapper = new ObjectMapper();

    public static <T> T json2Pojo(String jsonStr, Class<T> cls) {
        T obj = null;
        try {
            obj = mapper.readValue(jsonStr, cls);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return obj;
    }
}
