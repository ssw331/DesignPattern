package Composite;

import java.util.ArrayList;
import java.util.List;

// 组长，有一些下属
public class TeamLeader extends Employee{
    private final List<Employee> teamMembers;

    public TeamLeader(String name) {
        super(name, "【组长】");
        this.teamMembers = new ArrayList<>();
    }

    public void addTeamMember(Employee member) {
        teamMembers.add(member);
        member.setSupervisor(this);
    }

    @Override
    public void displayDetails() {
        System.out.println(position + ": " + name + ", 上司区长是: " + (supervisor != null ? supervisor.name : "None"));
        for (Employee member : teamMembers) {
            member.displayDetails();
        }
    }
}
