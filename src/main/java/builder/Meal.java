package builder;

import java.util.ArrayList;
import java.util.List;
/**
 * @author WWWsy
 */
public class Meal {
    /**
     * 一个订单中的所有食物
     */
    private final List<Item> items = new ArrayList<>();

    public void addItem(Item item){
        items.add(item);
    }

    public float getCost(){
        float cost = 0.0f;
        for (Item item : items) {
            cost += item.price();
        }
        return cost;
    }

    public void showItems(){
        for (Item item : items) {
            System.out.println("食品: " + item.name()+", 包装: " + item.packing().pack()+", 单价: " + item.price());
        }
    }
}
