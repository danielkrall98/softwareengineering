//package observer.source;
package observer;

import java.util.LinkedHashSet;
import java.util.Set;

public abstract class NewsSource {
    private Set<NewsSpreader> broadcasts;
    private String name;
    private String password;

    public NewsSource(String name, String password){
        this.name = name;
        this.password = password;
        broadcasts = new LinkedHashSet<NewsSpreader>();
    }

    /**
     * Registers this NewsSource as a trusted Source in given broadcast
     * @param broadcast NewsSpreader to register NewsSource in
     * @return false if source is null or already registered or if pwd is null or empty , true otherwise 
     */
    public boolean registerInNewsSpreader(NewsSpreader broadcast){
        if(broadcast.registerTrustedSource(name, password)){
            broadcasts.add(broadcast);
            return true;
        }

        return false;
    }

    /**
     * Sends a Message to all NewsSpreader this NewsSource has subscribed to
     * @param news message to be sent; 
     * add single #TOPICNAME in message for topic destinction, Topic.Other if no topic specified
     */
    public void sendNews(String news){
        broadcasts.forEach((b) -> {
            try {
                b.spreadNews(news, name, password);
            } catch (Exception e) {
                System.out.println("Error while spreading News \"" + news + "\" from " + name);
            }
        });
    }

    /**
     * @return news to be sent
     */
    public abstract String generateNews();
}
