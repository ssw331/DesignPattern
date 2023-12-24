package PublishSubscrib;

import java.util.HashSet;
import java.util.Set;
public class QueueLength {
    private final Set<Visitor> subscribers = new HashSet<>();
    private int queueLength;

    public void subscribe(Visitor visitor) {
        System.out.println(visitor.getName()+"订阅了排队情况");
        subscribers.add(visitor);
    }

    public void unsubscribe(Visitor visitor) {
        System.out.println(visitor.getName()+"取消了订阅");
        subscribers.remove(visitor);
    }

    public void notifySubscribers() {
        for (Visitor subscriber : subscribers) {

            subscriber.update(this.queueLength);
        }
    }

    public void setQueueLength(int length) {
        this.queueLength = length;
        notifySubscribers();
    }
}
