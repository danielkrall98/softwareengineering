package com.baischer;

import java.io.IOException;

import com.baischer.service.TexasHoldemService;

import io.grpc.Server;
import io.grpc.ServerBuilder;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Server server = ServerBuilder.forPort(49494).addService(new TexasHoldemService()).build();
        server.start();
        System.out.println("Server gestartet");
        server.awaitTermination();
        System.out.println("Server beendet");
    }
}
