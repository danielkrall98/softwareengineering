import 'package:flutter/material.dart';
import 'package:fluttertoast/fluttertoast.dart';
import 'package:texasholdemclient/home/components/cards_and_hands.dart';

import '../../grpc/texasHoldemService.pbgrpc.dart';
import 'application_card.dart';

class MonteCarlo extends StatefulWidget {
  const MonteCarlo(this.client, {super.key});

  final TexasHoldemServiceClient client;

  @override
  State<MonteCarlo> createState() => _MonteCarloState();
}

class _MonteCarloState extends State<MonteCarlo> {
  String _pocketSuit1 = "-";
  String _pocketRank1 = "-";

  String _pocketSuit2 = "-";
  String _pocketRank2 = "-";

  List<int> possibleBoardCardNumbers = [0, 3, 4, 5];
  int _numberOfBoardCards = 3;

  List<int> possibleNumberOfOpponents = [1, 2, 3, 4, 5, 6, 7, 8, 9];
  int _numberOfOpponents = 1;

  final List<String> _boardSuit = ["-", "-", "-", "-", "-"];
  final List<String> _boardRank = ["-", "-", "-", "-", "-"];

  final _winningProbabilityController = TextEditingController();

  bool isLoading = false;

  @override
  Widget build(BuildContext context) {
    return ApplicationCard(
      appBarText: "Monte Carlo",
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
            : const Text('Calculate Win Probability'),
        onPressed: () async {
          //set isLoading flag, indicating that the button is pressed
          if (isLoading) return;
          setState(() {
            isLoading = true;
          });

          //get win probability
          //-------------------------------------------------------
          String handCard1 = _pocketRank1 + _pocketSuit1;
          String handCard2 = _pocketRank2 + _pocketSuit2;
          String hand = handCard1 + handCard2;

          String board = "";

          for (int i = 0; i < _numberOfBoardCards; i++) {
            board += _boardRank[i] + _boardSuit[i];

            if (i < _numberOfBoardCards - 1) {
              board += " ";
            }
          }

          widget.client
              .getProbabilityToWin(GetProbabilityToWinRequest(
                  playerPocketCards: hand,
                  talonCards: board,
                  numberOfOpponents: _numberOfOpponents,
                  numberOfSimulations: 10000))
              .then(
                  (response) => {
                        _winningProbabilityController.text =
                            "${response.probability.toStringAsFixed(2)}%",
                      },
                  onError: (e) => onFailed(e));

          //reset isLoading flag
          setState(() {
            isLoading = false;
          });

          //-------------------------------------------------------
        },
      ),
      child: Container(
        decoration: BoxDecoration(
          border: Border.all(color: Colors.black),
          borderRadius: BorderRadius.circular(5),
        ),
        padding: const EdgeInsets.all(10),
        child: Column(
          children: [
            Row(
              children: [
                const Text("Number of Boardcards: ",
                    style: TextStyle(fontSize: 15)),
                const Spacer(flex: 1),
                DropdownButton<int>(
                  value: _numberOfBoardCards,
                  icon: const Visibility(
                    visible: false,
                    child: Icon(Icons.arrow_downward),
                  ),
                  onChanged: (newValue) {
                    setState(() {
                      _numberOfBoardCards = newValue ?? 0;
                    });
                  },
                  items: possibleBoardCardNumbers
                      .map<DropdownMenuItem<int>>((int value) {
                    return DropdownMenuItem<int>(
                      value: value,
                      child: Text(value.toString()),
                    );
                  }).toList(),
                ),
                const Spacer(flex: 10),
              ],
            ),
            Row(
              children: [
                const Text("Number of Opponents: ",
                    style: TextStyle(fontSize: 15)),
                const Spacer(flex: 1),
                DropdownButton<int>(
                  value: _numberOfOpponents,
                  icon: const Visibility(
                    visible: false,
                    child: Icon(Icons.arrow_downward),
                  ),
                  onChanged: (newValue) {
                    setState(() {
                      _numberOfOpponents = newValue ?? 0;
                    });
                  },
                  items: possibleNumberOfOpponents
                      .map<DropdownMenuItem<int>>((int value) {
                    return DropdownMenuItem<int>(
                      value: value,
                      child: Text(value.toString()),
                    );
                  }).toList(),
                ),
                const Spacer(flex: 10),
              ],
            ),
            Row(
              children: [
                const Text("Pocket", style: TextStyle(fontSize: 20)),
                const Spacer(flex: 1),
                Row(
                  children: [
                    DropdownButton<String>(
                      value: _pocketSuit1,
                      icon: const Visibility(
                        visible: false,
                        child: Icon(Icons.arrow_downward),
                      ),
                      onChanged: (newValue) {
                        setState(() {
                          _pocketSuit1 = newValue ?? "";
                        });
                      },
                      items: CAH_suit.map<DropdownMenuItem<String>>(
                          (String value) {
                        return DropdownMenuItem<String>(
                          value: value,
                          child: Text(value),
                        );
                      }).toList(),
                    ),
                    DropdownButton<String>(
                      value: _pocketRank1,
                      icon: const Visibility(
                          visible: false, child: Icon(Icons.arrow_downward)),
                      onChanged: (newValue) {
                        setState(() {
                          _pocketRank1 = newValue ?? "";
                        });
                      },
                      items: CAH_rank.map<DropdownMenuItem<String>>(
                          (String value) {
                        return DropdownMenuItem<String>(
                          value: value,
                          child: Text(value),
                        );
                      }).toList(),
                    ),
                  ],
                ),
                const SizedBox(width: 10),
                Row(
                  children: [
                    DropdownButton<String>(
                      value: _pocketSuit2,
                      icon: const Visibility(
                          visible: false, child: Icon(Icons.arrow_downward)),
                      onChanged: (newValue) {
                        setState(() {
                          _pocketSuit2 = newValue ?? "";
                        });
                      },
                      items: CAH_suit.map<DropdownMenuItem<String>>(
                          (String value) {
                        return DropdownMenuItem<String>(
                          value: value,
                          child: Text(value),
                        );
                      }).toList(),
                    ),
                    DropdownButton<String>(
                      value: _pocketRank2,
                      icon: const Visibility(
                          visible: false, child: Icon(Icons.arrow_downward)),
                      onChanged: (newValue) {
                        setState(() {
                          _pocketRank2 = newValue ?? "";
                        });
                      },
                      items: CAH_rank.map<DropdownMenuItem<String>>(
                          (String value) {
                        return DropdownMenuItem<String>(
                          value: value,
                          child: Text(value),
                        );
                      }).toList(),
                    ),
                  ],
                ),
                const Spacer(flex: 2),
              ],
            ),
            Row(
              children: [
                const Text("Board", style: TextStyle(fontSize: 20)),
                const Spacer(flex: 1),
                SizedBox(
                  height: 50,
                  child: ListView.builder(
                    shrinkWrap: true,
                    physics: const NeverScrollableScrollPhysics(),
                    itemCount: _numberOfBoardCards,
                    scrollDirection: Axis.horizontal,
                    itemBuilder: (BuildContext context, int index) {
                      return Row(
                        children: [
                          const SizedBox(width: 10),
                          DropdownButton<String>(
                            value: _boardSuit[index],
                            icon: const Visibility(
                                visible: false,
                                child: Icon(Icons.arrow_downward)),
                            onChanged: (newValue) {
                              setState(() {
                                _boardSuit[index] = newValue ?? "";
                              });
                            },
                            items: CAH_suit.map<DropdownMenuItem<String>>(
                                (String value) {
                              return DropdownMenuItem<String>(
                                value: value,
                                child: Text(value),
                              );
                            }).toList(),
                          ),
                          DropdownButton<String>(
                            value: _boardRank[index],
                            icon: const Visibility(
                                visible: false,
                                child: Icon(Icons.arrow_downward)),
                            onChanged: (newValue) {
                              setState(() {
                                _boardRank[index] = newValue ?? "";
                              });
                            },
                            items: CAH_rank.map<DropdownMenuItem<String>>(
                              (String value) {
                                return DropdownMenuItem<String>(
                                  value: value,
                                  child: Text(value),
                                );
                              },
                            ).toList(),
                          ),
                        ],
                      );
                    },
                  ),
                ),
                const Spacer(flex: 2),
              ],
            ),
            Center(
              child: TextField(
                decoration:
                    const InputDecoration(labelText: 'Winning Probability'),
                readOnly: true,
                controller: _winningProbabilityController,
              ),
            )
          ],
        ),
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
