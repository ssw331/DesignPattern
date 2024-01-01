package restaurant.factory;

/**
 * 超级工厂
 * @author cineazhan
 */
public class FactoryProducer {
    public static AbstractFactory getFactory(String choice){
        if(choice.equalsIgnoreCase("FOOD")){
            return new FoodFactory();
        } else if(choice.equalsIgnoreCase("MEAL")){
            return new ComboMealFactory();
        }
        return null;
    }
}
