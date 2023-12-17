package Flyweight;

import State.State;

public class AdultTicket implements Ticket {
    private String date;  // 入园时间
    private double price;  // 价格
    private String bonus;  // 优惠政策
    private State state;

    public AdultTicket(String date) {
        setDate(date);
        setPrice(price);
        createTicket();
    }

    @Override
    public State getState() {
        return state;
    }

    @Override
    public void setState(State state) {
        this.state = state;
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
    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public void setBonus(String bonus) {
        this.bonus = bonus;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public String getBonus() {
        return bonus;
    }

    @Override
    public String getType() {
        return "Adult";
    }

    @Override
    public void createTicket() {
        System.out.println("票务创建了" + date + "的成人票");
    }
}
