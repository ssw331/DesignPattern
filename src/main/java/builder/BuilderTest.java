package builder;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
/**
 * @author WWWsy
 */
public class BuilderTest {
    public static void main(String[] args) {
        MealBuilder mealBuilder = new MealBuilder();
        Scanner scanner = new Scanner(System.in);
        List<Item> items = new ArrayList<>();
        System.out.println("欢迎来到KFC（xx游乐园店）");
        System.out.println("请输入序号点单（1-香辣鸡腿堡，2-深海鳕鱼，3-可乐，4-柠檬茶，5-热牛奶，6-薯条，7-蛋挞，8-完成选择）：");
        while (true) {
            try {
                int choice = scanner.nextInt();
                if (choice == 1) {
                    items.add(new SpicyChickenThighAbstractBurger());
                } else if (choice == 2) {
                    items.add(new DeepSeaCodAbstractBurger());
                } else if (choice == 3) {
                    items.add(new Coke());
                } else if (choice == 4) {
                    items.add(new LemonTea());
                } else if (choice == 5) {
                    items.add(new AbstractHotMilk());
                } else if (choice == 6) {
                    items.add(new FrenchFries());
                } else if (choice == 7) {
                    items.add(new EggTart());
                } else if (choice == 8) {
                    if (items.isEmpty()) {
                        System.out.println("您未选择任何食物，欢迎您下次光临！");
                    }
                        break;

                } else {
                    System.out.println("无效的输入，请重新输入！");
                }
            } catch (InputMismatchException e) {
                System.out.println("无效的输入，请输入一个数字！");
                scanner.next();  // discard the invalid input
            }
        }
        Meal meal = mealBuilder.prepareMeal(items);
        meal.showItems();
        System.out.println("总价: " + meal.getCost());
        scanner.close();
    }
}
