package State;

import Flyweight.Ticket;

public class Existing implements State {
    @Override
    public void doAction(Ticket ticket) {
        System.out.println("票种已存在");
        ticket.setState(this);
    }

    public String toString() {
        return "Existing State";
    }
}
