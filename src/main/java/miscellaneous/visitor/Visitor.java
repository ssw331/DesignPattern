package miscellaneous.visitor;

/**
 * @program:DesignPattern
 * @author: Xiang Lei
 * @email: xiang.lei.se@foxmail.com
 * @time: 2023/12/18  23:15
 * @description: 访问者接口
 */
public interface Visitor {

    void visitRollerCoaster(RollerCoaster rollerCoaster);  // 访问过山车

    void visitFerrisWheel(FerrisWheel ferrisWheel);  // 访问摩天轮

    void visitMerryGoRound(MerryGoRound merryGoRound);  // 访问旋转木马

}

