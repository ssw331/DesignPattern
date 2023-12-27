package TourBusStationSubSystem.VisitAnimalAreaSubSystem.Mediator;
import java.util.Date;
import java.util.HashMap;

/**
 * @title: Mediator
 * @Author Xinyu Fang
 * @Date: 2022/12/10 11:13
 * @Version 1.0
 */
public class Mediator {
    public static HashMap<String, String> monitorInfo = new HashMap<>();


    /**
     * @Desc: 向显示器上新加进馆游客
     * @Param: 管理员名称和设施
     * @Return: 无
     */
    public static void addGuest(Admin admin, Facility facility, int num) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(new Date().toString() + " [" +
        admin.getName() + "] : " + facility.getName() +" "+num + " 个游客进馆");
        try {
            Thread.sleep(400);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        monitorInfo.put(facility.getLocation()+" "+facility.getName(), facility.getCurrentNum()+"/"+facility.getCapacity());

        try {
            Thread.sleep(400);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        showMonitorBoard();
        try {
            Thread.sleep(400);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    /**
     * @Desc: 向显示器上删去出馆游客
     * @Param: 管理员名称和设施名称
     * @Return: 无
     */
        public static void removeGuest(Admin admin, Facility facility, int num) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(new Date().toString() + " [" +
                admin.getName() + "] : " + facility.getName() +" "+num + " 个游客离馆");
        try {
            Thread.sleep(400);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        monitorInfo.put(facility.getLocation()+" "+facility.getName(), facility.getCurrentNum()+"/"+facility.getCapacity());

        try {
            Thread.sleep(400);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        showMonitorBoard();
        try {
            Thread.sleep(400);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    /**
     * @Desc: 格式化输出目前各馆流量
     * @Param: 无
     * @Return: 无
     */
    public static void showMonitorBoard() {
        System.out.println("==============================");
        System.out.println("        实时流量监控        ");
        for (String fac : monitorInfo.keySet()) {
            System.out.println(fac + " : " + monitorInfo.get(fac));
        }
        System.out.println("==============================");

    }
}
