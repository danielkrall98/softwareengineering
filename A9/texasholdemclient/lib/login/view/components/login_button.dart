import 'package:grpc/grpc.dart';
import 'package:grpc/grpc_or_grpcweb.dart';
import 'package:texasholdemclient/grpc/texasHoldemService.pbgrpc.dart';
import 'package:texasholdemclient/home/home_main.dart';
import 'package:flutter/material.dart';
import 'package:fluttertoast/fluttertoast.dart';

class LoginButton extends StatefulWidget {
  const LoginButton(this.ipController, this.portController, {super.key});

  final TextEditingController ipController;
  final TextEditingController portController;

  @override
  State<LoginButton> createState() => _LoginButtonState();
}

class _LoginButtonState extends State<LoginButton> {
  bool isLoading = false;

  @override
  Widget build(BuildContext context) {
    return ElevatedButton(
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
          : const Text('Login'),
      onPressed: () async {
        //set isLoading flag, indicating that the button is pressed
        if (isLoading) return;
        setState(() {
          isLoading = true;
        });

        //call the sign in function
        try {
          String ip = widget.ipController.text;
          int port = int.parse(widget.portController.text);

          //connect to grpc service
          final TexasHoldemServiceClient client = TexasHoldemServiceClient(
            GrpcOrGrpcWebClientChannel.grpc(
              ip,
              port: port,
              options: const ChannelOptions(
                credentials: ChannelCredentials.insecure(),
                idleTimeout: Duration(seconds: 10),
              ),
            ),
          );

          // ignore: use_build_context_synchronously
          onSuccess(context, ip, port, client);
        } catch (e) {
          onFailed(e);
        }

        //reset isLoading flag
        setState(() {
          isLoading = false;
        });
      },
    );
  }

  //success callback
  Function onSuccess = (BuildContext context, String ip, int port,
      TexasHoldemServiceClient client) {
    // Navigate to the home page
    // Show the debug toast
    Fluttertoast.showToast(
      msg: 'Service configured as: $ip:$port',
      toastLength: Toast.LENGTH_LONG,
      gravity: ToastGravity.BOTTOM,
    );

    // Navigate to the login screen, ignoring the current route
    Navigator.of(context).push(
      MaterialPageRoute(builder: (context) => HomeScreen(client)),
    );
  };

  //failure callback
  Function onFailed = (e) {
    // Show error toast
    Fluttertoast.showToast(
      msg: 'Failed to connect to server: $e',
      toastLength: Toast.LENGTH_LONG,
      gravity: ToastGravity.BOTTOM,
    );
  };
}
