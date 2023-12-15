package builder;
/**
 * @author WWWsy
 */
public abstract class AbstractHotDrink implements Item {

    @Override
    public Packing packing() {
        return new Cup();
    }
    /**
     *
     * @return 商品价格，根据具体商品实现
     */
    @Override
    public abstract float price();

}
