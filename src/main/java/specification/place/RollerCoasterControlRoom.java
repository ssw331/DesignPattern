package specification.place;

import specification.person.Person;
import specification.spec.PersonBeTouristSpecification;

/**
 * 过山车控制室
 */
public class RollerCoasterControlRoom extends Place{

    /// 过山车控制室不允许游客进入
    @Override
    public boolean canEnter(Person person) {
        var touristSpecification = new PersonBeTouristSpecification();
        return touristSpecification.not().isSatisfiedBy(person);
    }
}
