package builder;
/**
 * @author WWWsy
 */
public abstract class AbstractSnack implements Item {
    /**
     *
     * @return 小食的包装
     *
     */
    @Override
    public abstract Packing packing();
    /**
     *
     * @return 商品价格
     */
    @Override
    public abstract float price();
}
