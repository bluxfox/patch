package utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 * Created by mad-man on 2017/8/12.
 */
public class JsonUtils {
    static ObjectMapper toJsonMapper = new ObjectMapper();
    static ObjectMapper toObjMapper = new ObjectMapper();
    static{
        toObjMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }
    public static String toJson(Object object){
        if(object != null){
            try {
                return toJsonMapper.writeValueAsString(object);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
                return null;
            }
        }
        return null;
    }

    public static <T> Object toObj(String json , Class<T> clazz){

        try {
            return toObjMapper.readValue(json, clazz);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
