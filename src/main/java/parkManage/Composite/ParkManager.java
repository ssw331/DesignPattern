package parkManage.Composite;

import java.util.ArrayList;
import java.util.List;

// 园长，有一些下属
public class ParkManager extends Employee {
    private final List<AreaManager> areaManagers;

    public ParkManager(String name) {
        super(name, "【园长】");
        this.areaManagers = new ArrayList<>();
    }

    public void addAreaManager(AreaManager manager) {
        areaManagers.add(manager);
        manager.setSupervisor(this);
    }

    @Override
    public void displayDetails() {
        System.out.println(position + ": " + name);
        for (AreaManager manager : areaManagers) {
            manager.displayDetails();
        }
    }
}
