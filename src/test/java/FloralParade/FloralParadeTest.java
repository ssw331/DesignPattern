package FloralParade;

import Strategy.CarScheduleContext;
import Strategy.HolidaySchedule;
import Strategy.SpecialEventSchedule;
import decorator.Car;
import decorator.FlowerCar;
import decorator.LightsDecorator;
import decorator.MusicDecorator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

public class FloralParadeTest {
    @BeforeEach
    public void beforeEach() {
        System.out.println();
        System.out.println("*****************************【花车巡游子系统】****************************");
        System.out.println();
    }

    /**
     * 测试装饰者模式
     */
    @Test
    @Order(1)
    public void testDecorator(){
        System.out.println("*****************************【装饰者模式展示】****************************");
        System.out.println("# 装饰者模式（Decorator Pattern）允许向一个现有的对象添加新的功能，同时又不改变其结构。");
        System.out.println("# 这种类型的设计模式属于结构型模式，它是作为现有的类的一个包装。");
        System.out.println("# 装饰者模式通过将对象包装在装饰者类中，以便动态地修改其行为。一");
        System.out.println("**********************************************************************");
        System.out.println();

        System.out.println("---------------------------装饰者模式测试开始----------------------------");
        System.out.println("创建基本花车");
        Car flowerCar = new FlowerCar();
        System.out.println("---------------------------------------------------------------------");

        System.out.println("添加灯光装饰");
        Car decoratedCarWithLights = (Car) new LightsDecorator(flowerCar);
        decoratedCarWithLights.decorate();
        System.out.println("---------------------------------------------------------------------");

        System.out.println("添加音乐装饰");
        Car decoratedCarWithMusic = (Car) new MusicDecorator(flowerCar);
        decoratedCarWithMusic.decorate();
        System.out.println("---------------------------------------------------------------------");

        System.out.println("同时添加灯光和音乐装饰");
        Car decoratedCarWithLightsAndMusic = new LightsDecorator(decoratedCarWithMusic);
        decoratedCarWithLightsAndMusic.decorate();
        System.out.println("---------------------------------------------------------------------");

        System.out.println("---------------------------装饰者模式测试结束----------------------------");
    }

    @Test
    @Order(2)
    public void testStrategy(){
        System.out.println("*****************************【策略模式展示】****************************");
        System.out.println("# 策略模式定义了一系列算法或策略，并将每个算法封装在独立的类中，使得它们可以互相替换。");
        System.out.println("# 通过使用策略模式，可以在运行时根据需要选择不同的算法，而不需要修改客户端代码。");
        System.out.println("**********************************************************************");
        System.out.println();

        System.out.println("---------------------------策略模式测试开始----------------------------");
        System.out.println("创建环境类");
        CarScheduleContext context = new CarScheduleContext();
        System.out.println("---------------------------------------------------------------------");

        System.out.println("设置节假日花车巡游策略");
        context.setTimeScheduleStrategy(new HolidaySchedule());
        System.out.println("---------------------------------------------------------------------");

        System.out.println("安排花车时间");
        context.arrangeCarSchedule();
        System.out.println("---------------------------------------------------------------------");

        System.out.println("设置特殊活动花车巡游策略");
        context.setTimeScheduleStrategy(new SpecialEventSchedule());
        System.out.println("---------------------------------------------------------------------");

        System.out.println("安排花车时间");
        context.arrangeCarSchedule();
        System.out.println("---------------------------------------------------------------------");

        System.out.println("---------------------------策略模式测试结束----------------------------");
    }

}
