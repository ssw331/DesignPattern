package amusementparkvisit.specification;

/**
 * @title: AndSpecification
 * @Author Kexian Tang
 * @Date: 2023/12/15
 * @Version 1.0
 */
/**
 * 逻辑与规约
 */
public class AndSpecification<T> extends CompositeSpecification<T> {
    private ISpecification<T> spec1;
    private ISpecification<T> spec2;

    public AndSpecification(ISpecification<T> spec1, ISpecification<T> spec2) {
        this.spec1 = spec1;
        this.spec2 = spec2;
    }

    @Override
    public boolean isSatisfiedBy(T candidate) {
        return spec1.isSatisfiedBy(candidate) && spec2.isSatisfiedBy(candidate);
    }
}
