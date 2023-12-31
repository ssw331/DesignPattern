package amusementpark.workers;

import java.util.ArrayList;
import java.util.List;

public abstract class Employee {
    protected String name;
    protected String position;
    protected Employee supervisor;

    public Employee(String name, String position) {
        this.name = name;
        this.position = position;
        this.supervisor = null;
    }

    public void setSupervisor(Employee supervisor) {
        this.supervisor = supervisor;
    }

    public abstract void displayDetails();

    protected String getName() {
        return name;
    }
}
