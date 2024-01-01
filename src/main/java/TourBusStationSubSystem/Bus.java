package TourBusStationSubSystem;

/**
 * Bus 接口定义了观光小火车的基本行为。
 * 任何实现了 Bus 接口的类都必须实现 run 和 desc 方法。
 * 这样可以确保所有类型的观光小火车都有统一的行为标准。
 */
public interface Bus {

    /**
     * 启动观光小火车的方法。
     * 当调用此方法时，观光小火车应开始运行。
     */
    void run();

    /**
     * 描述观光小火车的方法。
     * 当调用此方法时，应输出观光小火车的详细信息，如颜色和座位数。
     */
    void desc();
}

