package Delegation;

/*园长类*/
public class ParkDirector {
    private ParkSectionManager sectionManager;

    public ParkDirector(ParkSectionManager sectionManager) {
        this.sectionManager = sectionManager;
    }

    public void delegateTask(Task task) {
        System.out.println("园长将任务委派给区长.");
        sectionManager.handleTask(task);
    }
}
