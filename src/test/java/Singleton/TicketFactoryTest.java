package Singleton;

import Flyweight.Ticket;

class TicketFactoryTest {

    String date = "20231213";
    Ticket ticket;
    double price = 100.0;
    String bonus = "test";

    TicketFactory ticketFactory = TicketFactory.getTicketFactory();

    @org.junit.jupiter.api.Test
    void getTicketFactory() {
        ticketFactory = TicketFactory.getTicketFactory();
        System.out.println("单例模式测试： " + ticketFactory);
    }

    @org.junit.jupiter.api.Test
    void destroyTicket() {
        ticket = ticketFactory.getAdultTicket(date, "成人");
        set();
        System.out.println("撤销中...");
        ticketFactory.destroyTicket(date, "成人");
    }

    @org.junit.jupiter.api.Test
    void createTicket() {
        ticket = ticketFactory.getAdultTicket(date, "成人");
        System.out.println();
        System.out.println("以上为创建票务日志，接下来进行创建状态检测");
        System.out.println();
        ticketFactory.createTicket(date, "成人");
    }

    @org.junit.jupiter.api.Test
    void existStateDetect() {
        ticket = ticketFactory.getAdultTicket(date, "成人");
        System.out.println("以上为创建票务日志，接下来进行存在状态检测");
        ticketFactory.existStateDetect(ticket);
    }

    @org.junit.jupiter.api.Test
    void getAdultTicket() {
        System.out.println("享元模式测试");
        ticket = ticketFactory.getAdultTicket(date, "成人");  // 避免重复创建对象，但相比抽象工厂，复用率下降了
        System.out.println("享元模式：尝试再次创建相同票种");
        ticket = ticketFactory.getAdultTicket(date, "成人");  // 避免重复创建对象，但相比抽象工厂，复用率下降了
        set();
    }

    @org.junit.jupiter.api.Test
    void getChildTicket() {
        System.out.println("享元模式测试");
        ticket = ticketFactory.getChildTicket(date, "儿童");  // 避免重复创建对象，但相比抽象工厂，复用率下降了
        System.out.println("享元模式：尝试再次创建相同票种");
        ticket = ticketFactory.getAdultTicket(date, "儿童");  // 避免重复创建对象，但相比抽象工厂，复用率下降了
        set();
    }

    @org.junit.jupiter.api.Test
    void getElderTicket() {
        System.out.println("享元模式测试");
        ticket = ticketFactory.getElderTicket(date, "老人");  // 避免重复创建对象，但相比抽象工厂，复用率下降了
        System.out.println("享元模式：尝试再次创建相同票种");
        ticket = ticketFactory.getAdultTicket(date, "老人");  // 避免重复创建对象，但相比抽象工厂，复用率下降了
        set();
    }

    void set() {
        System.out.println("正在载入票价");
        ticket.setPrice(price);
        System.out.println("正在载入优惠政策");
        ticket.setBonus(bonus);
    }
}