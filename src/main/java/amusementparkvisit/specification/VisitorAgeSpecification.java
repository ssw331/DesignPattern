package amusementparkvisit.specification;


/**
 * @title: VisitorAgeSpecification
 * @Author Kexian Tang
 * @Date: 2023/12/15
 * @Version 1.0
 */
/**
 * 游客年龄规约
 */
public class VisitorAgeSpecification extends CompositeSpecification<Visitor> {
    private int minAge;
    private int maxAge;

    public VisitorAgeSpecification(int minAge, int maxAge) {
        this.minAge = minAge;
        this.maxAge = maxAge;
    }

    @Override
    public boolean isSatisfiedBy(Visitor visitor) {
        return visitor.getAge() >= minAge && visitor.getAge() <= maxAge;
    }
}