//package observer.message;
package observer;

import java.time.*;

public class BCMessage {
    private String message;
    private String source;
    private LocalDateTime time;
    private Topic topic;

    public BCMessage(String message, String source, LocalDateTime time, Topic topic) {
        this.message = message;
        this.source = source;
        this.time = time;
        this.topic = topic;
    }

    public String getMessage() {
        return message;
    }
    public String getSource() {
        return source;
    }
    public LocalDateTime getTime() {
        return time;
    }
    public Topic getTopic() {
        return topic;
    }
    
    public void setMessage(String message) {
        this.message = message;
    }
    public void setSource(String source) {
        this.source = source;
    }
    public void setTime(LocalDateTime time) {
        this.time = time;
    }
    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    @Override
    public String toString() {
        return "BCMessage [message=" + message + ", source=" + source + ", time=" + time + ", topic=" + topic + "]";
    }
}
