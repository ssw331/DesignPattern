package TourBusStationSubSystem;
import TourBusStationSubSystem.bridge.Blue;
import TourBusStationSubSystem.bridge.Pink;
import TourBusStationSubSystem.bridge.Yellow;
import TourBusStationSubSystem.decorator.BusDecorator;
import TourBusStationSubSystem.decorator.TourGuideBusDecorator;
import TourBusStationSubSystem.filter.*;
import TourBusStationSubSystem.objectPool.BusPool;
import TourBusStationSubSystem.objectPool.StartTouring;
import TourBusStationSubSystem.prototype.BusCache;
import TourBusStationSubSystem.prototype.LargeTourBus;
import TourBusStationSubSystem.prototype.MediumTourBus;
import TourBusStationSubSystem.prototype.SmallTourBus;


import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class TourBusStationTest {

    @BeforeEach
    public void beforeEach() {
        System.out.println();
        System.out.println("*****************************【观光小火车站子系统】****************************");
        System.out.println();
    }

    /**
     * 测试桥接模式
     */
    @Test
    @Order(1)
    public void testBridge(){
        System.out.println("*****************************【桥接模式展示】****************************");
        System.out.println("# 桥接模式允许将抽象部分与实现部分分离，使它们都可以独立地变化。");
        System.out.println("# 本系统中，抽象部分为车辆的类型，实现部分为车辆的颜色。");
        System.out.println("# 通过桥接模式，车辆类型和颜色可以独立变化，增加了系统的灵活性。");
        System.out.println("**********************************************************************");
        System.out.println("---------------------------桥接模式测试开始----------------------------");
        System.out.println("创建不同颜色和大小的观光小火车实例：");
        System.out.println("---------------------------------------------------------------------");

        // 创建小型黄色观光小火车
        TourBus smallYellowBus = new SmallTourBus(new Yellow());
        System.out.println("创建了一辆小型黄色观光小火车：");
        smallYellowBus.desc();
        System.out.println("---------------------------------------------------------------------");

        // 创建大型粉色观光小火车
        TourBus largePinkBus = new LargeTourBus(new Pink());
        System.out.println("创建了一辆大型粉色观光小火车：");
        largePinkBus.desc();
        System.out.println("---------------------------------------------------------------------");

        // 创建中型蓝色观光小火车
        TourBus mediumBlueBus = new MediumTourBus(new Blue());
        System.out.println("创建了一辆中型蓝色观光小火车：");
        mediumBlueBus.desc();

        System.out.println("---------------------------桥接模式测试结束----------------------------");

    }

    /**
     * 测试装饰器模式
     */
    @Test
    @Order(2)
    public void testDecorator() {
        System.out.println("*****************************【装饰器模式展示】****************************");
        System.out.println("# 装饰器模式允许动态地给对象添加额外的职责，增加功能比生成子类更灵活。");
        System.out.println("# 在本系统中，可以通过装饰器模式为观光小火车添加讲解员，增强游客体验。");
        System.out.println("**********************************************************************");
        System.out.println("---------------------------装饰器模式测试开始----------------------------");

        System.out.println("准备一辆中型观光小火车");
        TourBus bus = new MediumTourBus();
        System.out.println(bus.getName() + "已准备就绪");

        System.out.println("启动四人观光小火车");
        bus.run();

        System.out.println("---------------------------------------------------------------------");
        System.out.println("为了提升游客体验，准备给观光小火车增加讲解员");
        BusDecorator tourGuideBus = new TourGuideBusDecorator(bus);
        tourGuideBus.run();

        System.out.println("---------------------------装饰器模式测试结束----------------------------");
    }

    /**
     * 测试过滤器模式
     */
    @Test
    @Order(3)
    public void testFilter() {
        System.out.println("*****************************【过滤器模式展示】****************************");
        System.out.println("# 过滤器模式允许通过定义标准对对象集合进行过滤，得到符合条件的对象。");
        System.out.println("# 本系统中，使用过滤器模式对观光小火车进行过滤，以筛选出符合不同条件的观光小火车。");
        System.out.println("**********************************************************************");
        System.out.println("---------------------------过滤器模式测试开始----------------------------");

        List<TourBus> buses = new ArrayList<>();
        System.out.println("添加一辆大型观光小火车，有 8 个座位");
        buses.add(new LargeTourBus());
        System.out.println("添加一辆小型观光小火车，有 2 个座位");
        buses.add(new SmallTourBus());
        System.out.println("再添加两辆大型观光小火车");
        buses.add(new LargeTourBus());
        buses.add(new LargeTourBus());
        System.out.println("添加一辆中型观光小火车，有 4 个座位");
        buses.add(new MediumTourBus());
        System.out.println("再添加一辆小型观光小火车，有 2 个座位");
        buses.add(new SmallTourBus());

        System.out.println("当前观光小火车总览");
        printBusesInfo(buses);
        System.out.println("---------------------------------------------------------------------");

        System.out.println("过滤座位数小于5的观光小火车");
        Criteria seatNoLessThan5 = new BusSeatLessThanFilter(5);
        printBusesInfo(seatNoLessThan5.meetCriteria(buses));

        System.out.println("过滤座位数大于2的观光小火车");
        Criteria seatNoMoreThan2 = new BusSeatMoreThanFilter(2);
        printBusesInfo(seatNoMoreThan2.meetCriteria(buses));

        System.out.println("过滤座位数小于 4 或大于 4 的观光小火车");
        Criteria andCriteria = new AndCriteria(new BusSeatLessThanFilter(4), new BusSeatMoreThanFilter(4));
        printBusesInfo(andCriteria.meetCriteria(buses));

        System.out.println("过滤座位数小于 8 或大于 2 的观光小火车");
        Criteria orCriteria = new OrCriteria(new BusSeatLessThanFilter(8), new BusSeatMoreThanFilter(2));
        printBusesInfo(orCriteria.meetCriteria(buses));

        System.out.println("---------------------------过滤器模式测试结束----------------------------");
    }
    private void printBusesInfo(List<TourBus> buses) {
        if (buses.isEmpty()) {
            System.out.println("没有符合条件的观光小火车");
            return;
        }
        for (TourBus bus : buses) {
            System.out.println("编号：" + bus.getBusId() + "，座位数：" + bus.getSeatNum());
        }
    }

    /**
     * 测试对象池模式
     */
    @Test
    @Order(4)
    public void testObjectPool() {
        System.out.println("***********************************【对象池模式展示】***********************************");
        System.out.println("# 对象池模式是一种创建型设计模式，它能够允许你重用现有的同类对象，而无需重新创建它们。");
        System.out.println("# 对象池模式可以降低资源消耗，提高性能。");
        System.out.println("*******************************************************************************");
        System.out.println("---------------------------对象池模式测试开始----------------------------");

        // 初始化对象池
        BusPool<TourBus> pool = new BusPool<>(5, 10, 5) {
            @Override
            protected TourBus createObject() {
                Random random = new Random();
                int c = random.nextInt(TourBus.busClassNum);
                return switch (c) {
                    case 0 -> new SmallTourBus();
                    case 1 -> new MediumTourBus();
                    case 2 -> new LargeTourBus();
                    default -> throw new IllegalStateException("Unexpected value: " + c);
                };
            }
        };

        // 测试对象池并发使用
        int threadNum = 6;
        ExecutorService executor = Executors.newFixedThreadPool(threadNum);
        for (int i = 1; i <= threadNum; i++) {
            executor.execute(new StartTouring(pool, i));
        }
        executor.shutdown();
        try {
            if (!executor.awaitTermination(30, TimeUnit.SECONDS)) {
                // 超时后尝试停止所有正在执行的任务
                executor.shutdownNow();
                if (!executor.awaitTermination(30, TimeUnit.SECONDS)) {
                    System.err.println("线程池没有完全终止");
                }
            }
        } catch (InterruptedException e) {
            // 如果等待过程中线程被中断，再次尝试立即停止所有任务
            executor.shutdownNow();
            // 重置中断状态
            Thread.currentThread().interrupt();
            System.err.println("等待线程池终止时被中断");
        }

        // 清理资源，关闭对象池
        pool.shutdown();

        System.out.println("---------------------------对象池模式测试结束----------------------------");
    }

    /**
     * 测试原型模式
     */
    @Test
    @Order(5)
    public void testPrototype() {
        System.out.println("***********************************【原型模式展示】***********************************");
        System.out.println("# 原型模式是一种创建型设计模式，它通过复制现有对象生成新对象，减少了代码对类的直接依赖。");
        System.out.println("# 原型模式的优势包括：");
        System.out.println("1. 简化复杂对象的创建过程，提高创建效率。");
        System.out.println("2. 增强系统的扩展性，通过抽象原型类添加新的产品类时，无需修改原有系统。");
        System.out.println("3. 提供简化的创建结构。");
        System.out.println("4. 可以通过深克隆保存对象状态，辅助实现撤销操作。");
        System.out.println("*******************************************************************************");
        System.out.println("-----------------------------原型模式测试开始------------------------------");
        System.out.println("游乐园即将准备三种类型的观光小火车：小型、中型和大型。");

        System.out.println("开始准备观光小火车...");
        BusCache.loadCache();
        // 观光小火车哈希表准备就绪
        System.out.println("观光小火车准备就绪，即将投入使用。");
        BusCache.showCache();

        System.out.println("-------------------------------------------------------------------------------");
        System.out.println("一队游客请求租用一辆中型观光小火车。");
        TourBus mediumBus = BusCache.getBus("中型观光小火车");
        System.out.printf("中型观光小火车，车辆编号：%d，座位数：%d，已准备就绪。\n", mediumBus.getBusId(), mediumBus.getSeatNum());
        mediumBus.run();

        System.out.println("-------------------------------------------------------------------------------");
        System.out.println("一队游客请求租用一辆大型观光小火车。");
        TourBus largeBus = BusCache.getBus("大型观光小火车");
        System.out.printf("大型观光小火车，车辆编号：%d，座位数：%d，已准备就绪。\n", largeBus.getBusId(), largeBus.getSeatNum());
        largeBus.run();

        System.out.println("-------------------------------------------------------------------------------");
        System.out.println("另一队游客再次请求租用一辆大型观光小火车。");
        TourBus anotherLargeBus = BusCache.getBus("大型观光小火车");
        System.out.printf("另一辆大型观光小火车，车辆编号：%d，座位数：%d，已准备就绪。\n", anotherLargeBus.getBusId(), anotherLargeBus.getSeatNum());
        largeBus.run();

        System.out.println("这两辆大型观光小火车是否为同一辆？ " + (largeBus == anotherLargeBus));
        System.out.println("-----------------------------原型模式测试结束------------------------------");

    }

}
