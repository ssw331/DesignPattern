package miscellaneous;

import miscellaneous.visitor.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @program:DesignPattern
 * @author: Xiang Lei
 * @email: xiang.lei.se@foxmail.com
 * @time: 2023/12/18  23:25
 * @description: 访问者模式测试
 */
public class VisitorPatternTest {

    public void VisitorTest() {
        System.out.println("*****************************【访问者模式展示】****************************");
        System.out.println("访问者模式，即在不改变聚合对象内元素的前提下，为聚合对象内每个元素提供多种访问方式。");
        System.out.println("访问者模式主要解决稳定的数据结构和易变元素的操作之间的耦合问题。");
        System.out.println("************************************************************************");
        System.out.println("下面来展示游乐设施访问中访问者模式的使用。");
        System.out.println("----------------------Visitor Pattern miscellaneous.Test Start--------------------");

        List<AmusementFacilityBase> facilities = new ArrayList<>();  // 游乐设施列表

        System.out.println("初始化游乐场设施...");
        // 添加游乐设施
        facilities.add(new RollerCoaster());  // 过山车
        System.out.println("添加过山车");
        facilities.add(new FerrisWheel());  // 摩天轮
        System.out.println("添加摩天轮");
        facilities.add(new MerryGoRound());  // 旋转木马
        System.out.println("添加旋转木马");

        System.out.println();

        System.out.println("所有设施添加完毕。开始模拟游客访问...");

        // 游客参观游乐场
        Visitor visitor = new GuestVisitor();
        System.out.println("创建游客访问者...");
        for (AmusementFacilityBase facility : facilities) {
            System.out.println("游客正在访问: " + facility.getClass().getSimpleName());
            facility.accept(visitor);
        }

        System.out.println();

        System.out.println("游客体验结束。开始模拟工作人员维护...");

        // 工作人员管理游乐场
        visitor = new MaintenanceVisitor();
        System.out.println("创建维护人员访问者...");
        for (AmusementFacilityBase facility : facilities) {
            System.out.println("维护人员正在检查: " + facility.getClass().getSimpleName());
            facility.accept(visitor);
        }

        System.out.println();

        System.out.println("工作人员维护完成。\n\n访问者模式演示结束。");
        System.out.println("--------------------Visitor Pattern miscellaneous.Test End-------------------");
    }

}
