package State;

import Flyweight.Ticket;

public class Destroying implements State{
    @Override
    public void doAction(Ticket ticket) {
        System.out.println("票务撤销中...");
        ticket.setState(this);
    }

    public String toString() {
        return "Destroying State";
    }
}
