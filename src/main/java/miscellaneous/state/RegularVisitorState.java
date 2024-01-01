package miscellaneous.state;

/**
 * @program:DesignPattern
 * @author: Xiang Lei
 * @email: xiang.lei.se@foxmail.com
 * @time: 2023/12/19  13:55
 * @description: 普通游客的权限状态
 */
public class RegularVisitorState implements VisitorState{

@Override
    public void enterPark() {
        System.out.println("欢迎光临，祝您玩得愉快！");
    }

    @Override
    public void accessAttraction() {
        System.out.println("您好，欢迎使用当前游乐设施！");
    }

    @Override
    public void exitPark() {
        System.out.println("欢迎下次光临，再见！");
    }

}
