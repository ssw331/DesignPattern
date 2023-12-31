package parkManage.Composite;

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

    @Override
    public void displayDetails() {
        System.out.println(position + ": " + name + ", 上司园长是: " + (supervisor != null ? supervisor.name : "None"));
        for (TeamLeader leader : teamLeaders) {
            leader.displayDetails();
        }
    }
}
