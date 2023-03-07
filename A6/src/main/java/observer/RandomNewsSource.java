//package observer.source;
package observer;

import java.util.Random;

public class RandomNewsSource extends NewsSource {
    public RandomNewsSource(String name, String password) {
        super(name, password);
    }

    /**
     * Generated a random message for a random topic
     * @return Generated message
     */
    public String generateNews(){
        final int MESSAGEWORDCOUNT = 10;

        Topic topic = Topic.values()[new Random().nextInt(Topic.values().length)];
        String[] news;
        
        switch(topic){
            case Sport:
                news = new String[]{
                    "Sport ", "Car ", "Football ", "Baseball ", "Bad "
                };
                break;

            case Politics:
                news = new String[]{
                    "Democracy ", "World ", "Climate ", "Current ", "Bad "
                };
                break;

            case Other:
                news = new String[]{
                    "Cats ", "Dogs ", "Kids ", "Fun ", "Bad "
                };
                break;

            default:
                news = new String[]{};
                break;
        }

        String message = "";
        Random random = new Random();
        for(int i = 0; i < MESSAGEWORDCOUNT; i++){
            message += news[random.nextInt(news.length)];
        }
        message += "#" + topic.toString();

        return message;
    }
}
