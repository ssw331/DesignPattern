package proxy;

/**
 * @program:DesignPattern
 * @author: Xiang Lei
 * @email: xiang.lei.se@foxmail.com
 * @time: 2023/12/19  14:15
 * @description: 购票服务接口
 */
public interface TicketService {

    void selectTicketType(String type);  // 选择票种

    void calculatePrice();  // 计算票价

    void purchaseTicket();  // 购票

}
