package decorator;

/*
 * @Author XiaoJunLv
 * @Date 2023/12/19
 * */
/* *
 * 测试类，测试花车装饰的功能
 */
public class DecoratorPatternExample {
    public static void main(String[] args) {
        // 创建基本花车
        Car flowerCar = new FlowerCar();

        // 添加灯光装饰
        Car decoratedCarWithLights = (Car) new LightsDecorator(flowerCar);
        decoratedCarWithLights.decorate();

        System.out.println();

        // 添加音乐装饰
        Car decoratedCarWithMusic = (Car) new MusicDecorator(flowerCar);
        decoratedCarWithMusic.decorate();

        System.out.println();

        // 同时添加灯光和音乐装饰
        Car decoratedCarWithLightsAndMusic = new LightsDecorator(decoratedCarWithMusic);
        decoratedCarWithLightsAndMusic.decorate();
    }
}
