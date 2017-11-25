package com.hackathon.networking;

import com.badlogic.gdx.Game;
import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.EndPoint;
import com.esotericsoftware.kryonet.Listener;
import com.esotericsoftware.kryonet.Server;
import com.hackathon.networking.requests.RegisterPlayerRequest;
import com.hackathon.networking.responses.RegisterPlayerResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class TetrisServer {
    private Server server;
    private List<GameInstance> games;
    private int idCounter;

    TetrisServer() {
        server = new Server();
        games = new LinkedList<GameInstance>();

        Kryo kryo = server.getKryo();
        kryo.register(RegisterPlayerResponse.class);
        kryo.register(RegisterPlayerRequest.class);
        idCounter = 0;

        server.addListener(new Listener() {
            public void received (Connection connection, Object object) {
                if (object instanceof RegisterPlayerRequest) {
                    RegisterPlayerRequest request = (RegisterPlayerRequest)object;
                    GameInstance instance = getAvailableGame();

                    instance.addPlayer(connection, request.getToken());
                    String button = instance.assignButton(request.getToken());

                    RegisterPlayerResponse response = new RegisterPlayerResponse(button, idCounter);
                    System.out.println("Reqistered new user: " + request.getToken());
                    System.out.println("Game ID: " + instance.gameId);
                    connection.sendTCP(response);
                }
            }
        });
    }

    private GameInstance getAvailableGame() {
        for (GameInstance instance : games) {
            System.out.println(instance.availableSlots());

            if (instance.availableSlots() > 0)
                return instance;
        }
        idCounter++;
        games.add(new GameInstance(idCounter));
        return games.get(games.size() - 1);
    }

    public void listen(int port) throws IOException {
        server.start();
        server.bind(3333);
    }

    public static void main(String[] argv) throws IOException {
        TetrisServer server = new TetrisServer();
        server.listen(3333);
    }
}