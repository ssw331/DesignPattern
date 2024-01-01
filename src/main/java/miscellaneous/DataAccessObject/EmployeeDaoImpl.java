package miscellaneous.DataAccessObject;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author Bestom
 *
 * 游乐场的员工的数据操作类
 */
public class EmployeeDaoImpl implements EmployeeDao{

    /**
     * 列表当作数据库
     */
    private final List<Employee> employees;//存放员工列表
    private int nextId;//用于模拟数据库主键自增

    /**
     * 游乐场的员工的数据操作类的构造函数
     */
    public EmployeeDaoImpl(){
        employees = new ArrayList<>();
        nextId = 0;
    }

    //获取存放所有员工数据的列表
    @Override
    public List<Employee> getAllEmployees() {
        System.out.println("查找所有员工");
        return this.employees;
    }

    @Override
    public List<Employee> getEmployeesByGender(String gender) {
        System.out.println("查找所有性别为"+gender+"的员工: ");
        List<Employee> res=new ArrayList<>();
        for (Employee employee :this.employees) {
            if (Objects.equals(employee.getGender(), gender)) {
                res.add(employee);
            }
        }
        return res;
    }

    //通过id查找员工
    @Override
    public Employee getEmployee(int id) {

        System.out.println("查找员工: "+ id);
        for (Employee employee :this.employees) {
            if (employee.getId() == id) {
                return employee;
            }
        }
        return null;
    }

    //更新某个员工的工资
    @Override
    public void updateSalary(int id, double salary) {

        System.out.println("更新员工: "+ id + " 最新薪水: " + salary);
        for (Employee employee : this.employees) {
            if (employee.getId() == id) {
                employee.setSalary(salary);
                break;
            }
        }
    }

    //删除某个员工信息
    @Override
    public void deleteEmployee(int id) {

        System.out.println("删除员工: "+ id);
        for (int i=0;i<this.employees.size();++i) {
            if (this.employees.get(i).getId() == id) {
                this.employees.remove(i);
                break;
            }
        }
    }

    //新增某个员工信息
    @Override
    public int addEmployee(String name,String gender, double salary) {

        System.out.println("加入员工: "+name+" 性别为："+gender+" 薪水为: "+ salary);
        Employee newEmployee = new Employee(this.nextId++, name,gender, salary);
        this.employees.add(newEmployee);
        return newEmployee.getId();
    }

    @Override
    public void toString(Employee e) {
        System.out.println("员工："+e.getName()+" 性别："+e.getGender()+" 薪资："+e.getSalary());
    }
}
