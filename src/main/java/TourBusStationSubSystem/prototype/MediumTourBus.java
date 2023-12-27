package TourBusStationSubSystem.prototype;

import TourBusStationSubSystem.bridge.Stylized;
import TourBusStationSubSystem.TourBus;

/**
 * MediumTourBus 类表示中型观光车。
 * 它继承自 TourBus 类，提供了一种中等大小的观光车选项。
 * 该类使用桥接模式来设置车辆的颜色，从而实现了颜色和车辆类型的解耦。
 */
public class MediumTourBus extends TourBus {

    /**
     * 使用指定的颜色创建一个中型观光车。
     *
     * @param color 实现 Stylized 接口的对象，用于设置车辆的颜色。
     */
    public MediumTourBus(Stylized color) {
        super(color);
        this.setSeatNum(4); // 设置座位数为4
    }

    /**
     * 默认构造函数创建一个无特定颜色的中型观光车。
     * 设置默认名称为“中型观光车”，座位数为4。
     */
    public MediumTourBus() {
        super();
        this.setName("中型观光车");
        this.setSeatNum(4);
    }
}
