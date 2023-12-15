package TransferObject;

/**
 * @author Bestom
 *
 * 设施传输对象
 */

public class GoodsTransferObject {
    private String name;
    private int count;
    private int id;

    /**
     * GoodsTransferObject构造器
     */
    public GoodsTransferObject(int id, String name, int count) {
        this.name = name;
        this.count = count;
        this.id = id;

        System.out.printf("GoodsTransferObject构造器\n");
    }

    /**
     * 货物名getter
     */
    public String getName() {

        //System.out.printf("货物名getter\n");
        return name;
    }

    /**
     * ID getter
     */
    public int getId() {

        //System.out.printf("ID getter\n");
        return id;
    }

    /**
     * 数量 getter
     */
    public int getCount() {

        //System.out.printf("数量 getter\n");
        return count;
    }

    /**
     * 货物名setter
     */
    public void setName(String name) {

        //System.out.printf("货物名setter\n");
        this.name = name;
    }

    /**
     * ID setter
     */
    public void setId(int id) {

        //System.out.printf("ID setter\n");
        this.id = id;
    }

    /**
     * 数量 setter
     */
    public void setCount(int count) {

        //System.out.printf("数量 setter\n");
        this.count = count;
    }
}