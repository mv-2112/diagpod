package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

public class process {

    public static String env() {

        Map<String, String> env = System.getenv();
        ObjectMapper objectMapper = new ObjectMapper();
        String jacksonData = null;
        try {
            jacksonData = objectMapper.writeValueAsString(env);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        return jacksonData;
    }

    public static String running_as() {
        String userId = getUserid();
        String userInfo = userInfo(userId);

        return String.format("Userinfo: %s, %s", userId, userInfo);

    }
    public static String getUserid() {

        String userId = null;
        Process process = null;

        try {
            process = Runtime.getRuntime()
                    .exec("whoami");
            BufferedReader output = new BufferedReader(new InputStreamReader(process.getInputStream()));
            userId = output.readLine().toString();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return userId;
    }

    public static String userInfo(String userId) {

        String userInfo = null;
        Process process = null;

        try {
            process = Runtime.getRuntime()
                    .exec( String.format("id %s", userId));
            BufferedReader output = new BufferedReader(new InputStreamReader(process.getInputStream()));
            userInfo = output.readLine().toString();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return userInfo;
    }


}
