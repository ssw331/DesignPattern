package DataAccessObject;

import java.util.List;

/**
 * @author Bestom
 *
 * 游乐场的员工类的数据操作接口类
 */
public interface EmployeeDao {
    public List<Employee> getAllEmployees();
    public Employee getEmployee(int id);
    public void updateEmployee(int id, double salary);
    public void deleteEmployee(int id);
    public int addEmployee(String name, double salary);
}
