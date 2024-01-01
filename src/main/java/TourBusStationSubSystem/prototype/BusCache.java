package TourBusStationSubSystem.prototype;

import TourBusStationSubSystem.TourBus;

import java.util.Hashtable;

/**
 * BusCache 类用于缓存和管理观光小火车的实例。
 * 它存储了不同类型的观光小火车原型，并允许通过原型模式快速创建新的观光小火车实例。
 */
public class BusCache {

    // 用于存储观光小火车原型的哈希表
    private static Hashtable<String, TourBus> busMap = new Hashtable<>();

    /**
     * 根据观光小火车名称获取观光小火车的克隆实例。
     *
     * @param busName 观光小火车的名称
     * @return 克隆出的观光小火车实例
     */
    public static TourBus getBus(String busName) {
        TourBus cacheBus = busMap.get(busName);
        return (TourBus) cacheBus.clone();
    }

    /**
     * 加载并初始化观光小火车原型到缓存中。
     * 此方法初始化不同类型的观光小火车并将它们放入缓存。
     */
    public static void loadCache() {
        SmallTourBus smallBus = new SmallTourBus();
        busMap.put(smallBus.getName(), smallBus);

        MediumTourBus mediumBus = new MediumTourBus();
        busMap.put(mediumBus.getName(), mediumBus);

        LargeTourBus largeBus = new LargeTourBus();
        busMap.put(largeBus.getName(), largeBus);
    }

    /**
     * 显示当前缓存中的观光小火车类型。
     * 打印出缓存中的所有观光小火车名称。
     */
    public static void showCache() {
        System.out.println("当前准备的观光小火车类型：" + busMap.keySet());
    }
}
