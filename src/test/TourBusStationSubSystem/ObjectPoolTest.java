package TourBusStationSubSystem;

import TourBusStationSubSystem.ObjectPool.BusPool;
import TourBusStationSubSystem.ObjectPool.StartSightseeing;
import TourBusStationSubSystem.Prototype.LargeTourBus;
import TourBusStationSubSystem.Prototype.MediumTourBus;
import TourBusStationSubSystem.Prototype.SmallTourBus;
import org.testng.annotations.Test;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 对象池模式的测试类。
 * 用于测试观光车对象池的工作效率和性能。
 */
public class ObjectPoolTest {

    // 对象池实例
    private BusPool<TourBus> pool;

    /**
     * 初始化对象池。
     * 根据定义的最小和最大对象数，以及检查间隔来初始化对象池。
     */
    public void init() {
        this.pool = new BusPool<>(10, 20, 5) {
            @Override
            protected TourBus createObject() {
                // 随机创建一个观光车对象
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
    }

    /**
     * 测试对象池的并发使用。
     * 创建多个线程来模拟并发条件下对象池的使用情况。
     */
    public void busPoolTest() {
        int threadNum = 15;
        // 创建固定数量的线程池
        ExecutorService executor = Executors.newFixedThreadPool(threadNum);

        // 提交多个任务到线程池
        for (int i = 1; i <= threadNum; i++) {
            executor.execute(new StartSightseeing(pool, i));
        }

        // 关闭线程池并等待所有任务完成
        executor.shutdown();
        try {
            executor.awaitTermination(30, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    /**
     * 清理资源，关闭对象池。
     */
    public void tearDown() {
        pool.shutdown();
    }

    /**
     * 对象池模式的单元测试方法。
     * 初始化对象池，执行测试任务，然后关闭对象池。
     */
    @Test
    public void objectPoolTest() {
        System.out.println("***********************************【对象池模式展示】***********************************");
        System.out.println("# 对象池模式是一种创建型设计模式，它能够允许你重用现有的同类对象，而无需重新创建它们。");
        System.out.println("# 对象池模式可以降低资源消耗，提高性能。");
        System.out.println("*******************************************************************************");
        System.out.println("----------------------Object Pool Design Pattern Test Start--------------------");

        // 创建测试实例并运行测试
        ObjectPoolTest test = new ObjectPoolTest();
        test.init();
        test.busPoolTest();
        test.tearDown();

        System.out.println("----------------------Object Pool Design Pattern Test End--------------------");
    }
}
