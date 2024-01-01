package TourBusStationSubSystem.filter;

import TourBusStationSubSystem.TourBus;

import java.util.ArrayList;
import java.util.List;

/**
 * BusSeatMoreThanFilter 类实现了 Criteria 接口
 * 用于过滤座位数大于指定值的观光车。
 */
public class BusSeatMoreThanFilter implements Criteria {

    private int thresholdSeatNum;

    public BusSeatMoreThanFilter(int thresholdSeatNum) {
        this.thresholdSeatNum = thresholdSeatNum;
    }

    @Override
    public List<TourBus> meetCriteria(List<TourBus> buses) {
        List<TourBus> filteredBuses = new ArrayList<>();
        for (TourBus bus: buses) {
            if (bus.getSeatNum() > thresholdSeatNum) {
                filteredBuses.add(bus);
            }
        }
        return filteredBuses;
    }
}
