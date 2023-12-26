package restaurant.combo;

import lombok.Data;
import restaurant.food.Food;
import restaurant.menu.Orderable;

import java.util.ArrayList;
import java.util.List;

/**
 * 套餐
 * @author zhangYao
 */
@Data
public class ComboMeal implements Orderable {
    private List<Food> foods;
    private String name;
    private Double price;

    public ComboMeal(String name) {
        this.name = name;
        this.foods = new ArrayList<>();
    }

    public static ComboMealBuilder builder(){
        return new ComboMealBuilder();
    }
}
