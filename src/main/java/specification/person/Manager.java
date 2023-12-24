package specification.person;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 管理员
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Manager extends Person {
    public Manager(String name, Integer age) {
        super(name, age);
    }
}
