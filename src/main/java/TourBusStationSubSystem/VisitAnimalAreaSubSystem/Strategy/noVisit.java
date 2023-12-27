package TourBusStationSubSystem.VisitAnimalAreaSubSystem.Strategy;

/**
 * @title: noVisit
 * @Author Xinyu Fang
 * @Date: 2022/12/10 14:02
 * @Version 1.0
 */
public class noVisit implements VisitCampus {
    @Override
    public void visitMethod() {
        System.out.println("游客没有近距离参观狮虎山，远眺后离开园区");
    }
}