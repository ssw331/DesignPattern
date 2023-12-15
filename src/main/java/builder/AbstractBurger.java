package builder;

/**
 * @author WWWsy
 */
public abstract class AbstractBurger implements Item {

    @Override
    public Packing packing() {
        return new Wrapper();
    }
    /**
     *
     * @return 商品价格，根据具体商品实现
     */
    @Override
    public abstract float price();
}
