package TourBusStationSubSystem.Decorator;

import TourBusStationSubSystem.Bus;

/**
 * TourGuideBusDecorator 类是一个装饰器，用于给观光车添加讲解员。
 * 通过此装饰器可以为观光车增加额外的功能，而不改变原有车辆的结构。
 */
public class TourGuideBusDecorator extends BusDecorator {

    public TourGuideBusDecorator(Bus decoratedBus) {
        super(decoratedBus);
    }

    private void addTourGuide() {
        System.out.print("配备了讲解员的");
    }

    @Override
    public void run() {
        this.addTourGuide();
        this.decoratedBus.run();
    }

    @Override
    public void desc() {
        System.out.println("配备讲解员的观光车");
    }
}
