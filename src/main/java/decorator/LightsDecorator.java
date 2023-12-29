package decorator;

/*
 * @Author XiaoJunLv
 * @Date 2023/12/19
 * */
/* *
 * 装饰器类，添加灯光效果
 */
public class LightsDecorator extends CarDecorator {
    public LightsDecorator(Car decoratedCar) {
        super(decoratedCar);
    }

    @Override
    public void decorate() {
        super.decorate();
        addLights();
    }

    private void addLights() {
        System.out.println("*已添加灯光装饰*");
    }
}
