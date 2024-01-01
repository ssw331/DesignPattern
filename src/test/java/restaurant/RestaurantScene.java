package restaurant;

public class RestaurantScene {
    public static void main(String[] args) {
        RestaurantTest restaurantTest = new RestaurantTest();
        restaurantTest.beforeEach();
        restaurantTest.testAbstractFactory();
        restaurantTest.testFactory();
        restaurantTest.testBuilder();
        restaurantTest.testIterator();
    }
}
