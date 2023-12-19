package decorator;

/*
 * @Author XiaoJunLv
 * @Date 2023/12/19
 * */
/* *
 * 装饰器类，添加音乐效果
 */
class MusicDecorator extends CarDecorator {
    public MusicDecorator(Car decoratedCar) {
        super(decoratedCar);
    }

    @Override
    public void decorate() {
        super.decorate();
        addMusic();
    }

    private void addMusic() {
        System.out.println("添加音乐装饰");
    }
}
