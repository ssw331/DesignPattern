package TourBusStationSubSystem.bridge;

/**
 * Yellow 类实现了 PaintColor 接口，用于提供蓝色主题的观光小火车。
 * 它是桥接模式中的具体实现部分，用于定义观光小火车的颜色属性。
 * 通过实现 PaintColor 接口，Blue 类可以为观光小火车提供统一的颜色配置方法。
 */
public class Yellow implements PaintColor {
    /**
     * 实现 paint 方法，返回蓝色主题的描述。
     * 此方法用于为观光小火车配置蓝色主题。
     *
     * @return 描述蓝色主题的字符串。
     */
    @Override
    public String paint() {
        return "配置为黄色主题";
    }
}
