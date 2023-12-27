package TourBusStationSubSystem;

import TourBusStationSubSystem.bridge.PaintColor;
import lombok.Data;
import lombok.Getter;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 观光车抽象类，定义了观光车的基本属性和行为。
 * 实现 Cloneable 和 Bus 接口，允许观光车被克隆和运行。
 * 使用原子整数生成唯一的车辆编号，确保每辆车的标识是独特的。
 */
@Data
public abstract class TourBus implements Cloneable, Bus {

    // 用于生成唯一的车辆编号
    private static AtomicInteger curBusNum = new AtomicInteger(0);

    // 观光车类型的数量
    final public static int busClassNum = 3;

    // 观光车的唯一标识
    @Getter
    private int busId;

    // 观光车的名称
    private String name;

    // 观光车的座位数量
    private int seatNum;

    // 观光车的颜色，使用桥接模式中的 PaintColor 接口
    private PaintColor color;

    /**
     * 带颜色参数的构造函数。
     * 使用桥接模式中的 PaintColor 接口设置观光车的颜色。
     *
     * @param color 观光车的颜色
     */
    public TourBus(PaintColor color) {
        this.busId = TourBus.curBusNum.incrementAndGet();
        this.color = color;
    }

    /**
     * 默认构造函数。自动生成观光车的唯一编号，并打印就绪信息。
     * 观光车在创建时会自动分配一个唯一编号。
     */
    public TourBus() {
        this.busId = TourBus.curBusNum.incrementAndGet();
        System.out.println("观光车编号 " + busId + " 已准备就绪。");
    }

    /**
     * 克隆方法，用于创建当前对象的副本。
     * 允许通过克隆现有的观光车实例来创建新的实例。
     *
     * @return 克隆出的新对象
     */
    @Override
    public Object clone() {
        Object clone = null;
        try {
            clone = super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return clone;
    }

    /**
     * 启动观光车，打印出发信息。
     * 当观光车开始运行时，将打印出发信息。
     */
    @Override
    public void run() {
        System.out.println("观光车编号 " + busId + " 开始出发。");
    }

    /**
     * 打印观光车的详细描述，包括颜色、座位数量和编号。
     * 描述包含观光车的颜色、座位数和唯一编号。
     */
    @Override
    public void desc() {
        String busType = switch (seatNum) {
            case 2 -> "小型观光车";
            case 4 -> "中型观光车";
            case 8 -> "大型观光车";
            default -> "未知类型观光车";
        };
        System.out.println(color.paint() + "色的" + busType + "，编号为 " + busId + "。");
    }

}
