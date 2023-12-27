package TourBusStationSubSystem.decorator;

import TourBusStationSubSystem.Bus;

/**
 * BusDecorator 是一个抽象类，用作观光车装饰器的基础。
 * 它实现了 Bus 接口，允许动态地向观光车添加新的功能，而不改变其原有的结构和功能。
 * 这个类封装了一个 Bus 类型的对象，并在执行自己的行为之前或之后委托给封装的对象。
 *
 * 所有具体的装饰器类应继承自这个类并覆盖它的方法以添加额外的行为。
 */
public abstract class BusDecorator implements Bus {

    // 被装饰的观光车对象
    protected Bus decoratedBus;

    /**
     * 构造函数，接受一个 Bus 对象作为被装饰的车辆。
     *
     * @param decoratedBus 被装饰的观光车对象。
     */
    public BusDecorator(Bus decoratedBus) {
        this.decoratedBus = decoratedBus;
    }

    /**
     * 运行方法，调用装饰的观光车对象的 run 方法。
     * 子类装饰器可以在调用此方法前后添加额外的行为。
     */
    @Override
    public void run() {
        decoratedBus.run();
    }
}
