package restaurant.factory;

import restaurant.combo.ComboMeal;
import restaurant.food.Food;

/**
 * 餐厅内的抽象工厂
 * @author zhangYao
 */
public abstract class AbstractFactory {
    public abstract Food getFood(String name);
    public abstract ComboMeal getMeal(String name);
}
