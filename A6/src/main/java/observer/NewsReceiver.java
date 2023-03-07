//package observer.receiver;
package observer;

import java.util.LinkedHashSet;
import java.util.Set;

public abstract class NewsReceiver {
    private Set<Topic> topics;
    private Set<NewsSpreader> subscriptions;

    public NewsReceiver(){
        subscriptions = new LinkedHashSet<NewsSpreader>();
        topics = new LinkedHashSet<Topic>();
    }

    /**
     * Gets called from a NewsSpreader if there is new news.
     * @param bcmessage Message with the news, time, source and topic
     */
    public abstract void receiveNews(Object sender, BCMessage bcmessage);

    /**
     * Adds a topic to get news about.
     * @param topic Topic to be added.
     * @return true if topic was added, false if topic already was subscribed to.
     */
    public boolean addTopic(Topic topic){
        return topic == null ? false : topics.add(topic);
    }

    public Set<Topic> getTopics(){
        return topics;
    }

    /**
     * Registers this NewsReceiver to get broadcasts from the given NewsSpreader
     * @param broadcaster NewsSpreader to subscribe to
     * @return false if already registered, true otherwise
     */
    public boolean subscribeToBroadcast(NewsSpreader broadcaster){
        if(broadcaster == null)
            return false;

        if(broadcaster.registerNewsReceiver(this)){
            subscriptions.add(broadcaster);
            return true;
        }

        return false;
    }

    /**
     * Unregisters this NewsReceiver from getting broadcasts from the given NewsSpreader
     * @param broadcaster NewsSpreader to unsubscribe from
     * @return false if not registered, true otherwise
     */
    protected boolean unsubscribeToBroadcast(NewsSpreader broadcaster){
        if(broadcaster == null)
            return false;

        if(broadcaster.unregisterNewsReceiver(this)){
            subscriptions.remove(broadcaster);
            return true;
        }

        return false;
    }
}
