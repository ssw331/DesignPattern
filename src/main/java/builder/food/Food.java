package builder.food;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Objects;

/**
 * 抽象的食物
 */
@Data
@AllArgsConstructor
public abstract class Food {
    private String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Food food = (Food) o;
        return Objects.equals(getName(), food.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }
}
