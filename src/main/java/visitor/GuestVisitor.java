package visitor;

/**
 * @program:DesignPattern
 * @author: Xiang Lei
 * @email: xiang.lei.se@foxmail.com
 * @time: 2023/12/18  23:24
 * @description: 访问者 - 顾客
 */
public class GuestVisitor implements Visitor {

    @Override
    public void visitRollerCoaster(RollerCoaster rollerCoaster) {
        System.out.println("顾客正在玩过山车");
        rollerCoaster.play();
    }

    @Override
    public void visitFerrisWheel(FerrisWheel ferrisWheel) {
        System.out.println("顾客正在玩摩天轮");
        ferrisWheel.play();
    }

    @Override
    public void visitMerryGoRound(MerryGoRound merryGoRound) {
        System.out.println("顾客正在玩旋转木马");
        merryGoRound.play();
    }

}
