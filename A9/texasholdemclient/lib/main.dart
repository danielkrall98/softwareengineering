import 'package:texasholdemclient/config/constants.dart';
import 'package:texasholdemclient/login/view/login_main.dart';
import 'package:flutter/material.dart';
import 'package:google_fonts/google_fonts.dart'; //TODO: Download font

Future main() async {
  WidgetsFlutterBinding.ensureInitialized();

  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  // root widget
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner: true,
      title: 'TEXAS HOLDEM',
      theme: ThemeData.dark().copyWith(
        scaffoldBackgroundColor: bgColor,
        textTheme: GoogleFonts.poppinsTextTheme(Theme.of(context).textTheme)
            .apply(bodyColor: Colors.white),
        canvasColor: secondaryColor,
      ),
      home: const LoginScreen(),
    );
  }
}
