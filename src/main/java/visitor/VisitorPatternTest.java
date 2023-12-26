package visitor;

import visitor.*;

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

    public static void main(String[] args) {
        System.out.println("启动游乐园**访问者模式**演示...\n");

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
    }

}
