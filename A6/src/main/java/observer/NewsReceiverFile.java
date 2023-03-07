//package observer.receiver;
package observer;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class NewsReceiverFile extends NewsReceiver {
    @Override
    public void receiveNews(Object sender, BCMessage bcmessage) {
        //Write message to file in java
        BufferedWriter writer = null;
        try {
            //create a temporary file
            File file = new File("src/main/java/observer/receiver/DaylyNews" + this.hashCode() + ".txt");

            writer = new BufferedWriter(new FileWriter(file, true));
            writer.write(bcmessage.toString());
            writer.write("\n");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
}
