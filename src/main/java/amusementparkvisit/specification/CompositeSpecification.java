package amusementparkvisit.specification;

/**
 * @title: CompositeSpecification
 * @Author Kexian Tang
 * @Date: 2023/12/15
 * @Version 1.0
 */
/**
 * 抽象组合规约类，提供规约之间的逻辑操作
 */
public abstract class CompositeSpecification<T> implements ISpecification<T> {
    @Override
    public ISpecification<T> And(ISpecification<T> other) {
        return new AndSpecification<>(this, other);
    }

    @Override
    public ISpecification<T> Or(ISpecification<T> other) {
        return new OrSpecification<>(this, other);
    }

    @Override
    public ISpecification<T> Not() {
        return new NotSpecification<>(this);
    }
}