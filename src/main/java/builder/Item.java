package builder;

/**
 * @author WWWsy
 */
public interface Item {
    /**
     *
     * @return 食物名称
     */
    String name();

    /**
     *
     * @return 食物所使用的包装
     */
    Packing packing();

    /**
     *
     * @return 食物价格
     */
    float price();
}
