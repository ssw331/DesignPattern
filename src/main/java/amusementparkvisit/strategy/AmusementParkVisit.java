package amusementparkvisit.strategy;

/**
 * @title: AmusementParkVisit
 * @Author Kexian Tang
 * @Date: 2023/12/15
 * @Version 1.0
 * @description: 游乐园参观上下文
 */
public class AmusementParkVisit {
    private VisitStrategy visitStrategy;

    public AmusementParkVisit(VisitStrategy visitStrategy){
        this.visitStrategy = visitStrategy;
    }

    public void setVisitStrategy(VisitStrategy visitStrategy) {
        this.visitStrategy = visitStrategy;
    }

    public void experienceRide(){
        visitStrategy.visitMethod();
    }
}