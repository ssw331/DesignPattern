package floralParade.Strategy;

import floralParade.decorator.Car;
import floralParade.decorator.FlowerCar;
import floralParade.decorator.LightsDecorator;

/*
 * @Author XiaoJunLv
 * @Date 2023/12/19
 * */
/* *
 * 具体策略类——节假日花车巡游
 */
public class HolidaySchedule implements TimeScheduleStrategy {
    @Override
    public void schedule() {
        System.out.println("节假日花车巡游");
        Car flowerCar = new FlowerCar();
        Car decoratedCarWithLights = (Car) new LightsDecorator(flowerCar);
        decoratedCarWithLights.decorate();
    }
}