package TourBusStationSubSystem.VisitAnimalAreaSubSystem.Specification;
/**
 * @author Xinyu Fang
 * @version 1.0
 * @title: ISpecification
 * @description: 规格接口
 */

public interface ISpecification<T>    {
    boolean isSatisfiedBy(T o);
    ISpecification<T> And(ISpecification<T> specification);
    ISpecification<T> Or(ISpecification<T> specification);
    ISpecification<T> Not(ISpecification<T> specification);
}
