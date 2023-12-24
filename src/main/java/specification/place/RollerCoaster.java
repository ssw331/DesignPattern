package specification.place;

import specification.person.Person;
import specification.spec.PersonBeTouristSpecification;

/**
 * 过山车
 */
public class RollerCoaster extends Place{

    /// 过山车仅限游客乘坐
    @Override
    public boolean canEnter(Person person) {
        var touristSpecification = new PersonBeTouristSpecification();
        return touristSpecification.isSatisfiedBy(person);
    }
}
