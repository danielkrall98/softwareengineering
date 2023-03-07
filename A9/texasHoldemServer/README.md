# README - Service

Wie in der Vorlesung erwähnt ist der Service mit Maven implementiert.
Falls es bei euch nicht so laufen sollte wie bei mir findet man auf der Seite  [grpc.io](https://grpc.io/docs/languages/java/generated-code/) ein anderes Plugin. Natürlich kann man es auch mit Gradle machen oder auch ohne ein Buildsystem. Beschrieben wird alles auf der oben verlinkten Seite.

Mit `mvn clean compile` kompiliert man alles, dabei werden sowohl die Java Files kompiliert als auch die protobuf datei.



## Testcode in Java
´´´java	
package com.baischer;

import com.baischer.service.grpc.GetHandValueRequest;
import com.baischer.service.grpc.GetHandValueResponse;
import com.baischer.service.grpc.TexasHoldemServiceGrpc;
import com.baischer.service.grpc.TexasHoldemServiceGrpc.TexasHoldemServiceBlockingStub;
import com.baischer.service.grpc.TexasHoldemServiceGrpc.TexasHoldemServiceStub;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class test {
    public static void main(String[] args) {
        final TexasHoldemServiceBlockingStub blockingStub;
        final TexasHoldemServiceStub asyncStub;

        /** Construct client for accessing RouteGuide server using the existing channel. */

        ManagedChannelBuilder<?> channelBuilder = ManagedChannelBuilder.forAddress("127.0.0.1", 49494).usePlaintext();

        ManagedChannel channel = channelBuilder.build();
        blockingStub = TexasHoldemServiceGrpc.newBlockingStub(channel);
        asyncStub = TexasHoldemServiceGrpc.newStub(channel);

        GetHandValueRequest request = GetHandValueRequest.newBuilder().setHand("2c 3c 4c 5c 6c").build();
        GetHandValueResponse response;

        try {
            response = blockingStub.getHandValue(request);
            System.out.println(response.getHandValue());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
´´´