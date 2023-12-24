package specification.person;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 游客
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Tourist extends Person {
    public Tourist(String name, Integer age) {
        super(name, age);
    }
}
