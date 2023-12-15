package builder;
/**
 * @author WWWsy
 */
public class FrenchFries extends AbstractSnack {
    @Override
    public String name() {
        return "薯条";
    }

    @Override
    public Packing packing() {
        return new Wrapper();
    }

    @Override
    public float price() {
        return 10.0f;
    }
}
