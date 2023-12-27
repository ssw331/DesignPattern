package TourBusStationSubSystem.objectPool;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 泛型类 BusPool，实现观光车对象池。
 * 对象池用于管理一组可重用的对象实例。
 *
 * @param <T> 对象池管理的对象类型
 */
public abstract class BusPool<T> {

    // 线程安全的队列，用于存储池中的对象。
    private ConcurrentLinkedQueue<T> pool;

    // 用于执行定时任务的线程池。
    private ScheduledExecutorService executorService;


    /**
     * 构造函数初始化对象池，并设置定时任务以维护池的大小。
     *
     * @param minObjects 池中的最小对象数量
     * @param maxObjects 池中的最大对象数量
     * @param delay 定时任务的执行间隔（秒）
     */
    public BusPool(final int minObjects, final int maxObjects, final long delay) {
        this.initialize(minObjects);
        executorService = Executors.newSingleThreadScheduledExecutor();

        // 设置定时任务，用于定期调整池的大小。
        executorService.scheduleWithFixedDelay(() -> {
            int size = pool.size();
            if (size < minObjects) {
                // 如果池中的对象少于最小值，则添加新对象。
                int sizeToBeAdded = minObjects - size;
                for (int i = 0; i < sizeToBeAdded; i++) {
                    pool.add(createObject());
                }
            } else if (size > maxObjects) {
                // 如果池中的对象多于最大值，则移除多余的对象。
                int sizeToBeRemoved = size - maxObjects;
                for (int i = 0; i < sizeToBeRemoved; i++) {
                    pool.poll();
                }
            }
        }, delay, delay, TimeUnit.SECONDS);
    }

    /**
     * 初始化对象池，填充到最小对象数量。
     *
     * @param minObjects 池中的最小对象数量
     */
    private void initialize(final int minObjects) {
        this.pool = new ConcurrentLinkedQueue<>();
        for (int i = 0; i < minObjects; i++) {
            this.pool.add(this.createObject());
        }
    }

    /**
     * 关闭对象池，释放资源。
     */
    public void shutdown() {
        if (executorService != null) {
            executorService.shutdown();
        }
    }
    /**
     * 从对象池中借用对象。
     * 如果池中没有可用对象，则创建一个新对象。
     *
     * @return 池中的一个对象或一个新创建的对象
     */
    public T borrowObject() {
        T object;
        if ((object = pool.poll()) == null) {
            object = createObject();
        }
        return object;
    }

    /**
     * 将对象返回到池中。
     *
     * @param object 要返回到池中的对象
     */
    public void returnObject(T object) {
        if (object == null) {
            return;
        }
        this.pool.offer(object);
    }
    /**
     * 创建一个新对象的抽象方法。
     * 子类需要重写此方法以提供对象的创建逻辑。
     *
     * @return 新创建的对象
     */
    protected abstract T createObject();
}
