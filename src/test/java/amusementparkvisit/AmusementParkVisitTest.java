package amusementparkvisit;

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
        // 测试前的介绍
        System.out.println("*****************************【中介者模式测试】****************************");
        System.out.println("# 中介者模式是用来减少多个对象或类之间的通信复杂性。");
        System.out.println("# 这种模式提供了一个中介者类，该类通常处理不同类之间的通信，并支持易于维护的代码。");
        System.out.println("**********************************************************************");
        System.out.println();

        // 测试开始
        System.out.println("---------------------------中介者模式测试开始----------------------------");
        QueueMediator.showQueueMonitorBoard();
        rollerCoaster.setWaitTime(45);
        merryGoRound.setWaitTime(20);
        QueueMediator.showQueueMonitorBoard();
        // 测试结束
        System.out.println("---------------------------中介者模式测试结束----------------------------");
        System.out.println("---------------------------------------------------------------------\n");
    }


    @Test
    public void testSpecificationPattern() {
        // 测试前的介绍
        System.out.println("*****************************【规约模式测试】****************************");
        System.out.println("# 规约模式是一种特定的设计模式，它允许业务规则可以以链式的方式组合使用。");
        System.out.println("# 该模式使用单一规则/规约的组合来表示复杂的业务逻辑。");
        System.out.println("**********************************************************************");
        System.out.println();

        // 测试开始
        System.out.println("---------------------------规约模式测试开始----------------------------");
        ISpecification<Visitor> ageSpecification = new VisitorAgeSpecification(12, 18);
        ISpecification<Staff> roleSpecification = new StaffRoleSpecification("Security");

        boolean isYoungVisitorSatisfied = ageSpecification.isSatisfiedBy(youngVisitor);
        boolean isSecurityStaffSatisfied = roleSpecification.isSatisfiedBy(securityStaff);

        Assertions.assertTrue(isYoungVisitorSatisfied, "年龄规约未能正确验证小明的年龄");
        Assertions.assertTrue(isSecurityStaffSatisfied, "角色规约未能正确验证王警官的职位");

        // 打印测试结果
        System.out.println("年龄规约测试结果： " + (isYoungVisitorSatisfied ? "通过" : "未通过"));
        System.out.println("角色规约测试结果： " + (isSecurityStaffSatisfied ? "通过" : "未通过"));

        // 测试结束
        System.out.println("---------------------------规约模式测试结束----------------------------");
        System.out.println("---------------------------------------------------------------------\n");
    }


    @Test
    public void testStrategyPattern() {
        // 测试前的介绍
        System.out.println("*****************************【策略模式测试】****************************");
        System.out.println("# 策略模式是一种设计模式，允许在运行时选择算法的行为。");
        System.out.println("# 它定义了算法族，分别封装起来，让它们之间可以互相替换，此模式让算法的变化独立于使用算法的客户。");
        System.out.println("**********************************************************************");
        System.out.println();

        // 测试开始
        System.out.println("---------------------------策略模式测试开始----------------------------");
        visit.experienceRide();
        visit.setVisitStrategy(new MerryGoRoundStrategy());
        visit.experienceRide();
        visit.setVisitStrategy(new WaterSlideStrategy());
        visit.experienceRide();

        // 测试结束
        System.out.println("---------------------------策略模式测试结束----------------------------");
        System.out.println("---------------------------------------------------------------------\n");
    }

}
