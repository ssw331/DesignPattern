package specification.spec;

import specification.person.Person;
import specification.person.Staff;

/**
 * 规约：一个人是职员
 */
public class PersonBeStaffSpecification implements Specification<Person>{
    @Override
    public boolean isSatisfiedBy(Person p) {
        return p instanceof Staff;
    }
}
