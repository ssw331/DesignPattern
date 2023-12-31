package amusementpark.workers;
import java.util.ArrayList;
import java.util.List;

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

    public void delegateTask(Task task, AreaManager manager) {
        System.out.println("园长将任务委派给区长：" + manager.getName());
        manager.handleTask(task);
    }

    @Override
    public void displayDetails() {
        System.out.println(position + ": " + name);
        for (AreaManager manager : areaManagers) {
            manager.displayDetails();
        }
    }
}

