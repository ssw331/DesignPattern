package restaurant.factory;

import restaurant.combo.ComboMeal;
import restaurant.food.*;

/**
 * 食物的工厂类
 * @author zhangYao
 */
public class FoodFactory extends AbstractFactory {
    @Override
    public Food getFood(String name) {
        return switch (name) {
            case "Burger" -> new Burger();
            case "Cola" -> new Cola();
            case "FrenchFries" -> new FrenchFries();
            case "FriedChicken" -> new FriedChicken();
            case "Sprite" -> new Sprite();
            default -> null;
        };
    }

    @Override
    public ComboMeal getMeal(String name) {
        return null;
    }
}
