package restaurant.food;

import lombok.AllArgsConstructor;
import lombok.Data;
import restaurant.menu.Orderable;

import java.util.Objects;

/**
 * 抽象的食物
 * @author zhangYao
 */
@Data
@AllArgsConstructor
public abstract class Food implements Orderable {
    private String name;
    private Double price;

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
