package TourBusStationSubSystem.VisitAnimalAreaSubSystem.Specification;

/**
 * @title: CompositeSpecification
 * @Author Xinyu Fang
 * @Date: 2022/12/10 11:13
 * @Version 1.0
 */
public abstract class CompositeSpecification<T> implements ISpecification<T> {
    @Override
    public ISpecification<T> And(ISpecification<T> specification) {
        return new AndSpecification<T>(this, specification);
    }

    @Override
    public ISpecification<T> Or(ISpecification<T> specification) {
        return new OrSpecification<T>(this, specification);
    }

    @Override
    public ISpecification<T> Not(ISpecification<T> specification) {
        return new NotSpecification<T>(specification);
    }
}
