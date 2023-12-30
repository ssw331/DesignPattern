package ticket.state;

import ticket.flyweight.Ticket;

public interface State {
    void doAction(Ticket ticket);
}
