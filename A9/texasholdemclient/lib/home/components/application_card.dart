import 'package:flutter/material.dart';
import '../../config/constants.dart';

class ApplicationCard extends StatelessWidget {
  const ApplicationCard(
      {super.key,
      this.child = const Text("Popup Card"),
      this.gutterButton = const Icon(Icons.close),
      this.appBarText = "app bar"});

  final Widget child;
  final Widget gutterButton;
  final String appBarText;

  @override
  Widget build(BuildContext context) {
    final AppBar appBar = AppBar(
      shadowColor: Colors.transparent,
      backgroundColor: primaryColor,
      title: Center(
        child: Text(
          appBarText,
          style: const TextStyle(fontWeight: FontWeight.bold, fontSize: 26),
        ),
      ),
    );

    return Card(
      elevation: 8,
      color: secondaryColor,
      shape: RoundedRectangleBorder(
        borderRadius: BorderRadius.circular(8),
      ),
      child: Column(
        children: [
          Padding(padding: const EdgeInsets.all(8.0), child: appBar),
          Padding(
            padding: const EdgeInsets.all(8.0),
            child: Center(child: child),
          ),
          gutterButton,
        ],
      ),
    );
  }
}
