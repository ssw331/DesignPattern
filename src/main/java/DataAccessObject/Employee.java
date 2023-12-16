package DataAccessObject;

//员工类
public class Employee {
    private int id;
    private String name;
    private String gender;//性别
    private double salary;//薪资
    //constructor
    Employee(int id, String name, String gender, double salary){
        this.id = id;
        this.name = name;
        this.gender=gender;
        this.salary = salary;
    }
    //getter&setter
    public int getId(){
        return this.id;
    }
    public String getName(){
        return this.name;
    }
    public String getGender(){return this.gender;}
    public double getSalary(){
        return salary;
    }
    public void setSalary(double salary){
        this.salary = salary;
    }
}
