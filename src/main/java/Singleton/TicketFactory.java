package Singleton;

import Flyweight.AdultTicket;
import Flyweight.ChildTicket;
import Flyweight.ElderTicket;
import Flyweight.Ticket;

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
        System.out.println("票务撤销了" + ticket.getDate() + "的票种：" + ticket.getType() + "。此时的票价为：" + ticket.getPrice());
        System.out.println("此票种的优惠政策为：" + ticket.getBonus());
        ticketMap.remove(date + type);
    }
    public AdultTicket getAdultTicket(String date, String type) {
        AdultTicket adultTicket = (AdultTicket) ticketMap.get(date + type);  // 通过类型和日期映射实例，防止不同类型同日期的实例无法被映射
        if (adultTicket == null) {
            System.out.println("正在创建新的票种...");
            adultTicket = new AdultTicket(date);
            ticketMap.put(date + type, adultTicket);
        }

        return adultTicket;
    }

    public ChildTicket getChildTicket(String date, String type) {
        ChildTicket childTicket = (ChildTicket) ticketMap.get(date + type);
        if (childTicket == null) {
            System.out.println("正在创建新的票种...");
            childTicket = new ChildTicket(date);
            ticketMap.put(date + type, childTicket);
        }

        return childTicket;
    }

    public ElderTicket getElderTicket(String date, String type) {
        ElderTicket elderTicket = (ElderTicket) ticketMap.get(date + type);
        if (elderTicket == null) {
            System.out.println("正在创建新的票种...");
            elderTicket = new ElderTicket(date);
            ticketMap.put(date + type, elderTicket);
        }

        return elderTicket;
    }
}
