package DataAccessObject;

import java.util.List;

//对员工管理的操作接口
public interface EmployeeDao {
    public List<Employee> getAllEmployees();
    public List<Employee> getEmployeesByGender(String gender);
    public Employee getEmployee(int id);
    public void updateSalary(int id, double salary);
    public void deleteEmployee(int id);
    public int addEmployee(String name,String gender ,double salary);
    public void toString(Employee e);
}
