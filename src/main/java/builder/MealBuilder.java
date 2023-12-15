package builder;

import java.util.List;
/**
 * @author WWWsy
 * 建造者类，负责创建Meal对象
 */
public class MealBuilder {

    /**
     *
     * @return
     * 通过传入一个item列表来自定义的配置一个订单
     */
    public Meal prepareMeal(List<Item> items){
        Meal meal = new Meal();
        for(Item item : items){
            meal.addItem(item);
        }
        return meal;
    }
}

