package TourBusStationSubSystem.VisitAnimalAreaSubSystem.Specification;

/**
 * @title: OfficeSpecification
 * @Author Xinyu Fang
 * @Date: 2022/12/10 12:03
 * @Version 1.0
 */
public class RoomSpecification<T> extends CompositeSpecification<T> {
    private String authority;

    public RoomSpecification(String authority) {
        this.authority = authority;
    }
    @Override
    public boolean isSatisfiedBy(T o) {
        return o instanceof People && ((People) o).getAuthority().equals(authority);
    }
}