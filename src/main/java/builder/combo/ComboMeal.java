package builder.combo;

import builder.food.Food;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * 套餐
 */
@Data
public class ComboMeal {
    private List<Food> foods;
    private String name;

    public ComboMeal(String name) {
        this.name = name;
        this.foods = new ArrayList<>();
    }

    public static ComboMealBuilder builder(){
        return new ComboMealBuilder();
    }
}
