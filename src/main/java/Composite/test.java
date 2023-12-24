package Composite;

public class test {
    public static void main(String[] args) {
        System.out.println("**********************************************");
        System.out.println("组合模式（Composite Pattern）用于将对象组合成树形结构以表示部分-整体层次结构,它允许客户统一对待个别对象和组合对象。\n在游乐园管理层架构的场景中，可以使用组合模式来表示不同级别的管理和员工");
        System.out.println("**********************************************");
        ParkManager parkManager = new ParkManager("Alice");

        AreaManager areaManager1 = new AreaManager("Bob");
        AreaManager areaManager2 = new AreaManager("Charlie");

        TeamLeader teamLeader1 = new TeamLeader("David");
        TeamLeader teamLeader2 = new TeamLeader("Eve");

        Staff staff1 = new Staff("Frank");
        Staff staff2 = new Staff("Grace");
        Staff staff3 = new Staff("Hank");
        Staff staff4 = new Staff("Ivy");

        parkManager.addAreaManager(areaManager1);
        parkManager.addAreaManager(areaManager2);

        areaManager1.addTeamLeader(teamLeader1);
        areaManager2.addTeamLeader(teamLeader2);

        teamLeader1.addTeamMember(staff1);
        teamLeader1.addTeamMember(staff2);
        teamLeader2.addTeamMember(staff3);
        teamLeader2.addTeamMember(staff4);

        parkManager.displayDetails();
    }
}
