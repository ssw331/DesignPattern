package test;

import state.RegularVisitorState;
import state.VIPVisitorState;
import state.Visitor;

/**
 * @program:DesignPattern
 * @author: Xiang Lei
 * @email: xiang.lei.se@foxmail.com
 * @time: 2023/12/19  14:01
 * @description: 状态模式测试
 */
public class StatePatternTest {

    public static void main(String[] args) {
        System.out.println("启动游乐园**状态模式**演示...\n");

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
    }

}
