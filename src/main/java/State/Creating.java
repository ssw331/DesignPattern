package State;

import Flyweight.Ticket;

public class Creating implements State{
    @Override
    public void doAction(Ticket ticket) {
        System.out.println("票种创建中...");
        ticket.setState(this);
    }

    public String toString() {
        return "Creating State";
    }
}
