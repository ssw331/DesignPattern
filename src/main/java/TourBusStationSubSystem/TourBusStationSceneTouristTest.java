package TourBusStationSubSystem;

import TourBusStationSubSystem.bridge.Blue;
import TourBusStationSubSystem.bridge.PaintColor;
import TourBusStationSubSystem.bridge.Pink;
import TourBusStationSubSystem.bridge.Yellow;
import TourBusStationSubSystem.decorator.TourGuideBusDecorator;
import TourBusStationSubSystem.prototype.BusCache;

import java.util.Scanner;

public class TourBusStationSceneTouristTest {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("欢迎来到观光小火车站子系统～");
        System.out.println("在本子系统中，你可以乘坐观光小火车对整个游乐场进行游览");
        System.out.println("游乐场正在准备观光小火车...");
        BusCache.loadCache();
        System.out.println(" ");

        System.out.println(
                """
                游乐场准备了三种类型的观光小火车，如下：
                1.小型观光小火车（2人座）
                2.中型观光小火车（4人座）
                3.大型观光小火车（8人座）
                4.退出
                """
        );
        String choice;

        // 选择车型（原型模式）
        Bus bus = null;
        while (bus == null) {
            System.out.println("请输入您选择的车型：");
            choice = scanner.nextLine();
            while (choice.isEmpty()) {
                choice = scanner.nextLine();
            }
            switch (choice.charAt(0)) {
                case '1' -> bus = BusCache.getBus("小型观光小火车");
                case '2' -> bus = BusCache.getBus("中型观光小火车");
                case '3' -> bus = BusCache.getBus("大型观光小火车");
                case '4' -> {
                    return;
                }
                default -> System.out.println("输入错误，请重新输入");
            }
        }

        // 选择颜色（桥接模式）
        PaintColor color = null;
        System.out.println(
                """
                每种类型的观光小火车都有不同的颜色可选，如下：
                1.蓝色 Blue
                2.粉色 Pink
                3.黄色 Yellow
                4.退出
                """
        );

        while (color == null) {
            System.out.println("请选择观光小火车的颜色：");
            choice = scanner.nextLine();
            while (choice.isEmpty()) {
                choice = scanner.nextLine();
            }
            switch (choice.charAt(0)) {
                case '1' -> color = new Blue();
                case '2' -> color = new Pink();
                case '3' -> color = new Yellow();
                case '4' -> {
                    return;
                }
                default -> System.out.println("输入错误，请重新输入");
            }
        }
        System.out.println("观光小火车" + color.paint());
        ((TourBus) bus).setColor(color);
        bus.desc();

        // 添加人工讲解（装饰器模式）
        System.out.println("是否需要增加讲解员以提升体验？");
        System.out.println(
                """
                1.是
                2.否
                """
        );
        System.out.println("请选择：");
        choice = scanner.nextLine();
        while (choice.isEmpty() || choice.charAt(0) != '1' && choice.charAt(0) != '2') {
            System.out.println("输入错误，请重新输入");
            choice = scanner.nextLine();
        }
        if (choice.charAt(0) != '2') {
            bus = new TourGuideBusDecorator(bus);
        }
        bus.run();

    }
}
