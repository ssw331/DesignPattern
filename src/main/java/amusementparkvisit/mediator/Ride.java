package amusementparkvisit.mediator;

/**
 * @title: Ride
 * @Author Your Name
 * @Date: 2023/12/15
 * @Version 1.0
 */
public class Ride {
    private String name;
    private int waitTime; // 游乐设施的等待时间

    public Ride(String name, int waitTime) {
        this.name = name;
        this.waitTime = waitTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWaitTime() {
        return waitTime;
    }

    public void setWaitTime(int waitTime) {
        this.waitTime = waitTime;
        QueueMediator.updateQueueInfo(name, waitTime);
    }
}
