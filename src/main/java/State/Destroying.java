package State;

import Flyweight.Ticket;

public class Destroying implements State{
    @Override
    public void doAction(Ticket ticket) {
        ticket.setState(this);
        System.out.println("票务撤销中...");
    }

    public String toString() {
        return "Destroying State";
    }
}
