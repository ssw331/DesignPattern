package parkManage.Composite;

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
}
