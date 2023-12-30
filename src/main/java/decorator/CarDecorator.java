package decorator;

/*
 * @Author XiaoJunLv
 * @Date 2023/12/19
 * */
/* *
 * 抽象基类，decoratedCar属性用来接收被装饰的对象
 */
abstract class CarDecorator implements Car {
    protected Car decoratedCar;

    public CarDecorator(Car decoratedCar) {
        this.decoratedCar = decoratedCar;
    }

    public void decorate() {
        decoratedCar.decorate();
    }
}
