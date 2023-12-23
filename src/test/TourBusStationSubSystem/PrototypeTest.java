package TourBusStationSubSystem;

import TourBusStationSubSystem.Prototype.BusCache;
import org.testng.annotations.Test;

/**
 * PrototypeTest 类用于演示和测试原型模式在观光车制造中的应用。
 * 该类展示了如何使用原型模式创建不同类型的观光车实例。
 */
public class PrototypeTest {

    /**
     * 测试原型模式在创建观光车实例中的应用。
     * 展示了通过原型模式创建小型、中型和大型观光车的过程。
     */
    @Test
    public void prototypeTest() {
        System.out.println("***********************************【原型模式展示】***********************************");
        System.out.println("# 原型模式是一种创建型设计模式，它通过复制现有对象生成新对象，减少了代码对类的直接依赖。");
        System.out.println("# 原型模式的优势包括：");
        System.out.println("1. 简化复杂对象的创建过程，提高创建效率。");
        System.out.println("2. 增强系统的扩展性，通过抽象原型类添加新的产品类时，无需修改原有系统。");
        System.out.println("3. 提供简化的创建结构。");
        System.out.println("4. 可以通过深克隆保存对象状态，辅助实现撤销操作。");
        System.out.println("*******************************************************************************");
        System.out.println("----------------------Prototype Design Pattern Test Start--------------------");
        System.out.println("游乐园即将准备三种类型的观光车：小型、中型和大型。");

        System.out.println("开始准备观光车...");
        BusCache.loadCache();
        // 观光车哈希表准备就绪
        System.out.println("观光车准备就绪，即将投入使用。");
        BusCache.showCache();

        System.out.println("-------------------------------------------------------------------------------");
        System.out.println("一队游客请求租用一辆中型观光车。");
        TourBus mediumBus = BusCache.getBus("中型观光车");
        System.out.printf("中型观光车，车辆编号：%d，座位数：%d，已准备就绪。\n", mediumBus.getBusId(), mediumBus.getSeatNum());
        mediumBus.run();

        System.out.println("-------------------------------------------------------------------------------");
        System.out.println("一队游客请求租用一辆大型观光车。");
        TourBus largeBus = BusCache.getBus("大型观光车");
        System.out.printf("大型观光车，车辆编号：%d，座位数：%d，已准备就绪。\n", largeBus.getBusId(), largeBus.getSeatNum());
        largeBus.run();

        System.out.println("-------------------------------------------------------------------------------");
        System.out.println("另一队游客再次请求租用一辆大型观光车。");
        TourBus anotherLargeBus = BusCache.getBus("大型观光车");
        System.out.printf("另一辆大型观光车，车辆编号：%d，座位数：%d，已准备就绪。\n", anotherLargeBus.getBusId(), anotherLargeBus.getSeatNum());
        largeBus.run();

        System.out.println("这两辆大型观光车是否为同一辆？ " + (largeBus == anotherLargeBus));
        System.out.println("----------------------Prototype Design Pattern Test End--------------------");
    }
}
