package PublishSubscrib;

public interface Visitor {
    void update(int queueLength);
    String getName();
}
