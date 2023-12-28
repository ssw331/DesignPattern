package ticketfactory;

import Flyweight.AdultTicket;
import Flyweight.Ticket;
import Singleton.TicketFactory;
import State.Creating;
import State.Existing;
import interpreter.Context;
import interpreter.CustomerExpression;
import interpreter.Expression;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

class TicketFactoryTest {

    String date = "20231213";
    Ticket ticket;

    @BeforeEach
    public void beforeEach() {
        System.out.println();
        System.out.println("*****************************【票务子系统】****************************");
        System.out.println();
    }

    /**
     * 测试单例模式
     */
    @Test
    @Order(1)
    public void testSingleton() {
        System.out.println("*****************************【单例模式展示】****************************");
        System.out.println("# ");
        System.out.println("# ");
        System.out.println("# ");
        System.out.println("**********************************************************************");
        System.out.println();

        System.out.println("---------------------------单例模式测试开始----------------------------");
        System.out.println("票种从创建状态到已存在状态的切换和对应的行为");
        System.out.println("---------------------------------------------------------------------");

        TicketFactory ticketFactory = TicketFactory.getTicketFactory();
        System.out.println("单例模式测试： " + ticketFactory);

        System.out.println("---------------------------单例模式测试结束----------------------------");
        System.out.println();
    }

    /**
     * 测试享元模式
     */
    @Test
    @Order(2)
    public void testFlyweight() {
        System.out.println("*****************************【享元模式展示】****************************");
        System.out.println("# ");
        System.out.println("# ");
        System.out.println("# ");
        System.out.println("**********************************************************************");
        System.out.println();

        System.out.println("---------------------------享元模式测试开始----------------------------");
        System.out.println("使用享元模式创建成人票种，重复创建时不进行对象生成");
        System.out.println("---------------------------------------------------------------------");

        TicketFactory ticketFactory = TicketFactory.getTicketFactory();
        ticket = ticketFactory.getAdultTicket(date, "成人");
        System.out.println();
        System.out.println("以上为初次创建票务，接下来进行第二次创建");
        System.out.println();
        ticket = ticketFactory.getAdultTicket(date, "成人");
        System.out.println();
        System.out.println("可以看到票务未进行创建。");

        System.out.println("---------------------------享元模式测试结束----------------------------");
        System.out.println();
    }

    /**
     * 测试状态模式
     */
    @Test
    @Order(3)
    public void testStates() {
        System.out.println("*****************************【状态模式展示】****************************");
        System.out.println("# ");
        System.out.println("# ");
        System.out.println("# ");
        System.out.println("**********************************************************************");
        System.out.println();

        System.out.println("---------------------------状态模式测试开始----------------------------");
        System.out.println("票种从创建状态到已存在状态的切换和对应的行为");
        System.out.println("---------------------------------------------------------------------");

        ticket = new AdultTicket(date);
        Creating creating = new Creating();
        creating.doAction(ticket);
        ticket.setState(creating);

        Existing existing = new Existing();
        existing.doAction(ticket);
        ticket.setState(existing);

        System.out.println("---------------------------状态模式测试结束----------------------------");
        System.out.println();
    }

    /**
     * 测试解释器模式
     */
    @Test
    @Order(4)
    public void testInterpreter() {
        System.out.println("*****************************【解释器模式展示】****************************");
        System.out.println("# ");
        System.out.println("# ");
        System.out.println("# ");
        System.out.println("**********************************************************************");
        System.out.println();

        System.out.println("---------------------------解释器模式测试开始----------------------------");
        System.out.println("输入身份信息和VIP信息，通过解释器模式解释信息并设定票价");
        System.out.println("---------------------------------------------------------------------");

        ticket = new AdultTicket(date);
        Expression customerExpression = new CustomerExpression();

        Context context = new Context();
        context.setCustomerInfo("ADULT",true);

        System.out.println("顾客身份信息为：" + "成人 VIP");

        double ticketPrice = customerExpression.interpret(context, ticket);
        System.out.println("门票价格：" + ticketPrice);

        System.out.println("---------------------------解释器模式测试结束----------------------------");
        System.out.println();
    }
}