package amusementparkvisit.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import amusementparkvisit.mediator.QueueMediator;
import amusementparkvisit.mediator.Ride;
import amusementparkvisit.specification.*;
import amusementparkvisit.strategy.*;

public class AmusementParkVisitTest {

    private Ride rollerCoaster, merryGoRound;
    private Visitor youngVisitor;
    private Staff securityStaff;
    private AmusementParkVisit visit;

    @BeforeEach
    public void setUp() {
        System.out.println("\n*****************************【游乐园参观模块综合测试】****************************\n");

        // 初始化中介者模式相关的对象
        rollerCoaster = new Ride("过山车", 30);
        merryGoRound = new Ride("旋转木马", 15);

        // 初始化规约模式相关的对象
        youngVisitor = new Visitor("小明", 16);
        securityStaff = new Staff("王警官", "Security");

        // 初始化策略模式相关的对象
        visit = new AmusementParkVisit(new RollerCoasterStrategy());
    }

    @Test
    public void testMediatorPattern() {
        System.out.println("*****************************【中介者模式测试】****************************");

        QueueMediator.showQueueMonitorBoard();
        rollerCoaster.setWaitTime(45);
        merryGoRound.setWaitTime(20);
        QueueMediator.showQueueMonitorBoard();

        System.out.println("---------------------------------------------------------------------\n");
    }

    @Test
    public void testSpecificationPattern() {
        System.out.println("*****************************【规约模式测试】****************************");

        ISpecification<Visitor> ageSpecification = new VisitorAgeSpecification(12, 18);
        ISpecification<Staff> roleSpecification = new StaffRoleSpecification("Security");

        Assertions.assertTrue(ageSpecification.isSatisfiedBy(youngVisitor));
        Assertions.assertTrue(roleSpecification.isSatisfiedBy(securityStaff));

        System.out.println("---------------------------------------------------------------------\n");
    }

    @Test
    public void testStrategyPattern() {
        System.out.println("*****************************【策略模式测试】****************************");

        visit.experienceRide();
        visit.setVisitStrategy(new MerryGoRoundStrategy());
        visit.experienceRide();
        visit.setVisitStrategy(new WaterSlideStrategy());
        visit.experienceRide();

        System.out.println("---------------------------------------------------------------------\n");
    }
}
