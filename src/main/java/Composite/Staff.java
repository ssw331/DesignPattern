package Composite;

// 普通员工，没有下属
public class Staff extends Employee{
    public Staff(String name) {
        super(name, "【员工】");
    }

    @Override
    public void displayDetails() {
        System.out.println(position + ": " + name + ", 上司组长是: " + (supervisor != null ? supervisor.name : "None"));
    }
}
