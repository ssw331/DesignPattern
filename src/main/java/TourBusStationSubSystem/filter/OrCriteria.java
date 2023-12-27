package TourBusStationSubSystem.filter;

import TourBusStationSubSystem.TourBus;

import java.util.List;
import java.util.stream.Collectors;

/**
 * OrCriteria 类实现了组合两个过滤标准的逻辑。
 * 它结合两个不同的 Criteria 实例，并应用逻辑或（OR）操作，选择满足任一标准的观光车。
 * 这种方式允许创建更灵活的查询，例如选择座位数量大于某值或具有特定颜色的观光车。
 */
public class OrCriteria implements Criteria {

    private Criteria criteria;

    private Criteria anotherCriteria;


    public OrCriteria(Criteria criteria, Criteria anotherCriteria) {
        this.criteria = criteria;
        this.anotherCriteria = anotherCriteria;
    }

    // 应用两个标准并返回满足任一标准的观光车列表
    @Override
    public List<TourBus> meetCriteria(List<TourBus> buses) {
        List<TourBus> firstCriteriaBuses = criteria.meetCriteria(buses);
        List<TourBus> anotherCriteriaBuses = anotherCriteria.meetCriteria(buses);

        // 合并两个标准的结果
        for (TourBus bus : anotherCriteriaBuses) {
            if (!firstCriteriaBuses.contains(bus)) {
                firstCriteriaBuses.add(bus);
            }
        }

        // 若结果为空，则输出相应信息
        if (firstCriteriaBuses.isEmpty()) {
            System.out.println("没有符合要求的观光车");
            return firstCriteriaBuses;
        }

        // 对结果按照观光车编号进行排序
        return firstCriteriaBuses.stream()
                .sorted((bus1, bus2) -> Integer.compare(bus1.getBusId(), bus2.getBusId()))
                .collect(Collectors.toList());
    }
}
