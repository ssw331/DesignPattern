package amusementpark;

public class Tourist implements Visitor{
    private final String name;

    public Tourist(String name) {
        this.name = name;
    }

    @Override
    public String getName(){
        return this.name;
    }

    @Override
    public void update(int queueLength) {
        System.out.println(name + " 收到订阅消息，排队人数为: " + queueLength);
    }
}
