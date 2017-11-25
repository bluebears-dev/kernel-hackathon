package com.hackathon.networking.responses;

public class RegisterPlayerResponse {
    private String role;
    private int gameId;

    public RegisterPlayerResponse() {

    }

    public RegisterPlayerResponse(String role, int id) {
        this.role = role;
        this.gameId = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        if (role != null)
            this.role = role;
        else
            this.role = "";
    }

    public int getGameId() {
        return gameId;
    }
}
