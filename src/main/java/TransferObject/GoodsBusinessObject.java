package TransferObject;

import java.util.HashMap;
import java.util.Map;
//货物操作类
public class GoodsBusinessObject {
    private Map<Integer,GoodsTransferObject> goodMap;//id→货物实体
    public GoodsBusinessObject(){
        goodMap = new HashMap<>();
        System.out.println("已构造GoodBusinessObject");
    }
    //增
    public void addGood(GoodsTransferObject good){
        goodMap.put(good.getId(),good);
        System.out.println("添加货物");
    }
    //删
    public void deleteGood(GoodsTransferObject good){
        goodMap.remove(good.getId());
        System.out.println("移除货物");
        System.out.println(good.getName()+" 已经被移除");
    }
    //获取全部货物
    public Map<Integer,GoodsTransferObject> getAllGoods(){
        System.out.println("获取货物表");
        return goodMap;
    }
    //通过id查找货物
    public GoodsTransferObject getGood(int id){
        System.out.println("获取货物信息");
        return goodMap.get(id);
    }
    public void updateGood(GoodsTransferObject good){
        System.out.println("更新货物数据");
        goodMap.put(good.getId(),good);
        System.out.println("货物数据已更新");
    }
}