package miscellaneous.TransferObject;

//传输对象实体
public class GoodsTransferObject {
    private String name;
    private int count;
    private int id;

    public GoodsTransferObject(int id, String name, int count) {
        this.name = name;
        this.count = count;
        this.id = id;
        System.out.println("已构造GoodsTransferObject");
    }

    public String getName() {return name;}
    public int getId() {return id;}
    public int getCount() {return count;}
}