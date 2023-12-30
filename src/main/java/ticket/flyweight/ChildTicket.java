package ticket.flyweight;

import ticket.state.State;

public class ChildTicket implements Ticket {

    private String date;  // 入园时间
    private double price;
    private String bonus;
    private State state;

    public ChildTicket(String date) {
        setPrice(70.0);
        setDate(date);
        createTicket();
    }

    @Override
    public String getDate() {
        return date;
    }

    @Override
    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String getBonus() {
        return bonus;
    }

    @Override
    public void setBonus(String bonus) {
        this.bonus = bonus;
    }

    @Override
    public void createTicket() {
        System.out.println("票务创建了" + date + "的儿童票");
    }

    @Override
    public String getType() {
        return "Child";
    }

    @Override
    public State getState() {
        return state;
    }

    @Override
    public void setState(State state) {
        this.state = state;
    }
}
