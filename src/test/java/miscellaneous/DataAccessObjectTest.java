package miscellaneous;
import miscellaneous.DataAccessObject.Employee;
import miscellaneous.DataAccessObject.EmployeeDaoImpl;

import java.util.List;

public class DataAccessObjectTest {

//    public static void main(String[] args) {
//        dataAccessObjectTest();
//    }
    public void dataAccessObjectTest(){
        System.out.println("*****************************【数据访问对象模式展示】****************************");
        System.out.println("# 数据访问对象模式（Data Access Object Pattern）或 DAO 模式用于把低级的数据访问 API 或操作从高级的业务服务中分离出来。");
        System.out.println("# 以下代码展示了如何使用数据访问对象模式来获取数据，实现了对数据的一些操作。");
        System.out.println("************************************************************************");
        System.out.println("下面通过展示数据访问对象模式的使用来展示实际业务中数据访问对象模式的使用。");
        System.out.println("----------------------Data Access Object Pattern miscellaneous.Test Start--------------------");
        EmployeeDaoImpl employeeDao = new EmployeeDaoImpl();
        int cielId = employeeDao.addEmployee("Ciel", "男",8000);
        employeeDao.addEmployee("Alice","女",10000);
        employeeDao.addEmployee("Linda","女",2000);
        List<Employee> list =employeeDao.getEmployeesByGender("女");
        for(Employee e:list){
            employeeDao.toString(e);
        }
        list=employeeDao.getAllEmployees();
        for(Employee e:list){
            employeeDao.toString(e);
        }
        employeeDao.updateSalary(cielId, 12000);
        employeeDao.deleteEmployee(cielId);
        System.out.println("----------------------Data Access Object Pattern miscellaneous.Test End--------------------");
    }
}