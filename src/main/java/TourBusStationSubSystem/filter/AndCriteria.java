package TourBusStationSubSystem.filter;

import TourBusStationSubSystem.TourBus;

import java.util.List;
import java.util.stream.Collectors;



/**
 * AndCriteria 类实现了组合两个过滤标准的逻辑。
 * 它结合两个不同的 Criteria 实例，并应用逻辑与（AND）操作，只选择同时满足这两个标准的观光小火车。
 * 这允许对观光小火车进行更复杂的查询，例如同时满足座位数量和颜色要求的观光小火车。
 */
public class AndCriteria implements Criteria {

    private Criteria criteria;
    private Criteria anotherCriteria;

    public AndCriteria(Criteria criteria, Criteria anotherCriteria) {
        this.criteria = criteria;
        this.anotherCriteria = anotherCriteria;
    }

    // 应用两个标准并返回满足两者的观光小火车列表
    @Override
    public List<TourBus> meetCriteria(List<TourBus> buses) {
        List<TourBus> firstCriteriaBuses = criteria.meetCriteria(buses);
        List<TourBus> filteredBuses = anotherCriteria.meetCriteria(firstCriteriaBuses);

        // 若结果为空，则输出相应信息
        if (filteredBuses.isEmpty()) {
            System.out.println("没有符合要求的观光小火车");
            return filteredBuses;
        }

        // 对结果按照观光小火车编号进行排序
        return filteredBuses.stream()
                .sorted((bus1, bus2) -> Integer.compare(bus1.getBusId(), bus2.getBusId()))
                .collect(Collectors.toList());
    }
}
