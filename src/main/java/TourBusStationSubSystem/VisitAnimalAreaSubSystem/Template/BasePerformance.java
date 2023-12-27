package TourBusStationSubSystem.VisitAnimalAreaSubSystem.Template;

/**
 * @author Xinyu Fang
 * @version 1.0
 * @title: BasePerformance
 * @description: 演出基类
 */
public abstract class BasePerformance {
    protected String name;
    public void performProcess() throws InterruptedException {
        //动物表演的流程模版
        System.out.println(name + "开始候场");
        Thread.sleep(500);
        System.out.println(name + "登上舞台");
        Thread.sleep(500);
        System.out.println(name + "向观众致意");
        Thread.sleep(500);
        //这里调用perform，展示每个动物的表演内容
        perform();
        Thread.sleep(500);
        System.out.println(name + "向观众告别");
        Thread.sleep(500);
        System.out.println(name + "退场");
        System.out.println("--------------------让我们期待下一场演出--------------------");
    }
    //子类通过继承来自定义表演内容，增加了代码的可拓展性
    public abstract void perform();
}
