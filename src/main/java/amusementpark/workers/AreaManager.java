package amusementpark.workers;

import java.util.ArrayList;
import java.util.List;

public class AreaManager extends Employee{
    private final List<TeamLeader> teamLeaders;

    public AreaManager(String name) {
        super(name, "【区长】");
        this.teamLeaders = new ArrayList<>();
    }

    public void addTeamLeader(TeamLeader leader) {
        teamLeaders.add(leader);
        leader.setSupervisor(this);
    }

    public void handleTask(Task task) {
        System.out.println("区长执行任务.");
        task.performTask();
    }

    @Override
    public void displayDetails() {
        System.out.println(position + ": " + name + ", 上司园长是: " + (supervisor != null ? supervisor.name : "None"));
        for (TeamLeader leader : teamLeaders) {
            leader.displayDetails();
        }
    }
}