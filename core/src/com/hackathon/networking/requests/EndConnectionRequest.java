package com.hackathon.networking.requests;

public class EndConnectionRequest extends Request {
    public String role;
    public int gameId;

    public EndConnectionRequest() {}

    public EndConnectionRequest(String token, String role, int gameId) {
        super(token);
        this.role = role;
    }
}
