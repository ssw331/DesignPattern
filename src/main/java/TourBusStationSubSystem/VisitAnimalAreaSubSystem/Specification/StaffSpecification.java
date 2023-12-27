package TourBusStationSubSystem.VisitAnimalAreaSubSystem.Specification;

/**
 * @title: StaffSpecification
 * @Author Xinyu Fang
 * @Date: 2022/12/10 11:57
 * @Version 1.0
 */
public class StaffSpecification<T> extends CompositeSpecification<T> {
    @Override
    public boolean isSatisfiedBy(T o) {
        return o instanceof People && ((People) o).getIdentity().equals("staff");
    }

}