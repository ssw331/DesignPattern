package Flyweight;

import Singleton.TicketFactory;

import java.util.*;

public class Demo {
    private static final TicketFactory ticketFactory = TicketFactory.getTicketFactory();

    public static void main(String[] args) {
        String date = "";
        String type = "";
        Ticket ticket;
        double price = 100.0;
        String bonus = "";
        Scanner scanner = new Scanner(System.in);
        create:
        while (true) {
            System.out.println("请输入入园日期和要创建的票种（成人、儿童、老人）：");
            if (scanner.hasNextLine()) {
                String ag = scanner.nextLine();
                String[] ags = ag.split(" ");
                date = ags[0];
                type = ags[1];
            }
            switch (type) {
                case "成人":
                    ticket = ticketFactory.getAdultTicket(date, type);  // 避免重复创建对象，但相比抽象工厂，复用率下降了
                    break create;
                case "儿童":
                    ticket = ticketFactory.getChildTicket(date, type);  // 避免重复创建对象，但相比抽象工厂，复用率下降了
                    break create;
                case "老人":
                    ticket = ticketFactory.getElderTicket(date, type);  // 避免重复创建对象，但相比抽象工厂，复用率下降了
                    break create;
                default:
            }
        }
        System.out.println("请输入票价：");
        if (scanner.hasNextDouble()) {
            price = scanner.nextDouble();
            scanner.nextLine();
        }
        ticket.setPrice(price);
        System.out.println("请输入优惠政策：");
        if (scanner.hasNextLine()) {
            bonus = scanner.nextLine();
            scanner.nextLine();
        }
        ticket.setBonus(bonus);
        System.out.println("按下回车键撤销此次建立...");
        if (scanner.hasNextLine()) {
            scanner.nextLine();
            ticketFactory.destroyTicket(date, type);
        }
        scanner.close();
    }
}
