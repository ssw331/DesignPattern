package specification.place;

import specification.person.Person;

/**
 * 餐厅
 */
public class Restaurant extends Place{

    /// 餐厅不需要特殊的限制，默认即可
    @Override
    public boolean canEnter(Person person) {
        return super.canEnter(person);
    }
}
