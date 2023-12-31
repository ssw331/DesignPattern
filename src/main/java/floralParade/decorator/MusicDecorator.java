package floralParade.decorator;

/*
 * @Author XiaoJunLv
 * @Date 2023/12/19
 * */
/* *
 * 装饰器类，添加音乐效果
 */
public class MusicDecorator extends CarDecorator {
    public MusicDecorator(Car decoratedCar) {
        super(decoratedCar);
    }

    @Override
    public void decorate() {
        super.decorate();
        addMusic();
    }

    private void addMusic() {
        System.out.println("*已添加音乐装饰*");
    }
}
