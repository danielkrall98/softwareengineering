import 'package:flutter/material.dart';
import 'package:fluttertoast/fluttertoast.dart';
import 'package:texasholdemclient/home/components/application_card.dart';

import '../../grpc/texasHoldemService.pbgrpc.dart';

class Handvalue extends StatefulWidget {
  const Handvalue(this.client, {super.key});

  final TexasHoldemServiceClient client;

  @override
  State<Handvalue> createState() => _HandvalueState();
}

class _HandvalueState extends State<Handvalue> {
  final cardController = TextEditingController();
  final valueController = TextEditingController();
  bool isLoading = false;

  @override
  Widget build(BuildContext context) {
    return ApplicationCard(
      appBarText: "Handvalue",
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
            : const Text('Assess Hand'),
        onPressed: () async {
          //set isLoading flag, indicating that the button is pressed
          if (isLoading) return;
          setState(() {
            isLoading = true;
          });

          //call grps service
          String cards = cardController.text;

          widget.client.getHandValue(GetHandValueRequest(hand: cards)).then(
              (response) =>
                  valueController.text = response.handValue.toString(),
              onError: (e) => onFailed(e));

          //reset isLoading flag
          setState(() {
            isLoading = false;
          });
        },
      ),
      child: Column(
        children: [
          TextField(
            controller: cardController,
            decoration: const InputDecoration(
              hintText: 'Enter cards e.g. "HK C5 H5 C2 S5"',
            ),
            style: const TextStyle(fontSize: 18),
          ),
          TextField(
            controller: valueController,
            decoration: const InputDecoration(
              hintText: 'asses hand to see value...',
              enabled: false,
            ),
            style: const TextStyle(fontSize: 18),
          ),
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
