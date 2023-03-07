import 'package:flutter/material.dart';
import 'package:texasholdemclient/config/constants.dart';
import 'package:texasholdemclient/grpc/texasHoldemService.pbgrpc.dart';
import 'package:texasholdemclient/home/components/compare_hands.dart';
import 'package:texasholdemclient/home/components/handvalue.dart';
import 'package:texasholdemclient/home/components/monte_carlo.dart';

class HomeScreen extends StatefulWidget {
  const HomeScreen(this.client, {super.key});

  final TexasHoldemServiceClient client;

  @override
  State<HomeScreen> createState() => _HomeScreenState();
}

class _HomeScreenState extends State<HomeScreen> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        leading: IconButton(
          icon: const Icon(Icons.arrow_back),
          onPressed: () {
            // Pop the current route off the navigator's stack
            Navigator.pop(context);
          },
        ),
        title: const Text("Texas Hold'em"),
        backgroundColor: secondaryColor,
      ),
      body: SafeArea(
        child: SingleChildScrollView(
          child: Column(
            children: [
              SizedBox(
                  width: double.infinity,
                  child: Padding(
                      padding: const EdgeInsets.all(8.0),
                      child: Handvalue(widget.client))),
              SizedBox(
                width: double.infinity,
                child: Padding(
                    padding: const EdgeInsets.all(8.0),
                    child: CompareHands(widget.client)),
              ),
              SizedBox(
                width: double.infinity,
                child: Padding(
                  padding: const EdgeInsets.all(8.0),
                  child: MonteCarlo(widget.client),
                ),
              ),
            ],
          ),
        ),
      ),
    );
  }
}
