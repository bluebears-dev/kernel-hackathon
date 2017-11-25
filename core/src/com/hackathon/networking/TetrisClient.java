package com.hackathon.networking;


import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryonet.Client;
import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;
import com.hackathon.networking.requests.RegisterPlayerRequest;
import com.hackathon.networking.responses.RegisterPlayerResponse;

import java.io.IOException;

public class TetrisClient {
    private Client client;
    private static int timeout = 5000;
    private String token;
    String role;

    TetrisClient() {
        TokenGenerator tokenGenerator = new TokenGenerator();
        token = tokenGenerator.generate();

        client = new Client();
        client.addListener(new Listener() {
            public void connected(Connection connection) {
                RegisterPlayerRequest request = new RegisterPlayerRequest(token);
                client.sendTCP(request);
            }

            public void received (Connection connection, Object object) {
                if (object instanceof RegisterPlayerResponse) {
                    RegisterPlayerResponse response = (RegisterPlayerResponse)object;
                    role = response.getRole();
                    System.out.println(role);
                }
            }
            public void disconnected (Connection connection) {
                client.close();
            }
        });
        Kryo kryo = client.getKryo();
        kryo.register(RegisterPlayerResponse.class);
        kryo.register(RegisterPlayerRequest.class);
    }

    public void connect(String host, int port) throws IOException {
        new Thread(client).start();
        client.connect(timeout, host, port);
    }

    public static void main(String[] argv) throws IOException {
        TetrisClient client = new TetrisClient();
        client.connect("localhost", 3333);
    }
}
