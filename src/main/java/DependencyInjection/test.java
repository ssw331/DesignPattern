/*
 *依赖注入模式
 * 2153401 赵一婷
 */
package DependencyInjection;

public class test {

    public static void main(String[] args) {
        System.out.println("依赖注入模式测试：游客游游玩某项目后在其票务上进行标记");
        System.out.println("依赖注入体现：musementPark 类依赖于 TicketMarkingService 来为票添加标记。这种依赖关系是通过构造函数注入的");
        // 创建 TicketMarkingService 实例
        TicketMarkingService ticketMarkingService = new TicketMarkingService();

        // 创建 AmusementPark 实例，并注入 TicketMarkingService
        AmusementPark amusementPark = new AmusementPark(ticketMarkingService);

        // 创建 Ticket 和 Attraction 实例
        Ticket ticket = new Ticket();
        Attraction rollerCoaster = new Attraction("Roller Coaster");

        // 模拟游客访问游乐项目
        amusementPark.visitAttraction(ticket, rollerCoaster);

        // 检查票是否正确标记了游乐项目
        if (ticket.getAttractions().contains(rollerCoaster.getName())) {
            System.out.println("票上已为该游乐设施进行标记.");
        } else {
            System.out.println("票上未该游乐设施进行标记.");
        }
    }
}
