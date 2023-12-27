package TourBusStationSubSystem.objectPool;

import TourBusStationSubSystem.TourBus;

/**
 * 实现 Runnable 接口的观光车任务类。
 * 用于模拟从对象池中借用观光车，执行任务，然后将其返回的过程。
 */
public class StartTouring implements Runnable {

    // 对象池引用，用于借用和返回观光车。
    private BusPool<TourBus> pool;

    // 线程ID，用于标识不同的任务或游览线路。
    private int threadId;

    /**
     * 构造函数，初始化任务。
     *
     * @param pool 对象池引用
     * @param threadId 线程或游览线路的ID
     */
    public StartTouring(BusPool<TourBus> pool, int threadId) {
        this.pool = pool;
        this.threadId = threadId;
    }

    /**
     * 任务执行的方法。
     * 从对象池中借用一辆观光车，模拟游览活动，然后将车辆返回到对象池。
     */
    @Override
    public void run() {
        // 从池中借用观光车
        TourBus bus = pool.borrowObject();
        // 模拟观光车出发的情景
        // 线程threadId从对象池中借用了编号为bus.getBusId()的观光车
        System.out.printf("游览线路 %d 已启动：编号 %d 的观光车上游客已上车，正前往观光地点。\n", threadId, bus.getBusId());

        // ... 模拟观光过程 ...

        // 将观光车返回到池中
        pool.returnObject(bus);
        // 模拟观光车返回的情景
        // 线程threadId已经完成任务，将bus.getBusId()归还到对象池
        System.out.printf("游览线路 %d 已结束：编号 %d 的观光车已返回，游客已下车，车辆准备迎接下一批游客。\n", threadId, bus.getBusId());
    }
}
