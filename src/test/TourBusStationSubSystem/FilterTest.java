package TourBusStationSubSystem;

import TourBusStationSubSystem.Filter.*;
import TourBusStationSubSystem.Prototype.LargeTourBus;
import TourBusStationSubSystem.Prototype.MediumTourBus;
import TourBusStationSubSystem.Prototype.SmallTourBus;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * FilterTest 类用于演示过滤器模式在观光车租赁系统中的应用。
 * 通过不同的过滤条件，展示如何筛选出符合特定条件的观光车。
 */
public class FilterTest {
    @Test
    public void filterTest() {
        System.out.println("*****************************【过滤器模式展示】****************************");
        System.out.println("# 过滤器模式允许通过定义标准对对象集合进行过滤，得到符合条件的对象。");
        System.out.println("# 本系统中，使用过滤器模式对观光车进行过滤，以筛选出符合不同条件的观光车。");
        System.out.println("**********************************************************************");
        System.out.println("---------------------------过滤器模式测试开始----------------------------");

        List<TourBus> buses = new ArrayList<>();
        System.out.println("添加一辆大型观光车，有8个座位");
        buses.add(new LargeTourBus());
        System.out.println("添加一辆小型观光车，有2个座位");
        buses.add(new SmallTourBus());
        System.out.println("再添加两辆大型观光车");
        buses.add(new LargeTourBus());
        buses.add(new LargeTourBus());
        System.out.println("添加一辆中型观光车，有4个座位");
        buses.add(new MediumTourBus());
        System.out.println("再添加一辆小型观光车，有2个座位");
        buses.add(new SmallTourBus());

        System.out.println("当前观光车总览");
        printBusesInfo(buses);
        System.out.println("---------------------------------------------------------------------");

        System.out.println("过滤座位数小于5的观光车");
        Criteria seatNoLessThan5 = new BusSeatLessThanFilter(5);
        printBusesInfo(seatNoLessThan5.meetCriteria(buses));

        System.out.println("过滤座位数大于2的观光车");
        Criteria seatNoMoreThan2 = new BusSeatMoreThanFilter(2);
        printBusesInfo(seatNoMoreThan2.meetCriteria(buses));

        System.out.println("过滤座位数小于4或大于4的观光车");
        Criteria andCriteria = new AndCriteria(new BusSeatLessThanFilter(4), new BusSeatMoreThanFilter(4));
        printBusesInfo(andCriteria.meetCriteria(buses));

        System.out.println("过滤座位数小于8或大于2的观光车");
        Criteria orCriteria = new OrCriteria(new BusSeatLessThanFilter(8), new BusSeatMoreThanFilter(2));
        printBusesInfo(orCriteria.meetCriteria(buses));

        System.out.println("---------------------------过滤器模式测试结束----------------------------");
    }

    private void printBusesInfo(List<TourBus> buses) {
        if (buses.isEmpty()) {
            System.out.println("没有符合条件的观光车");
            return;
        }
        for (TourBus bus : buses) {
            System.out.println("编号：" + bus.getBusId() + "，座位数：" + bus.getSeatNum());
        }
    }
}
