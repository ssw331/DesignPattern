package observer;
/**
 * @author WWWsy
 */
public class ObserverTest {
    public static void main(String[] args) {
        Facility rollerCoaster = new Facility("过山车");
        Facility ferrisWheel = new Facility("摩天轮");
        Observer maintenanceDepartment = new MaintenanceDepartment();
        Observer securityDepartment = new SecurityDepartment();

        rollerCoaster.addObserver(maintenanceDepartment);
        rollerCoaster.addObserver(securityDepartment);
        ferrisWheel.addObserver(maintenanceDepartment);
        ferrisWheel.addObserver(securityDepartment);

        rollerCoaster.setStatus("运行中");

        ferrisWheel.setStatus("故障");
    }
}
