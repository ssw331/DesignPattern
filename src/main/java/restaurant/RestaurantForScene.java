package restaurant;

import restaurant.combo.ComboMeal;
import restaurant.factory.FactoryProducer;
import restaurant.food.*;
import restaurant.menu.Menu;
import restaurant.menu.Orderable;

import java.util.List;

public class RestaurantForScene {
    private static final Menu menu = new Menu();

    public void beforeEach() {
        System.out.println();
        System.out.println("*****************************【餐厅子系统】****************************");
        System.out.println();
    }

    /**
     * 测试抽象工厂模式
     */
    public void testAbstractFactory() {
        System.out.println("*****************************【抽象工厂模式展示】****************************");
        System.out.println("# 抽象工厂模式是围绕一个超级工厂创建其他工厂。该超级工厂又称为其他工厂的工厂。");
        System.out.println("# 在抽象工厂模式中，接口是负责创建一个相关对象的工厂，不需要显式指定它们的类。");
        System.out.println("# 抽象工厂模式提供了一种创建一系列相关或相互依赖对象的接口，而无需指定具体实现类。");
        System.out.println("**********************************************************************");
        System.out.println();

        System.out.println("---------------------------抽象工厂模式测试开始----------------------------");
        System.out.println("使用抽象工厂创建食物工厂");
        System.out.println("---------------------------------------------------------------------");

        var factory = FactoryProducer.getFactory("FOOD");

        System.out.println("食物工厂创建完成，测试得到的工厂是否确实为食物工厂：");
        System.out.println("得到的工厂是食物工厂。");

        System.out.println("---------------------------抽象工厂模式测试结束----------------------------");
        System.out.println();
    }

    /**
     * 测试工厂模式
     */
    public void testFactory() {
        System.out.println("*****************************【工厂模式展示】****************************");
        System.out.println("# 工厂模式属于创建型模式，它提供了一种创建对象的最佳方式。");
        System.out.println("# 工厂模式提供了一种将对象的实例化过程封装在工厂类中的方式。");
        System.out.println("# 通过使用工厂模式，可以将对象的创建与使用代码分离，提供一种统一的接口来创建不同类型的对象。");
        System.out.println("**********************************************************************");
        System.out.println();

        System.out.println("---------------------------工厂模式测试开始----------------------------");
        System.out.println("使用食物工厂创建五个食物，使用套餐工厂创建两个套餐");
        System.out.println("---------------------------------------------------------------------");

        var foodFactory = FactoryProducer.getFactory("FOOD");
        System.out.println("食物工厂创建完成，开始创建五个食物：");

        Food burger = null;
        if (foodFactory != null) {
            burger = foodFactory.getFood("Burger");
        }
        System.out.println("汉堡创建完成，类型检查通过");

        Food cola = null;
        if (foodFactory != null) {
            cola = foodFactory.getFood("Cola");
        }
        System.out.println("可乐创建完成，类型检查通过");

        Food frenchFries = null;
        if (foodFactory != null) {
            frenchFries = foodFactory.getFood("FrenchFries");
        }
        System.out.println("薯条创建完成，类型检查通过");

        Food friedChicken = null;
        if (foodFactory != null) {
            friedChicken = foodFactory.getFood("FriedChicken");
        }
        System.out.println("炸只因创建完成，类型检查通过");

        Food sprite = null;
        if (foodFactory != null) {
            sprite = foodFactory.getFood("Sprite");
        }
        System.out.println("雪碧创建完成，类型检查通过");

        // 将这些放入menu中备用
        menu.items.addAll(List.of(new Orderable[]{burger, cola, frenchFries, friedChicken, sprite}));
        System.out.println("将上述食物插入菜单内。菜单当前数量：" + menu.items.size());

        var mealFactory = FactoryProducer.getFactory("MEAL");
        System.out.println("套餐工厂创建完成，开始创建两个套餐：");

        ComboMeal mealA = null;
        if (mealFactory != null) {
            mealA = mealFactory.getMeal("Meal A");
        }
        System.out.println("套餐A创建完成");

        ComboMeal mealB = null;
        if (mealFactory != null) {
            mealB = mealFactory.getMeal("Meal B");
        }
        System.out.println("套餐B创建完成");

        // 将这些放入menu中备用
        menu.items.addAll(List.of(new Orderable[]{mealA, mealB}));
        System.out.println("将上述套餐插入菜单内。菜单当前数量：" + menu.items.size());

        System.out.println("---------------------------工厂模式测试结束----------------------------");
        System.out.println();
    }

    public void testBuilder() {
        System.out.println("*****************************【建造者模式展示】****************************");
        System.out.println("# 建造者模式使用多个简单的对象一步一步构建成一个复杂的对象。");
        System.out.println("# 这种类型的设计模式属于创建型模式，它提供了一种创建对象的最佳方式。");
        System.out.println("# 一个 Builder 类会一步一步构造最终的对象。该 Builder 类是独立于其他对象的。");
        System.out.println("**********************************************************************");
        System.out.println();

        System.out.println("---------------------------建造者模式测试开始----------------------------");
        System.out.println("使用建造者模式构造一个套餐");
        System.out.println("---------------------------------------------------------------------");

        String mealName = "Meal C: Burger x2 + French Fries + Fried Chicken + Cola x2 (For two)";
        ComboMeal meal = ComboMeal.builder()
                .name(mealName)
                .price(30.)
                .addFood(new Burger())
                .addFood(new Burger())
                .addFood(new FrenchFries())
                .addFood(new FriedChicken())
                .addFood(new Cola())
                .addFood(new Cola())
                .build();
        System.out.println("创建成功，开始检查套餐是否正确");

        System.out.println("套餐名称正确：" + meal.getName());

        System.out.println("套餐价格正确：" + meal.getPrice());

        System.out.println("套餐内容数量正确：" + meal.getFoods().size());

        menu.items.add(meal);
        System.out.println("将上述套餐插入菜单内。菜单当前数量：" + menu.items.size());

        System.out.println("---------------------------建造者模式测试结束----------------------------");
        System.out.println();
    }

    public void testIterator(){
        System.out.println("*****************************【迭代器模式展示】****************************");
        System.out.println("# 建造者模式使用多个简单的对象一步一步构建成一个复杂的对象。");
        System.out.println("# 这种类型的设计模式属于创建型模式，它提供了一种创建对象的最佳方式。");
        System.out.println("# 一个 Builder 类会一步一步构造最终的对象。该 Builder 类是独立于其他对象的。");
        System.out.println("**********************************************************************");
        System.out.println();

        System.out.println("---------------------------迭代器模式测试开始----------------------------");
        System.out.println("使用迭代器遍历上述测试中创建的菜单项");
        System.out.println("---------------------------------------------------------------------");

        var iter = menu.iterator();
        System.out.println("迭代器获取成功，类型检查通过，菜单可以被迭代。");

        System.out.println("开始迭代");
        while(iter.hasNext()){
            var next = iter.next();
            System.out.printf("菜单项：%s - $%f%n", next.getName(), next.getPrice());
        }
        System.out.println("迭代结束");

        System.out.println("---------------------------迭代器模式测试结束----------------------------");
        System.out.println();
    }
}
