package com.sishuok.util.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class JsonHelper {
    private JsonHelper(){}

    //对象转字符串
    public static String object2str(Object obj){

        String rt = "";
        ObjectMapper mapper = new ObjectMapper();
        try {
            rt = mapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return rt;
    }

    public static Object str2Object(String str,Class cls){
        ObjectMapper mapper = new ObjectMapper();
        Object retObje=null;
        try {
            retObje = mapper.readValue(str,cls);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return retObje;
    }
}
