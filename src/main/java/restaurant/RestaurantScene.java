package restaurant;

public class RestaurantScene {
    public static void main(String[] args) {
        RestaurantForScene restaurantTest = new RestaurantForScene();
        restaurantTest.beforeEach();
        restaurantTest.testAbstractFactory();
        restaurantTest.testFactory();
        restaurantTest.testBuilder();
        restaurantTest.testIterator();
    }
}
