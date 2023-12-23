package TourBusStationSubSystem;

import TourBusStationSubSystem.Bridge.Blue;
import TourBusStationSubSystem.Bridge.Pink;
import TourBusStationSubSystem.Bridge.Yellow;
import TourBusStationSubSystem.Prototype.LargeTourBus;
import TourBusStationSubSystem.Prototype.MediumTourBus;
import TourBusStationSubSystem.Prototype.SmallTourBus;
import org.testng.annotations.Test;

/**
 * BridgeTest 类用于演示桥接模式在观光车系统中的应用。
 * 该测试展示了如何通过桥接模式将观光车的类型和颜色解耦，允许它们独立变化。
 */
public class BridgeTest {

    @Test
    public void bridgeTest() {
        System.out.println("*****************************【桥接模式展示】****************************");
        System.out.println("# 桥接模式允许将抽象部分与实现部分分离，使它们都可以独立地变化。");
        System.out.println("# 本系统中，抽象部分为车辆的类型，实现部分为车辆的颜色。");
        System.out.println("# 通过桥接模式，车辆类型和颜色可以独立变化，增加了系统的灵活性。");
        System.out.println("**********************************************************************");
        System.out.println("---------------------------桥接模式测试开始----------------------------");
        System.out.println("创建不同颜色和大小的观光车实例：");
        System.out.println("---------------------------------------------------------------------");

        // 创建小型黄色观光车
        TourBus smallYellowBus = new SmallTourBus(new Yellow());
        System.out.println("创建了一辆小型黄色观光车：");
        smallYellowBus.desc();
        System.out.println("---------------------------------------------------------------------");

        // 创建大型粉色观光车
        TourBus largePinkBus = new LargeTourBus(new Pink());
        System.out.println("创建了一辆大型粉色观光车：");
        largePinkBus.desc();
        System.out.println("---------------------------------------------------------------------");

        // 创建中型蓝色观光车
        TourBus mediumBlueBus = new MediumTourBus(new Blue());
        System.out.println("创建了一辆中型蓝色观光车：");
        mediumBlueBus.desc();

        System.out.println("---------------------------桥接模式测试结束----------------------------");
    }
}
