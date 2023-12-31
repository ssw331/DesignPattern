package amusementparkvisit.strategy;

/**
 * @title: RollerCoasterStrategy
 * @Author Kexian Tang
 * @Date: 2023/12/15
 * @Version 1.0
 * @description: 过山车游玩策略
 */
public class RollerCoasterStrategy implements VisitStrategy {
    @Override
    public void visitMethod() {
        System.out.println("游客选择乘坐过山车进行惊险游玩。");
    }
}
