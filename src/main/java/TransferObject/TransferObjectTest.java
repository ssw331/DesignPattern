package TransferObject;

import java.util.Iterator;
import java.util.Map;

public class TransferObjectTest {
//    public static void main(String[] args) {
//        transferObjectTest();
//    }
    public void transferObjectTest() {

        System.out.println("*****************************【传输对象模式展示】****************************");
        System.out.println("DTO模式在处理方法中携带数据的对象，能够目减少方法调用的次数。");
        System.out.println("----------------------Transfer Object Pattern Test Start--------------------");
        GoodsBusinessObject goodBusinessObject = new GoodsBusinessObject();
        GoodsTransferObject good1 = new GoodsTransferObject(1, "iPhone 15", 1);
        GoodsTransferObject good2 = new GoodsTransferObject(10, "PS5 Pro", 2);
        GoodsTransferObject good3 = new GoodsTransferObject(13, "RTX 4090", 3);
        goodBusinessObject.addGood(good1);
        goodBusinessObject.addGood(good2);
        goodBusinessObject.addGood(good3);
        Map<Integer, GoodsTransferObject> m=goodBusinessObject.getAllGoods();
        for (Integer i:m.keySet()) {
            System.out.println("id:" + i+" 货物名：" + m.get(i).getName()+" 数量："+m.get(i).getCount());
        }
        GoodsTransferObject good = new GoodsTransferObject(13, "RTX 4070Ti", 4);
        goodBusinessObject.updateGood(good);
        GoodsTransferObject getGood = goodBusinessObject.getGood(13);
        System.out.println("查看单个货物：");
        System.out.println("id：" + getGood.getId()+" 货物名：" + getGood.getName()+" 数量："+getGood.getCount());
        System.out.println("----------------------Transfer Object Pattern Test End--------------------");
    }
}
