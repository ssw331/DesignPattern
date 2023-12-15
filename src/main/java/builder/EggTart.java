package builder;
/**
 * @author WWWsy
 */
public class EggTart extends AbstractSnack {
    @Override
    public String name() {
        return "蛋挞";
    }

    @Override
    public Packing packing() {
        return new Box();
    }

    @Override
    public float price() {
        return 8.0f;
    }
}
