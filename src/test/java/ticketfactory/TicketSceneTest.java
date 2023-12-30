package ticketfactory;

import Flyweight.Ticket;
import Singleton.TicketFactory;
import interpreter.Context;
import interpreter.CustomerExpression;
import interpreter.Expression;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class TicketSceneTest {
    private static final TicketFactory ticketFactory = TicketFactory.getTicketFactory();

    public static void main(String[] args) {
        String date = "";
        String type = "";
        Ticket ticket;
        double price;
        String bonus;
        boolean isVIP = false;

        Expression customerExpression = new CustomerExpression();
        Context context = new Context();

        Scanner scanner = new Scanner(System.in);

        System.out.println("---------------------------------------------------------------------");
        System.out.println("欢迎进入票务系统，首先进入管理员模式：");
        System.out.println("---------------------------------------------------------------------");
        System.out.println("请在一行内输入入园日期和要创建的票种（成人、儿童、老人），用空格隔开：");
        create:
        while (true) {
            if (scanner.hasNextLine()) {
                String ag = scanner.nextLine();
                String[] ags = ag.split(" ");
                if (ags.length <= 1) {
                    System.out.println("参数不足，请重新输入");
                    continue;
                }
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
                    System.out.println("输入有误，请重新输入");
            }
        }
        System.out.println("请输入票价：");
        while (true) {
            if (scanner.hasNextDouble()) {
                price = scanner.nextDouble();
                scanner.nextLine();
                break;
            }
            scanner.nextLine();
            System.out.println("输入票价有误，请重新输入");
        }
        ticket.setPrice(price);

        System.out.println("请输入优惠政策：");
        while (true) {
            if (scanner.hasNextLine()) {
                bonus = scanner.nextLine();
                break;
            }
            scanner.nextLine();
        }
        ticket.setBonus(bonus);

        System.out.println();
        System.out.println("---------------------------------------------------------------------");
        System.out.println("进入顾客模式：");
        System.out.println("---------------------------------------------------------------------");

        double ticketPrice;

        for (int i = 0; i <= 1; i++) {
            System.out.println();
            System.out.println("请在一行内输入输入购买者身份信息（成人、儿童、老人、退伍军人、残疾人）以及是否为VIP（是、否），用空格隔开：");

            buy:
            while (true) {
                if (scanner.hasNextLine()) {
                    String ag = scanner.nextLine();
                    String[] ags = ag.split(" ");
                    if(ags.length <= 1) {
                        System.out.println("参数不足，请重新输入");
                        continue ;
                    }
                    type = ags[0];
                    if (Objects.equals(ags[1], "是")) {
                        isVIP = true;
                    }
                }
                switch (type) {
                    case "成人":
                        context.setCustomerInfo("ADULT", isVIP);
                        ticketPrice = customerExpression.interpret(context, ticketFactory.getAdultTicket(LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")), "成人"));
                        break buy;
                    case "儿童":
                        context.setCustomerInfo("CHILD", isVIP);
                        ticketPrice = customerExpression.interpret(context, ticketFactory.getChildTicket(LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")), "儿童"));
                        break buy;
                    case "老人":
                        context.setCustomerInfo("OLD", isVIP);
                        ticketPrice = customerExpression.interpret(context, ticketFactory.getElderTicket(LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")), "老人"));
                        break buy;
                    case "退伍军人":
                        context.setCustomerInfo("VETERAN", isVIP);
                        ticketPrice = customerExpression.interpret(context, ticketFactory.getAdultTicket(LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")), "成人"));
                        break buy;
                    case "残疾人":
                        context.setCustomerInfo("DISABLED", isVIP);
                        ticketPrice = customerExpression.interpret(context, ticketFactory.getAdultTicket(LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")), "成人"));
                        break buy;
                    default:
                        System.out.println("输入有误，请重新输入");
                        isVIP = false;
                }
            }

            System.out.println("门票价格：" + ticketPrice);
        }

        System.out.println("票务管理场景和购票场景演示结束");
        scanner.close();
    }
}
