package amusementparkvisit.specification;


/**
 * @title: NotSpecification
 * @Author Kexian Tang
 * @Date: 2023/12/15
 * @Version 1.0
 */
/**
 * 逻辑非规约
 */
public class NotSpecification<T> extends CompositeSpecification<T> {
    private ISpecification<T> spec;

    public NotSpecification(ISpecification<T> spec) {
        this.spec = spec;
    }

    @Override
    public boolean isSatisfiedBy(T candidate) {
        return !spec.isSatisfiedBy(candidate);
    }
}