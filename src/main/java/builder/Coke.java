package builder;
/**
 * @author WWWsy
 */
public class Coke extends AbstractColdDrink {

    @Override
    public float price() {
        return 30.0f;
    }

    @Override
    public String name() {
        return "可乐（冰）";
    }
}
