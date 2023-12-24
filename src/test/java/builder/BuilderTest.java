package builder;

import builder.combo.ComboMeal;
import builder.food.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class BuilderTest {
    @Test
    public void testBuilder() {
        var mealA = ComboMeal.builder()
                .name("Meal A: Burger + French Fries + Cola")
                .addFood(new Burger())
                .addFood(new FrenchFries())
                .addFood(new Cola())
                .build();

        var mealB = ComboMeal.builder()
                .name("Meal B: Burger + Fried Chicken + Sprite")
                .addFood(new Burger())
                .addFood(new FriedChicken())
                .addFood(new Sprite())
                .build();

        Assertions.assertInstanceOf(ComboMeal.class, mealA);
        Assertions.assertInstanceOf(ComboMeal.class, mealB);

        Assertions.assertEquals("Meal A: Burger + French Fries + Cola", mealA.getName());
        Assertions.assertEquals("Meal B: Burger + Fried Chicken + Sprite", mealB.getName());

        Assertions.assertEquals(mealA.getFoods(), List.of(new Food[]{
                new Burger(), new FrenchFries(), new Cola()
        }));
        Assertions.assertEquals(mealB.getFoods(), List.of(new Food[]{
                new Burger(), new FriedChicken(), new Sprite()
        }));

    }
}
