package floralParade.decorator;

/*
 * @Author XiaoJunLv
 * @Date 2023/12/19
 * */
/* *
 * 原始对象，此处为基本花车巡游
 */
public class FlowerCar implements Car{
    @Override
    public void decorate() {
        System.out.println("基本花车巡游");
    }
}
