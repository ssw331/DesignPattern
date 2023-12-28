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
        System.out.println("# 单例模式主要作用于一个系统中会被频繁使用的类，避免对这个类的对象的频繁创建和销毁");
        System.out.println("# 主要的实现思路为：在需要调用该类时对其进行检查，如果存在则返回实例，否则创建新的实例");
        System.out.println("# 通过将构造函数私有化和静态成员实例，使得单例类的实例创建在程序运行开始时建进行，保证实例唯一");
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
        System.out.println("# 享元模式主要使用的场景为系统需要创建大量可以提取公用部分的对象时避免重复的创建");
        System.out.println("# 主要实现思路是利用表存储已经创建了的对象，并在业务处理时检查是否已经存在：有则直接返回，无则创建");
        System.out.println("# 利用哈希表将唯一识别码和对象对应，通过查找哈希表确定是否已经创建");
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
        System.out.println("# 状态模式的应用场景主要在于一个对象需要根据不同的状态做出不同的行为");
        System.out.println("# 主要实现思路是根据不同的状态类，将对象作为参数，在不同状态下时对象进行不同的行为");
        System.out.println("# 利用状态类和状态的行为接口，把票种作为参数传入接口并进行不同的操作");
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
        System.out.println("# 解释器模式主要用于对一些特定的语法/文法进行解释，需要上下文和解释逻辑");
        System.out.println("# 主要思路在于：1.构建上下文类，用于存储被解释的内容；2.定义解释类对上下文的解释逻辑");
        System.out.println("# 实现中主要对于身份信息、购票类型进行定义，随后编写解释器类对于票价的解释逻辑即可。");
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