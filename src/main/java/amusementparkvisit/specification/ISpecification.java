package amusementparkvisit.specification;


/**
 * @title: ISpecification
 * @Author Kexian Tang
 * @Date: 2023/12/15
 * @Version 1.0
 */
/**
 * 规约接口，用于检查是否满足某种条件
 */
public interface ISpecification<T> {
    boolean isSatisfiedBy(T o);
    ISpecification<T> And(ISpecification<T> specification);
    ISpecification<T> Or(ISpecification<T> specification);
    ISpecification<T> Not();
}