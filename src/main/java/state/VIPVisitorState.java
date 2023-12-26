package state;

/**
 * @program:DesignPattern
 * @author: Xiang Lei
 * @email: xiang.lei.se@foxmail.com
 * @time: 2023/12/19  13:58
 * @description: VIP顾客的权限状态
 */
public class VIPVisitorState implements VisitorState {

    @Override
    public void enterPark() {
        System.out.println("欢迎VIP顾客光临，祝您玩得愉快！");
    }

    @Override
    public void accessAttraction() {
        System.out.println("尊贵的VIP顾客，欢迎使用当前游乐设施！");
    }

    @Override
    public void exitPark() {
        System.out.println("欢迎VIP顾客下次光临，再见！");
    }

}
