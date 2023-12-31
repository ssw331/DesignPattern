package visitor;

/**
 * @program:DesignPattern
 * @author: Xiang Lei
 * @email: xiang.lei.se@foxmail.com
 * @time: 2023/12/18  23:23
 * @description: 访问者 - 管理员
 */
public class MaintenanceVisitor  implements Visitor{

    @Override
    public void visitRollerCoaster(RollerCoaster rollerCoaster) {
        System.out.println("管理员正在检查过山车");
        rollerCoaster.play();
    }

    @Override
    public void visitMerryGoRound(MerryGoRound merryGoRound) {
        System.out.println("管理员正在检查旋转木马");
        merryGoRound.play();
    }

    @Override
    public void visitFerrisWheel(FerrisWheel ferrisWheel) {
        System.out.println("管理员正在检查摩天轮");
        ferrisWheel.play();
    }

}
