import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

import decorator.MRMain;

public class MorseMain {
    public static void main(String[] args) {
        MRMain mr = new MRMain();

        Reader r = mr.getMorseReader("- .... .|--.- ..- .. -.-. -.-|-... .-. --- .-- -.|..-. --- -..-|.--- ..- -- .--. ...|--- ...- . .-.|- .... .|.-.. .- --.. -.--|-.. --- --.");
        int c;
        try {
            while((c = r.read()) != -1){
                System.out.print((char)c);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println();

        Writer w = mr.getROT13Writer();
        try {
            w.write("Hello World!");
            System.out.println(w.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
