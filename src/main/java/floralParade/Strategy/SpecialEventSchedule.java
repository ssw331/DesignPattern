package floralParade.Strategy;

import floralParade.decorator.Car;
import floralParade.decorator.FlowerCar;
import floralParade.decorator.MusicDecorator;

/*
 * @Author XiaoJunLv
 * @Date 2023/12/19
 * */
/* *
 * 具体策略类——特殊活动花车巡游
 */
public class SpecialEventSchedule implements TimeScheduleStrategy {
    @Override
    public void schedule() {
        System.out.println("特殊活动花车巡游");
        Car flowerCar = new FlowerCar();
        Car decoratedCarWithMusic = (Car) new MusicDecorator(flowerCar);
        decoratedCarWithMusic.decorate();
    }
}
