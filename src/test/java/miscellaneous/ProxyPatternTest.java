package miscellaneous;


import miscellaneous.proxy.ChildTicketService;
import miscellaneous.proxy.GuardianProxy;
import miscellaneous.proxy.TicketService;

/**
 * @program:DesignPattern
 * @author: Xiang Lei
 * @email: xiang.lei.se@foxmail.com
 * @time: 2023/12/19  14:20
 * @description: 代理模式测试
 */
public class ProxyPatternTest {

    public void ProxyText() {
        System.out.println("*****************************【代理模式展示】****************************");
        System.out.println("代理模式使代理对象具备真实对象的功能，并代替真实对象完成相应操作，");
        System.out.println("并能够在操作执行的前后，对操作进行增强处理。");
        System.out.println("************************************************************************");
        System.out.println("下面来展示购票系统中代理模式的使用。");
        System.out.println("----------------------Proxy Pattern miscellaneous.Test Start--------------------");

        testTicketPurchase(10); // 小于12岁的孩子
        testTicketPurchase(14); // 大于或等于12岁的孩子
        System.out.println("--------------------Proxy Pattern miscellaneous.Test End-------------------");
    }

    private static void testTicketPurchase(int age) {
        System.out.println("测试年龄: " + age + "岁");

        TicketService childService = new ChildTicketService();
        GuardianProxy guardianProxy = new GuardianProxy(childService);

        // 代理验证孩子的年龄
        guardianProxy.verifyAge(age);

        // 根据授权情况，尝试选择票型和购买
        guardianProxy.selectTicketType("premium");
        guardianProxy.calculatePrice();
        guardianProxy.purchaseTicket();

        System.out.println("-------------------------------------");
    }

}
