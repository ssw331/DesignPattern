package State;

import Flyweight.Ticket;

public interface State {
    void doAction(Ticket ticket);
}
