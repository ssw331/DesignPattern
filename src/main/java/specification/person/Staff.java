package specification.person;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 员工
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Staff extends Person {
    public Staff(String name, Integer age) {
        super(name, age);
    }
}
