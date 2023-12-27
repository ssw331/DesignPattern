package TourBusStationSubSystem.prototype;

import TourBusStationSubSystem.bridge.PaintColor;
import TourBusStationSubSystem.TourBus;

/**
 * 这个类表示小型观光车，继承自 TourBus 类。
 * 它使用原型模式，方便创建相同类型的观光车实例。
 * 同时，通过桥接模式，它可以与 PaintColor 接口合作，以支持不同的颜色。
 */
public class SmallTourBus extends TourBus {

    /**
     * 使用指定的颜色构造一个小型观光车。
     *
     * @param color 实现 PaintColor 接口的对象，表示观光车的颜色。
     */
    public SmallTourBus(PaintColor color) {
        super(color);
        this.setSeatNum(2); // 设置座位数为2
    }

    /**
     * 默认构造函数创建一个无特定颜色的小型观光车。
     * 设置默认名称为“小型观光车”，座位数为2。
     */
    public SmallTourBus() {
        super();
        this.setName("小型观光车");
        this.setSeatNum(2);
    }
}
