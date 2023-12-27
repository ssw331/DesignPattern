package TourBusStationSubSystem.VisitAnimalAreaSubSystem.Specification;

/**
 * @title: OrSpecification
 * @Author Xinyu Fang
 * @Date: 2022/12/10 11:29
 * @Version 1.0
 */
public class OrSpecification <T> extends CompositeSpecification<T> {
    private ISpecification<T> left;
    private ISpecification<T> right;

    public OrSpecification(ISpecification<T> left, ISpecification<T> right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public boolean isSatisfiedBy(T o) {
        return left.isSatisfiedBy(o) || right.isSatisfiedBy(o);
    }


}