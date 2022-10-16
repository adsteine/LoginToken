package com.ed.assignement.login;


import org.json.JSONException;
import org.json.JSONObject;

/**
 * Parser for Login request response
 */
public class LoginJsonParser {
    public static final String STATUS = "status";
    private static final String authsuccess = "authSuccess";
    private static final String TOKEN = "token";
    public LoginObject mapObject;

    public LoginJsonParser(final JSONObject jsonData) {
        try {
            mapObject = new LoginObject();
            mapObject.setStatus((int) jsonData.get(STATUS));
            mapObject.setauthSuccess((boolean)jsonData.get(authsuccess));
            mapObject.setToken(jsonData.get(TOKEN).toString());
        } catch (JSONException e) {

        }
    }

}
