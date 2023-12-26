package Delegation;

/*区长类*/
public class ParkSectionManager {
    public void handleTask(Task task) {
        System.out.println("区长执行任务.");
        task.performTask();
    }
}
