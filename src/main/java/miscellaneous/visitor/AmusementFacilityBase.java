package miscellaneous.visitor;

/**
 * @program:DesignPattern
 * @author: Xiang Lei
 * @email: xiang.lei.se@foxmail.com
 * @time: 2023/12/18  23:14
 * @description: 游乐设施接口
 */
public interface AmusementFacilityBase {

    void accept(Visitor visitor);

}
