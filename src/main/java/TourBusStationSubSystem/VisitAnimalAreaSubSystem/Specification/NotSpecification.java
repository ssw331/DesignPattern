package TourBusStationSubSystem.VisitAnimalAreaSubSystem.Specification;

/**
 * @title: NotSpecification
 * @Author Xinyu Fang
 * @Date: 2022/12/10 11:30
 * @Version 1.0
 */
public class NotSpecification <T> extends CompositeSpecification<T> {
    private ISpecification<T> specification;

    public NotSpecification(ISpecification<T> specification) {
        this.specification = specification;
    }

    @Override
    public boolean isSatisfiedBy(T o) {
        return !this.specification.isSatisfiedBy(o);
    }


}