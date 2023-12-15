package builder;
/**
 * @author WWWsy
 */
public class AbstractHotMilk extends AbstractHotDrink {

    @Override
    public String name() {
        return "热牛奶";
    }

    @Override
    public float price() {
        return 13.0f;
    }
}
