import 'package:texasholdemclient/config/constants.dart';
import 'package:texasholdemclient/login/view/components/get_local_ip.dart';
import 'package:texasholdemclient/login/view/components/login_button.dart';
import 'package:flutter/material.dart';

class LoginScreen extends StatefulWidget {
  const LoginScreen({super.key});

  @override
  State<LoginScreen> createState() => _LoginScreenState();
}

class _LoginScreenState extends State<LoginScreen> {
  final ipController = TextEditingController();
  final portController = TextEditingController();

  @override
  Widget build(BuildContext context) {
    ipController.text = "127.0.0.1";
    portController.text = "49494";

    return Scaffold(
      body: SafeArea(
        child: SingleChildScrollView(
          child: Padding(
            padding: const EdgeInsets.all(16.0),
            child: Card(
              color: secondaryColor,
              elevation: 8,
              shape: RoundedRectangleBorder(
                borderRadius: BorderRadius.circular(16),
              ),
              child: Padding(
                padding: const EdgeInsets.all(16.0),
                child: Column(
                  mainAxisAlignment: MainAxisAlignment.center,
                  crossAxisAlignment: CrossAxisAlignment.stretch,
                  children: [
                    //add title
                    const Text(
                      "Texas Hold'em",
                      textAlign: TextAlign.center,
                      style: TextStyle(
                        fontSize: 24,
                        fontWeight: FontWeight.bold,
                      ),
                    ),

                    //add a logo
                    const ClipRRect(
                      borderRadius: BorderRadius.all(Radius.circular(10)),
                      child: Image(
                        image: AssetImage("assets/images/TexasHoldemLogo.png"),
                      ),
                    ),
                    // Add some vertical padding
                    const SizedBox(height: 24),
                    // Create a text field for the service IP
                    TextField(
                      controller: ipController,
                      decoration: const InputDecoration(
                        hintText: 'Enter service IP',
                      ),
                      style: const TextStyle(fontSize: 18),
                    ),
                    // Add some vertical padding
                    const SizedBox(height: 16),
                    // Create a text field for the service port
                    TextField(
                      controller: portController,
                      decoration: const InputDecoration(
                        hintText: 'Enter port',
                      ),
                      style: const TextStyle(fontSize: 18),
                    ),
                    // Add some vertical padding
                    const SizedBox(height: 24),
                    // Create a login button
                    Center(
                      child: LoginButton(ipController, portController),
                    ),
                    // Add some vertical padding
                    const SizedBox(height: 10),
                    // Create a button to get device's local IP
                    Center(
                      child: GetLocalIPButton(ipController),
                    ),
                  ],
                ),
              ),
            ),
          ),
        ),
      ),
    );
  }
}
