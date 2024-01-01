package miscellaneous;

import miscellaneous.state.RegularVisitorState;
import miscellaneous.state.VIPVisitorState;
import miscellaneous.state.Visitor;

/**
 * @program:DesignPattern
 * @author: Xiang Lei
 * @email: xiang.lei.se@foxmail.com
 * @time: 2023/12/19  14:01
 * @description: 状态模式测试
 */
public class StatePatternTest {

    public void StateTest() {
        System.out.println("*****************************【状态模式展示】****************************");
        System.out.println("状态模式是一种行为型设计模式，它允许对象在内部状态发生改变时改变它的行为，");
        System.out.println("一个拥有状态的context对象，在不同状态下，其行为会发生改变");
        System.out.println("************************************************************************");
        System.out.println("下面来展示入园权限判定中状态模式的使用。");
        System.out.println("----------------------State Pattern miscellaneous.Test Start--------------------");

        // 创建一个普通游客
        Visitor visitor = new Visitor(new RegularVisitorState());
        visitor.enterPark();
        visitor.accessAttraction();
        visitor.exitPark();

        System.out.println();
        System.out.println("----- 恭喜！您已成功升级成为VIP顾客 -----");
        System.out.println();

        // 游客升级为VIP
        visitor.setState(new VIPVisitorState());
        visitor.enterPark();
        visitor.accessAttraction();
        visitor.exitPark();
        System.out.println("--------------------State Pattern miscellaneous.Test End-------------------");
    }

}
