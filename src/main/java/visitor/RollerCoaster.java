package visitor;

/**
 * @program:DesignPattern
 * @author: Xiang Lei
 * @email: xiang.lei.se@foxmail.com
 * @time: 2023/12/18  23:20
 * @description: 游乐设施 - 过山车
 */
public class RollerCoaster implements AmusementFacilityBase {

    @Override
    public void accept(Visitor visitor) {
        visitor.visitRollerCoaster(this);
    }

    public void play() {
    }

}
