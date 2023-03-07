import 'package:flutter/material.dart';

import '../../config/constants.dart';
import 'cards_and_hands.dart';

class HandColumn extends StatefulWidget {
  const HandColumn({super.key});

  @override
  State<HandColumn> createState() => HandColumnState();
}

class HandColumnState extends State<HandColumn> {
  final _handValueController = TextEditingController(text: "No cards selected");
  final _winningHandController = TextEditingController();
  bool _specificHandValue = false;
  String _selectedValue = 'HIGHCARD';
  String _currentHand = "BG BG BG BG BG";
  String _hint = "";

  TextEditingController get handValueController => _handValueController;
  TextEditingController get winningHandController => _winningHandController;
  bool get specificHandValue => _specificHandValue;
  String get selectedValue => _selectedValue;
  String get currentHand => _currentHand;
  String get hint => _hint;

  set hint(String value) {
    setState(() {
      _hint = value;
    });
  }

  set currentHand(String value) {
    setState(() {
      _currentHand = value;
    });
  }

  @override
  Widget build(BuildContext context) {
    return Column(
      children: [
        ListView.builder(
          shrinkWrap: true,
          physics: const NeverScrollableScrollPhysics(),
          itemCount: 5,
          scrollDirection: Axis.vertical,
          itemBuilder: (BuildContext context, int index) {
            String card = _currentHand.split(" ")[index];

            return SizedBox(
              height: 80,
              child: Card(
                color: tertiaryColor,
                child: Container(
                  padding: const EdgeInsets.all(10),
                  child: Row(
                    children: [
                      Image(
                        image: AssetImage("assets/images/cards/$card.png"),
                      ),
                      const SizedBox(width: 10),
                      Text(card, style: const TextStyle(fontSize: 20)),
                    ],
                  ),
                ),
              ),
            );
          },
        ),
        TextField(
          decoration: const InputDecoration(labelText: 'Hand Value'),
          readOnly: true,
          controller: _handValueController,
        ),
        TextField(
          decoration: const InputDecoration(labelText: 'Winning Hand'),
          readOnly: true,
          controller: _winningHandController,
        ),
        CheckboxListTile(
          title: const Text('Specific Hand Value'),
          value: _specificHandValue,
          onChanged: (value) {
            setState(() {
              _specificHandValue = value ?? false;
            });
          },
        ),
        DropdownButton<String>(
          value: _selectedValue,
          onChanged: _specificHandValue
              ? (newValue) {
                  setState(() {
                    _selectedValue = newValue ?? "";
                  });
                }
              : null, //null in this case disables the dropdown
          items: CAH_handValues.map<DropdownMenuItem<String>>((String value) {
            return DropdownMenuItem<String>(
              value: value,
              child: Text(value),
            );
          }).toList(),
        ),
        Text(style: const TextStyle(color: Colors.grey, fontSize: 12), _hint),
      ],
    );
  }
}
