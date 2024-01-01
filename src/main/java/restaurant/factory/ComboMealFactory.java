package restaurant.factory;

import restaurant.combo.ComboMeal;
import restaurant.food.*;

/**
 * 套餐工厂类
 * @author zhangYao
 */
public class ComboMealFactory extends AbstractFactory{
    @Override
    public Food getFood(String name) {
        return null;
    }

    @Override
    public ComboMeal getMeal(String name){
        return switch (name) {
            case "Meal A" -> ComboMeal.builder()
                    .name("Meal A: Burger + French Fries + Cola")
                    .price(18.)
                    .addFood(new Burger())
                    .addFood(new FrenchFries())
                    .addFood(new Cola())
                    .build();
            case "Meal B" -> ComboMeal.builder()
                    .name("Meal B: Burger + Fried Chicken + Sprite")
                    .price(19.)
                    .addFood(new Burger())
                    .addFood(new FriedChicken())
                    .addFood(new Sprite())
                    .build();
            default -> null;
        };
    }
}
