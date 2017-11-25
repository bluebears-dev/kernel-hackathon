package com.hackathon.networking;


import com.esotericsoftware.kryonet.Connection;

import java.util.*;

public class GameInstance {
    int gameId;
    private Map<Connection, String> connections;
    private Map<String, String> roles;
    private List<String> availableRoles;

    GameInstance(int id) {
        connections = new HashMap<>();
        roles = new HashMap<>();
        availableRoles = new ArrayList<>(
                Arrays.asList(
                        "BUTTON_LEFT",
                        "BUTTON_RIGHT",
                        "BUTTON_ROTATE",
                        "BUTTON_DROP")
        );
        gameId = id;
    }

    public int availableSlots() {
        if (connections.size() < 4)
            return 4 - connections.size();
        else
            return 0;
    }

    public void addPlayer(Connection connection, String token) {
        connections.put(connection, token);
    }

    public String assignButton(String token) {
        Random rand = new Random();
        String button = availableRoles.get(rand.nextInt(availableRoles.size()));
        availableRoles.remove(button);
        roles.put(token, button);
        return button;
    }
}
