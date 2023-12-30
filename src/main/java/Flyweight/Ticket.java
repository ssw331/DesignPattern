package Flyweight;

import State.State;

public interface Ticket {
    void createTicket();  // 创建票种的信息提示

    void setPrice(double price);

    void setBonus(String bonus);

    double getPrice();

    String getBonus();

    String getType();

    State getState();

    void setState(State state);

    String getDate();

    void setDate(String date);
}
