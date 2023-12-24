package builder.combo;

import builder.food.Food;

/**
 * 套餐建造者
 */
public class ComboMealBuilder {
    private final ComboMeal comboMeal;

    public ComboMealBuilder() {
        comboMeal = new ComboMeal("");
    }

    public ComboMealBuilder name(String name){
        comboMeal.setName(name);
        return this;
    }

    public ComboMealBuilder addFood(Food food) {
        comboMeal.getFoods().add(food);
        return this;
    }

    public ComboMeal build(){
        return comboMeal;
    }
}
