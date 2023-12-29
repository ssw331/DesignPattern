package amusementpark;

public interface Visitor {
    void update(int queueLength);
    String getName();
}
