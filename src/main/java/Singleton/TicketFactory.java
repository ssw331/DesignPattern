package Singleton;

import Flyweight.AdultTicket;
import Flyweight.ChildTicket;
import Flyweight.ElderTicket;
import Flyweight.Ticket;
import State.Creating;
import State.Destroying;
import State.Existing;

import java.util.HashMap;

public class TicketFactory {
    private static final TicketFactory ticketFactory = new TicketFactory();  // 单例模式唯一实例
    private static final HashMap<String, Ticket> ticketMap = new HashMap<>();  // 同价格不同票种需要警告

    TicketFactory() {
        System.out.println("正在创建唯一存在实例票务生成系统...");
    }
    public static TicketFactory getTicketFactory() {
        return ticketFactory;
    }
    public void destroyTicket(String date, String type) {
        Ticket ticket = ticketMap.get(date + type);
        Destroying destroying = new Destroying();
        destroying.doAction(ticket);
        System.out.println(ticket.getState());
        System.out.println("票务撤销了" + ticket.getDate() + "的票种：" + ticket.getType() + "。此时的票价为：" + ticket.getPrice());
        System.out.println("此票种的优惠政策为：" + ticket.getBonus());
        ticketMap.remove(date + type);
    }
    public void createTicket(String date, String type) {  // 用于保证票务信息被传入数据库
        Ticket ticket = ticketMap.get(date + type);
        Creating creating = new Creating();
        creating.doAction(ticket);
        System.out.println(ticket.getState());
    }
    public void existStateDetect(Ticket ticket) {
        Existing existing = new Existing();
        existing.doAction(ticket);
        System.out.println(ticket.getState());
    }
    public AdultTicket getAdultTicket(String date, String type) {
        AdultTicket adultTicket = (AdultTicket) ticketMap.get(date + type);  // 通过类型和日期映射实例，防止不同类型同日期的实例无法被映射
        if (adultTicket == null) {
            adultTicket = new AdultTicket(date);
            ticketMap.put(date + type, adultTicket);
            createTicket(date, type);
            existStateDetect(adultTicket);
        }

        return adultTicket;
    }

    public ChildTicket getChildTicket(String date, String type) {
        ChildTicket childTicket = (ChildTicket) ticketMap.get(date + type);
        if (childTicket == null) {
            childTicket = new ChildTicket(date);
            ticketMap.put(date + type, childTicket);
            createTicket(date, type);
            existStateDetect(childTicket);
        }

        return childTicket;
    }

    public ElderTicket getElderTicket(String date, String type) {
        ElderTicket elderTicket = (ElderTicket) ticketMap.get(date + type);
        if (elderTicket == null) {
            elderTicket = new ElderTicket(date);
            ticketMap.put(date + type, elderTicket);
            createTicket(date, type);
            existStateDetect(elderTicket);
        }

        return elderTicket;
    }
}
