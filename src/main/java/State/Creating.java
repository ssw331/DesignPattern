package State;

import Flyweight.Ticket;

public class Creating implements State{
    @Override
    public void doAction(Ticket ticket) {
        ticket.setState(this);
        System.out.println("票种创建中...");
    }

    public String toString() {
        return "Creating State";
    }
}
