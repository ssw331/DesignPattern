package Delegation;

/*具体的日常管理任务*/
public class DailyManagement implements Task {
    @Override
    public void performTask() {
        System.out.println("执行日常管理任务.");
    }
}
