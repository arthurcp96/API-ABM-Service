package com.ar.sportclubcafe.model.payload;

public class AuthResponse {

    private final String token;
    private final String type;

    public AuthResponse(String token) {
        this.token = token;
        this.type = "Bearer";
    }

    public String getToken() {
        return token;
    }

    public String getType() {
        return type;
    }
}
