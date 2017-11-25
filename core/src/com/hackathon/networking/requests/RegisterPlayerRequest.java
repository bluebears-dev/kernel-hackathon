package com.hackathon.networking.requests;

public class RegisterPlayerRequest extends Request {
    public RegisterPlayerRequest() {}
    public RegisterPlayerRequest(String token) {
        super(token);
    }
}
