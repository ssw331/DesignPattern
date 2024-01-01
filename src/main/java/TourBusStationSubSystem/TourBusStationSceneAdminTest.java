package TourBusStationSubSystem;

import TourBusStationSubSystem.filter.*;
import TourBusStationSubSystem.objectPool.BusPool;
import TourBusStationSubSystem.objectPool.StartTouring;
import TourBusStationSubSystem.prototype.LargeTourBus;
import TourBusStationSubSystem.prototype.MediumTourBus;
import TourBusStationSubSystem.prototype.SmallTourBus;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * MuiltVisitorScene 类模拟了多个游客同时租赁观光车的场景。
 * 该类展示了如何使用对象池模式来管理观光车的分配，以及过滤器模式来筛选特定类型的观光车。
 */
public class TourBusStationSceneAdminTest {

    public static void main(String[] args) {
        System.out.println("观光车站今日迎来众多游客，需求量较高。");

        int totalBusNum = 6; // 总共需要的观光车数量
        System.out.println("共有 " + totalBusNum + " 位游客，他们将租赁观光车进行旅游。");
        System.out.println("---------------------------------------------------------------------");

        // 初始化观光车对象池
        System.out.println("初始化观光车对象池...");

        int minObject = 4, maxObject = 8, delay = 5; // 对象池的最小和最大数量及调整延时

        BusPool<TourBus> busPool = new BusPool<>(minObject, maxObject, delay) {
            @Override
            protected TourBus createObject() {
                // 随机选择一种类型的观光车
                return switch (new Random().nextInt(TourBus.busClassNum)) {
                    case 0 -> new SmallTourBus();
                    case 1 -> new MediumTourBus();
                    case 2 -> new LargeTourBus();
                    default -> throw new IllegalStateException("Unexpected value");
                };
            }
        };
        System.out.println("---------------------------------------------------------------------");

        ExecutorService executor = Executors.newFixedThreadPool(totalBusNum);
        System.out.println("分配线程执行租赁任务...");
        for (int i = 1; i <= totalBusNum; i++) {
            StartTouring task = new StartTouring(busPool, i);
            executor.execute(task);
        }

        executor.shutdown();

        try {
            executor.awaitTermination(30, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("---------------------------------------------------------------------");

        // 使用过滤器模式寻找特定类型的观光车
        System.out.println("现在检查对象池中的观光车情况...");

        List<TourBus> buses = new ArrayList<>();
        for (int i = 0; i < totalBusNum; i++) {
            buses.add(busPool.borrowObject());
        }

        System.out.println("寻找座位数量为中等的观光车...");
        System.out.println("筛选出座位数介于 4 至 8 之间的中型观光车：");
        Criteria and = new AndCriteria(new BusSeatLessThanFilter(8+1), new BusSeatMoreThanFilter(4-1));
        for (TourBus bus: and.meetCriteria(buses)) {
            System.out.println("编号为 " + bus.getBusId() + " 的观光车是 " + bus.getName());
        }

        // 关闭对象池
        busPool.shutdown();
    }
}
