package amusementparkvisit;

import amusementparkvisit.strategy.AmusementParkVisit;
import amusementparkvisit.strategy.MerryGoRoundStrategy;
import amusementparkvisit.strategy.RollerCoasterStrategy;
import amusementparkvisit.strategy.WaterSlideStrategy;

/**
 * @title: StrategyPatternTest
 * @Author Kexian Tang
 * @Date: 2023/12/15
 * @Version 1.0
 */
public class StrategyPatternTest {
    public static void main(String[] args) {
        // 创建游乐园参观上下文，并分配策略
        AmusementParkVisit visit = new AmusementParkVisit(new RollerCoasterStrategy());

        // 体验过山车
        visit.experienceRide();

        // 改变策略，体验旋转木马
        visit.setVisitStrategy(new MerryGoRoundStrategy());
        visit.experienceRide();

        // 改变策略，体验水滑梯
        visit.setVisitStrategy(new WaterSlideStrategy());
        visit.experienceRide();
    }
}
