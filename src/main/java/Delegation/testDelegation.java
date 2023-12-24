package Delegation;

public class testDelegation {
    public static void main(String[] args) {
        System.out.println("委托模式测试：园长将日常管理任务委托给区长");
        System.out.println("委托体现：园长类中使用delegateTask方法将相应任务委托给区长");
        ParkSectionManager manager = new ParkSectionManager();
        ParkDirector director = new ParkDirector(manager);

        Task dailyTask = new DailyManagement();
        director.delegateTask(dailyTask);
    }
}
