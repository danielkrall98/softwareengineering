import 'package:flutter/material.dart';
import 'package:fluttertoast/fluttertoast.dart';
import 'package:texasholdemclient/home/components/cards_and_hands.dart';
import '../../grpc/texasHoldemService.pbgrpc.dart';
import 'application_card.dart';
import 'hand_column.dart';

class CompareHands extends StatefulWidget {
  const CompareHands(this.client, {super.key});

  final TexasHoldemServiceClient client;

  @override
  State<CompareHands> createState() => _CompareHandsState();
}

class _CompareHandsState extends State<CompareHands> {
  final key1 = GlobalKey<HandColumnState>();
  final key2 = GlobalKey<HandColumnState>();

  late HandColumn handColumn1 = HandColumn(key: key1);
  late HandColumn handColumn2 = HandColumn(key: key2);

  bool isLoading = false;

  @override
  Widget build(BuildContext context) {
    return ApplicationCard(
      appBarText: "Compare Hands",
      gutterButton: ElevatedButton(
        child: isLoading
            ? IntrinsicHeight(
                child: IntrinsicWidth(
                  child: Row(
                    mainAxisAlignment: MainAxisAlignment.center,
                    children: const [
                      CircularProgressIndicator(color: Colors.white),
                      Text('Please Wait...'),
                    ],
                  ),
                ),
              )
            : const Text('Draw Hands randomly'),
        onPressed: () async {
          //set isLoading flag, indicating that the button is pressed
          if (isLoading) return;
          setState(() {
            isLoading = true;
          });

          //draw hands randomly
          //-------------------------------------------------------
          String hand1 = "";
          String hand2 = "";

          int numberOfDraws1 = 0;
          int numberOfDraws2 = 0;

          for (int i = 0; i < 2; i++) {
            TextEditingController handValueController;
            TextEditingController winningHandController;
            bool specificHandValue;
            String selectedValue;

            if (i == 0) {
              handValueController = key1.currentState!.handValueController;
              winningHandController = key1.currentState!.winningHandController;
              specificHandValue = key1.currentState!.specificHandValue;
              selectedValue = key1.currentState!.selectedValue;
            } else {
              handValueController = key2.currentState!.handValueController;
              winningHandController = key2.currentState!.winningHandController;
              specificHandValue = key2.currentState!.specificHandValue;
              selectedValue = key2.currentState!.selectedValue;
            }

            //draw hand
            String hand;
            String handValue;
            do {
              hand = CAH_getRandomHand();

              //get hand value
              handValue = await widget.client
                  .getHandValue(GetHandValueRequest(hand: hand))
                  .then((response) => handValue = response.handValue,
                      onError: (e) => onFailed(e));

              i == 0 ? numberOfDraws1++ : numberOfDraws2++;
            } while (specificHandValue &&
                handValue != selectedValue &&
                handValue != "NOTVALID");

            //set hand value
            handValueController.text = handValue;
            i == 0 ? hand1 = hand : hand2 = hand;
          }

          //-------------------------------------------------------

          widget.client
              .compareHands(CompareHandsRequest(hand1: hand1, hand2: hand2))
              .then(
                  (response) => {
                        if (response.result == 1)
                          {
                            key1.currentState!.winningHandController.text =
                                "Yes",
                            key2.currentState!.winningHandController.text = "No"
                          }
                        else if (response.result == -1)
                          {
                            key1.currentState!.winningHandController.text =
                                "No",
                            key2.currentState!.winningHandController.text =
                                "Yes"
                          }
                        else
                          {
                            key1.currentState!.winningHandController.text =
                                "Draw",
                            key2.currentState!.winningHandController.text =
                                "Draw"
                          },
                        //set number of draws hint
                        key1.currentState!.hint =
                            "Number of draws: $numberOfDraws1",
                        key2.currentState!.hint =
                            "Number of draws: $numberOfDraws2",

                        key1.currentState!.currentHand = hand1,
                        key2.currentState!.currentHand = hand2,

                        //update UI
                        key1.currentState!.setState(() {}),
                      },
                  onError: (e) => onFailed(e));

          //reset isLoading flag
          setState(() {
            isLoading = false;
          });
        },
      ),
      child: Row(
        mainAxisAlignment: MainAxisAlignment.spaceAround,
        children: [
          Expanded(child: handColumn1),
          Expanded(child: handColumn2),
        ],
      ),
    );
  }

  //failure callback
  Function onFailed = (e) {
    // Show error toast
    Fluttertoast.showToast(
      msg: 'Failed request: $e',
      toastLength: Toast.LENGTH_LONG,
      gravity: ToastGravity.BOTTOM,
    );
  };
}
