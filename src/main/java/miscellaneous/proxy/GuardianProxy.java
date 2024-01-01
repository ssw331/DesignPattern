package miscellaneous.proxy;

/**
 * @program:DesignPattern
 * @author: Xiang Lei
 * @email: xiang.lei.se@foxmail.com
 * @time: 2023/12/19  14:19
 * @description: 代理儿童买票
 */
public class GuardianProxy implements TicketService {

    private TicketService realService;
    private boolean permissionGranted;

    public GuardianProxy(TicketService realService) {
        this.realService = realService;
        this.permissionGranted = false;
    }

    public void verifyAge(int age) {
        if (age < 12) {
            permissionGranted = true;
            System.out.println("监护人授权成功");
        } else {
            System.out.println("孩子年龄足够大，可以自己购票");
        }
    }

    @Override
    public void selectTicketType(String type) {
        if (permissionGranted) {
            realService.selectTicketType(type);
        }
    }

    @Override
    public void calculatePrice() {
        if (permissionGranted) {
            realService.calculatePrice();
        }
    }

    @Override
    public void purchaseTicket() {
        if (permissionGranted) {
            realService.purchaseTicket();
        } else {
            System.out.println("未获得监护人授权，无法购买票务");
        }
    }

}
