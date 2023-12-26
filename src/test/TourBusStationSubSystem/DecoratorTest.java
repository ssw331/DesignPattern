package TourBusStationSubSystem;

import TourBusStationSubSystem.Decorator.BusDecorator;
import TourBusStationSubSystem.Decorator.TourGuideBusDecorator;
import TourBusStationSubSystem.Prototype.MediumTourBus;
import org.testng.annotations.Test;

/**
 * DecoratorTest 类用于演示装饰器模式在观光车系统中的应用。
 * 测试展示了如何动态地为观光车增加额外的功能（如添加讲解员）。
 */
public class DecoratorTest {

    @Test
    public void decoratorTest() {
        System.out.println("*****************************【装饰器模式展示】****************************");
        System.out.println("# 装饰器模式允许动态地给对象添加额外的职责，增加功能比生成子类更灵活。");
        System.out.println("# 在本系统中，可以通过装饰器模式为观光车添加讲解员，增强游客体验。");
        System.out.println("**********************************************************************");
        System.out.println("---------------------------装饰器模式测试开始----------------------------");

        System.out.println("准备一辆中型观光车");
        TourBus bus = new MediumTourBus();
        System.out.println(bus.getName() + "已准备就绪");

        System.out.println("启动四人观光车");
        bus.run();

        System.out.println("---------------------------------------------------------------------");
        System.out.println("为了提升游客体验，准备给观光车增加讲解员");
        BusDecorator tourGuideBus = new TourGuideBusDecorator(bus);
        tourGuideBus.run();

        System.out.println("--------------------Decorator Pattern Test End-----------------------");
    }
}
