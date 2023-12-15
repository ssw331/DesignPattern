package TransferObject;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Bestom
 *
 * 设施业务对象
 */

public class GoodsBusinessObject {
    private Map<Integer,GoodsTransferObject> goodMap;

    /**
     * GoodBusinessObject构造器
     */
    public GoodsBusinessObject(){
        goodMap = new HashMap<Integer, GoodsTransferObject>();

        System.out.printf("GoodBusinessObject构造器\n");
    }

    /**
     * 添加货物
     */
    public void addGood(GoodsTransferObject good){
        goodMap.put(good.getId(),good);

        System.out.printf("添加货物\n");
    }

    /**
     * 移除货物
     */
    public void deleteGood(GoodsTransferObject good){
        goodMap.remove(good.getId());

        System.out.printf("移除货物\n");
        System.out.println(good.getName()+" 已经被移除\n");
    }

    /**
     * 获取货物表
     */
    public Map<Integer,GoodsTransferObject> getAllGoods(){

        System.out.printf("获取货物表\n");
        return goodMap;
    }

    /**
     * 获取货物信息
     */
    public GoodsTransferObject getGood(int id){

        System.out.printf("获取货物信息\n");
        return goodMap.get(id);
    }

    /**
     * 更新货物数据
     */
    public void updateGood(GoodsTransferObject good){
        System.out.printf("更新货物数据\n");

        goodMap.put(good.getId(),good);
        System.out.println("货物数据已更新\n");
    }
}