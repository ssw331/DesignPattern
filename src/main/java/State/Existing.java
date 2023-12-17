package State;

import Flyweight.Ticket;

public class Existing implements State {
    @Override
    public void doAction(Ticket ticket) {
        System.out.println("票务创建成功");
        ticket.setState(this);
    }

    public String toString() {
        return "Existing State";
    }
}
