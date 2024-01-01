package miscellaneous.proxy;

/**
 * @program:DesignPattern
 * @author: Xiang Lei
 * @email: xiang.lei.se@foxmail.com
 * @time: 2023/12/19  14:16
 * @description: 儿童购票
 */
public class ChildTicketService implements TicketService {

    private String ticketType;
    private double price;

    @Override
    public void selectTicketType(String type) {
        this.ticketType = type;
        System.out.println("孩子选择了" + type + "类型的票");
    }

    @Override
    public void calculatePrice() {
        // 根据票务类型计算价格
        if ("standard".equals(ticketType)) {
            price = 20.0;
        } else if ("premium".equals(ticketType)) {
            price = 50.0;
        }
        System.out.println(ticketType + "票的价格是 $" + price);
    }

    @Override
    public void purchaseTicket() {
        System.out.println("孩子购买了" + ticketType + "票，价格为 $" + price);
    }

}


