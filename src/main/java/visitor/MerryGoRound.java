package visitor;

/**
 * @program:DesignPattern
 * @author: Xiang Lei
 * @email: xiang.lei.se@foxmail.com
 * @time: 2023/12/18  23:22
 * @description: 游乐设施 - 旋转木马
 */
public class MerryGoRound implements AmusementFacilityBase {

    @Override
    public void accept(Visitor visitor) {
        visitor.visitMerryGoRound(this);
    }

    public void play() {
    }

}
