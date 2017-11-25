package com.hackathon.networking.requests;

public class Request {
    String token;

    Request() {
        this.token = "";
    }
    Request(String token) {
        this.token = token;
    }
    public boolean verifyToken(String token) {
        return (token != null && token.equals(this.token));
    }
    public String getToken() {
        return token;
    }
}
