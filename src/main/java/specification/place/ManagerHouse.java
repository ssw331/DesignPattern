package specification.place;

import specification.person.Person;
import specification.spec.PersonBeManagerSpecification;
import specification.spec.PersonBeStaffSpecification;

/**
 * 管理员小屋
 */
public class ManagerHouse extends Place{

    /// 管理员小屋仅限职员和管理员入内
    @Override
    public boolean canEnter(Person person) {
        var staffSpecification = new PersonBeStaffSpecification();
        var managerSpecification = new PersonBeManagerSpecification();
        return staffSpecification.or(managerSpecification).isSatisfiedBy(person);
    }
}
