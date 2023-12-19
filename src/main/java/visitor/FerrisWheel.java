package visitor;

/**
 * @program:DesignPattern
 * @author: Xiang Lei
 * @email: xiang.lei.se@foxmail.com
 * @time: 2023/12/18  23:22
 * @description: 游乐设施 - 摩天轮
 */
public class FerrisWheel implements AmusementFacilityBase {

    @Override
    public void accept(Visitor visitor) {
        visitor.visitFerrisWheel(this);
    }

    public void play() {
    }

}
