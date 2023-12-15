package amusementparkvisit.strategy;

/**
 * @title: WaterSlideStrategy
 * @Author Kexian Tang
 * @Date: 2023/12/15
 * @Version 1.0
 * @description: 水滑梯游玩策略
 */
public class WaterSlideStrategy implements VisitStrategy {
    @Override
    public void visitMethod() {
        System.out.println("游客选择玩水滑梯进行清凉游玩。");
    }
}
