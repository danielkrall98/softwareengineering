import 'package:flutter/material.dart';
import 'package:fluttertoast/fluttertoast.dart';

class GetLocalIPButton extends StatelessWidget {
  const GetLocalIPButton(this.ipController, {super.key});

  final TextEditingController ipController;

  @override
  Widget build(BuildContext context) {
    return TextButton(
      onPressed: () async {
        try {
          //ipController.text = (await NetworkInfo().getWifiIP()) ?? ipController.text;
          ipController.text = "10.0.2.2";
        } catch (e) {
          Fluttertoast.showToast(
            msg: 'Not supported on this device',
            toastLength: Toast.LENGTH_LONG,
            gravity: ToastGravity.BOTTOM,
          );
        }
      },
      child: const Text("Get local IP"),
    );
  }
}
