package specification;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import specification.person.Manager;
import specification.person.Staff;
import specification.person.Tourist;
import specification.place.ManagerHouse;
import specification.place.Restaurant;
import specification.place.RollerCoaster;
import specification.place.RollerCoasterControlRoom;

/**
 * 规约测试
 */
public class SpecificationTest {

    @Test
    public void specification(){
        var tom = new Tourist("Tom",23);
        var jack = new Staff("Jack", 30);
        var john = new Manager("John", 42);

        Restaurant restaurant = new Restaurant();
        RollerCoaster rollerCoaster = new RollerCoaster();
        RollerCoasterControlRoom controlRoom = new RollerCoasterControlRoom();
        ManagerHouse managerHouse = new ManagerHouse();

        Assertions.assertTrue(restaurant.canEnter(tom));
        Assertions.assertTrue(restaurant.canEnter(jack));
        Assertions.assertTrue(restaurant.canEnter(john));

        Assertions.assertTrue(rollerCoaster.canEnter(tom));
        Assertions.assertFalse(rollerCoaster.canEnter(jack));
        Assertions.assertFalse(rollerCoaster.canEnter(john));

        Assertions.assertFalse(controlRoom.canEnter(tom));
        Assertions.assertTrue(controlRoom.canEnter(jack));
        Assertions.assertTrue(controlRoom.canEnter(john));

        Assertions.assertFalse(managerHouse.canEnter(tom));
        Assertions.assertTrue(managerHouse.canEnter(jack));
        Assertions.assertTrue(managerHouse.canEnter(john));
    }
}
