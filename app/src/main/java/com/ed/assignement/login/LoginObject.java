package com.ed.assignement.login;
/**
 * Model to handle the response of the login API
 */
public class LoginObject {
    private int status;
    private boolean authSuccess;
    private String token;

    public LoginObject() {
        super();
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(final int status) {
        this.status = status;
    }

    public boolean getauthSuccess() {
        return authSuccess;
    }

    public void setauthSuccess(final boolean authSuccess) {
        this.authSuccess = authSuccess;
    }

    public String getToken() {
        return token;
    }

    public void setToken(final String token) {
        this.token = token;
    }

}
