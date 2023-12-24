package specification.spec;

import specification.person.Person;
import specification.person.Manager;

/**
 * 规约：一个人是管理员
 */
public class PersonBeManagerSpecification implements Specification<Person>{
    @Override
    public boolean isSatisfiedBy(Person p) {
        return p instanceof Manager;
    }
}
