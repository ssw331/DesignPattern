package TourBusStationSubSystem.Filter;

import TourBusStationSubSystem.TourBus;

import java.util.List;

/**
 * Criteria 接口定义了过滤观光车的标准。
 * 所有过滤器类都应实现此接口以定义具体的过滤逻辑。
 */
public interface Criteria {
    List<TourBus> meetCriteria(List<TourBus> buses);
}
