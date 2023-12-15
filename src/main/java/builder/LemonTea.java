package builder;
/**
 * @author WWWsy
 */
public class LemonTea extends AbstractColdDrink {

    @Override
    public float price() {
        return 13.0f;
    }

    @Override
    public String name() {
        return "柠檬茶";
    }
}
