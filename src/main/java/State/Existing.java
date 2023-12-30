package State;

import Flyweight.Ticket;

public class Existing implements State {
    @Override
    public void doAction(Ticket ticket) {
        ticket.setState(this);
        System.out.println("票种已存在");
    }

    public String toString() {
        return "Existing State";
    }
}
