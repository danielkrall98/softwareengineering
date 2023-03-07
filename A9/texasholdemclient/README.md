# README - client

`protoc --dart_out=grpc:lib/grpc -IC:/GitHub/PLUS/SE/texasHoldem/texasHoldemServer/src/main/protobuf texasHoldemService.proto` zum kompilieren der Protobuf Datei

Damit `--dart_out` funktioniert muss für dart ein globales Package heruntergeladen werden und aktiviert werden. `dart pub global activate protoc_plugin`. Des Weiteren muss der Pfad dahin zum PATH hinzugefügt werden. Bei mir liegt das unter `C:\Users\johan\AppData\Local\Pub\Cache\bin`

Um die erhaltenden Files benutzen zu können müssen außerdem folgende Dependencies geladen werden: `flutter pub add protobuf grpc`