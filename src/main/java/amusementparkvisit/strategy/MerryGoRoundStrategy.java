package amusementparkvisit.strategy;

/**
 * @title: MerryGoRoundStrategy
 * @Author Kexian Tang
 * @Date: 2023/12/15
 * @Version 1.0
 * @description: 旋转木马游玩策略
 */
public class MerryGoRoundStrategy implements VisitStrategy {
    @Override
    public void visitMethod() {
        System.out.println("游客选择乘坐旋转木马进行温馨游玩。");
    }
}
