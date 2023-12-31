package amusementpark.workers;

import amusementpark.workers.Task;

public class DailyManagementTask implements Task {
    @Override
    public void performTask() {
        System.out.println("执行日常管理任务.");
    }
}
