package specification.spec;

import specification.person.Person;
import specification.person.Tourist;

/**
 * 规约：一个人是游客
 */
public class PersonBeTouristSpecification implements Specification<Person>{
    @Override
    public boolean isSatisfiedBy(Person p) {
        return p instanceof Tourist;
    }
}
