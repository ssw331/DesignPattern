package amusementparkvisit;

import amusementparkvisit.mediator.QueueMediator;
import amusementparkvisit.mediator.Ride;
import amusementparkvisit.specification.*;
import amusementparkvisit.strategy.*;
import java.util.Scanner;

public class AmusementParkVisitSceneTest {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("---------------------------------------------------------------------");
        System.out.println("欢迎来到游乐园参观模块场景测试：");
        System.out.println("---------------------------------------------------------------------");

        // 设置游乐设施
        Ride rollerCoaster = new Ride("过山车", 30);
        Ride merryGoRound = new Ride("旋转木马", 15);

        // 显示当前排队情况
        System.out.println("显示当前游乐设施的排队时间：");
        QueueMediator.showQueueMonitorBoard();

        // 更新排队时间
        rollerCoaster.setWaitTime(45);
        merryGoRound.setWaitTime(20);
        QueueMediator.showQueueMonitorBoard();

        // 规约模式：检查游客和员工是否满足规定
        ISpecification<Visitor> ageSpecification = new VisitorAgeSpecification(12, 18);
        ISpecification<Staff> roleSpecification = new StaffRoleSpecification("Security");

        Visitor visitor = new Visitor("小明", 16);
        Staff staff = new Staff("王警官", "Security");

        System.out.println("小明是否符合年龄规定：" + ageSpecification.isSatisfiedBy(visitor));
        System.out.println("王警官是否符合岗位规定：" + roleSpecification.isSatisfiedBy(staff));

        // 策略模式：体验不同的游乐设施
        AmusementParkVisit visit = new AmusementParkVisit(new RollerCoasterStrategy());
        System.out.println("体验过山车：");
        visit.experienceRide();

        System.out.println("更换体验策略为旋转木马：");
        visit.setVisitStrategy(new MerryGoRoundStrategy());
        visit.experienceRide();

        System.out.println("更换体验策略为水滑梯：");
        visit.setVisitStrategy(new WaterSlideStrategy());
        visit.experienceRide();

        System.out.println("---------------------------------------------------------------------");
        System.out.println("游乐园参观模块场景测试结束");
        System.out.println("---------------------------------------------------------------------");

    }
}
