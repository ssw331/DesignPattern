package TourBusStationSubSystem.prototype;

import TourBusStationSubSystem.bridge.PaintColor;
import TourBusStationSubSystem.TourBus;

/**
 * LargeTourBus 类表示大型观光小火车。
 * 它继承自 TourBus 类，并提供额外的功能，比如支持更多乘客。
 * 使用桥接模式允许独立地设置车辆的颜色。
 */
public class LargeTourBus extends TourBus {

    /**
     * 使用指定的颜色创建一个大型观光小火车。
     *
     * @param color 实现 PaintColor 接口的对象，表示车辆的颜色。
     */
    public LargeTourBus(PaintColor color) {
        super(color);
        this.setSeatNum(8); // 设置座位数为 8
    }

    /**
     * 默认构造函数创建一个无特定颜色的大型观光小火车。
     * 设置默认名称为“大型观光小火车”，座位数为8。
     */
    public LargeTourBus() {
        super();
        this.setName("大型观光小火车");
        this.setSeatNum(8);
    }
}
