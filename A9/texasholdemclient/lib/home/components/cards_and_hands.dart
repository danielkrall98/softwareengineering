// ignore_for_file: non_constant_identifier_names

import 'dart:math';

final List<String> CAH_handValues = [
  "HIGHCARD",
  "ONEPAIR",
  "TWOPAIRS",
  "THREEOFAKIND",
  "STRAIGHT",
  "FLUSH",
  "FULLHOUSE",
  "POKER",
  "STRAIGHTFLUSH",
  "ROYALFLUSH",
];

final List<String> CAH_rank = [
  "-", //no rank
  "A",
  "2",
  "3",
  "4",
  "5",
  "6",
  "7",
  "8",
  "9",
  "T",
  "J",
  "Q",
  "K",
];

final List<String> CAH_suit = [
  "-", //no suit
  "C",
  "D",
  "H",
  "S",
];

Function CAH_getRandomCard = () {
  String suit = "";
  String rank = "";

  do {
    suit = CAH_suit[Random().nextInt(CAH_suit.length)];
  } while (suit == "-");

  do {
    rank = CAH_rank[Random().nextInt(CAH_rank.length)];
  } while (rank == "-");

  return suit + rank;
};

CAH_getRandomHand() {
  String hand = "";
  for (int i = 0; i < 5; i++) {
    hand += CAH_getRandomCard();

    if (i < 4) {
      hand += " ";
    }
  }

  return hand;
}
