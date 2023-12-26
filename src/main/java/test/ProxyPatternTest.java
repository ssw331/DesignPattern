package test;


import proxy.ChildTicketService;
import proxy.GuardianProxy;
import proxy.TicketService;

/**
 * @program:DesignPattern
 * @author: Xiang Lei
 * @email: xiang.lei.se@foxmail.com
 * @time: 2023/12/19  14:20
 * @description: 代理模式测试
 */
public class ProxyPatternTest {

    public static void main(String[] args) {
        System.out.println("启动游乐园**代理模式**演示...\n");

        testTicketPurchase(10); // 小于12岁的孩子
        testTicketPurchase(14); // 大于或等于12岁的孩子
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
