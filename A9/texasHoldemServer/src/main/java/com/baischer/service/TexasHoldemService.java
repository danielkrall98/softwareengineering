package com.baischer.service;

import io.grpc.stub.StreamObserver;

import com.baischer.service.grpc.TexasHoldemServiceGrpc.TexasHoldemServiceImplBase;
import com.baischer.texas_holdem_1_0.Hand;
import com.baischer.texas_holdem_1_0.HandVal;
import com.baischer.texas_holdem_1_0.WinCalculator;
import com.baischer.service.grpc.CompareHandsRequest;
import com.baischer.service.grpc.CompareHandsResponse;
import com.baischer.service.grpc.GetHandValueRequest;
import com.baischer.service.grpc.GetHandValueResponse;
import com.baischer.service.grpc.GetProbabilityToWinRequest;
import com.baischer.service.grpc.GetProbabilityToWinResponse;


public class TexasHoldemService extends TexasHoldemServiceImplBase {
    @Override
    public void getHandValue(GetHandValueRequest request, StreamObserver<GetHandValueResponse> responseObserver) {
        String hand = "";
        String hand_value = "";

        //get request data
        hand = request.getHand();

        //-------------------------------------------------------------
        //Logic

        Hand currentHand = new Hand(hand);
        HandVal handval = currentHand.getHandVal();

        hand_value = handval.toString();

        //-------------------------------------------------------------

        //build response
        responseObserver.onNext(GetHandValueResponse.newBuilder()
            .setHandValue(hand_value)
            .build()
        );
        responseObserver.onCompleted();
    }

    @Override
    public void compareHands(CompareHandsRequest request, StreamObserver<CompareHandsResponse> responseObserver) {
        String hand1 = "";
        String hand2 = "";
        int compareResult = 0;

        //get request data
        hand1 = request.getHand1();
        hand2 = request.getHand2();

        //-------------------------------------------------------------
        //Logic

        Hand currentHand1 = new Hand(hand1);
        Hand currentHand2 = new Hand(hand2);

        compareResult = currentHand1.compareTo(currentHand2);

        //-------------------------------------------------------------

        //build response
        responseObserver.onNext(CompareHandsResponse.newBuilder()
            .setResult(compareResult)
            .build()
        );
        responseObserver.onCompleted();
    }

    @Override
    public void getProbabilityToWin(GetProbabilityToWinRequest request, StreamObserver<GetProbabilityToWinResponse> responseObserver) {
        String talon_cards = "";
        String player_pocket_cards = "";
        int number_of_opponents = 0;
        int number_of_simulations = 0;
        double probability = 0.0;

        //get request data
        talon_cards = request.getTalonCards();
        player_pocket_cards = request.getPlayerPocketCards();
        number_of_opponents = request.getNumberOfOpponents();
        number_of_simulations = request.getNumberOfSimulations();

        //-------------------------------------------------------------
        //Logic

        WinCalculator winCalculator = new WinCalculator(talon_cards, player_pocket_cards, number_of_opponents);
        probability = winCalculator.calcProbabilityForWinning(number_of_simulations);

        //-------------------------------------------------------------

        //build response
        responseObserver.onNext(GetProbabilityToWinResponse.newBuilder()
            .setProbability(probability)
            .build()
        );
        responseObserver.onCompleted();
    }
}
