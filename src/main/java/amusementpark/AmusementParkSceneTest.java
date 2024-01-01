package amusementpark;

import amusementpark.blackboard.BlackBoard;
import amusementpark.security.*;
import amusementpark.service.QueueLengthSubscribe;
import amusementpark.service.NewsService;
import amusementpark.workers.*;

import java.util.Scanner;

public class AmusementParkSceneTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("---------------------------------------------------------------------");
        System.out.println("欢迎来到游乐园园区管理模块场景测试：");
        System.out.println("在本子系统中，你可以模拟工作人员进行园区管理相关工作哦");
        System.out.println("---------------------------------------------------------------------");



        System.out.println("滴！打卡成功，早安打工人，请选择你的工作任务吧~");
        System.out.println(
                """
                1.我是园长：我要把任务交给我手下的区长干！（委托模式）
                2.我是安保部门人员：监管一下安保系统设备状态（命令模式）
                3.我是维修人员：监控一下游乐设施的状态（观察者模式）
                4.我是管理人员：更新一下公告报上的公告吧（黑板模式）
                5.我是个软件开发者：修一下排队进度订阅软件的bug吧（发布订阅模式）
                6.啊？我就是个路人：查看一下园区管理层结构（组合模式）
                7.下班了！（退出）
                """
        );
        String choice= null;
        while(choice == null){
            System.out.println("请输入您选择的任务：");
            choice = scanner.nextLine();
            while (choice.isEmpty()) {
                choice = scanner.nextLine();
            }
            switch (choice.charAt(0)) {
                case '1' -> {System.out.println("园长将日常管理任务委托给区长");

                    amusementpark.workers.AreaManager manager = new amusementpark.workers.AreaManager("Alice");
                    amusementpark.workers.ParkManager director = new amusementpark.workers.ParkManager("Bob");

                    Task dailyTask = new DailyManagementTask();
                    director.delegateTask(dailyTask,manager);}
                case '2' -> {
                    // 创建安保设备
                    SecurityDevice camera = new Camera();
                    SecurityDevice infraredSensor = new InfraredSensor();
                    SecurityDevice doorLock = new DoorLock();

                    // 创建命令
                    Command turnOnCamera = new TurnOnCommand(camera);
                    Command turnOffCamera = new TurnOffCommand(camera);
                    Command turnOnInfraredSensor = new TurnOnCommand(infraredSensor);
                    Command turnOffInfraredSensor = new TurnOffCommand(infraredSensor);
                    Command turnOnDoorLock = new TurnOnCommand(doorLock);
                    Command turnOffDoorLock = new TurnOffCommand(doorLock);

                    // 创建一个命令的调用者
                    SecurityControl control = new SecurityControl();

                    for (int choice2 = 1; choice2 <= 7; choice2++) {
                        System.out.println("请输入你想要执行的操作：");
                        System.out.println("1. 打开摄像头");
                        System.out.println("2. 关闭摄像头");
                        System.out.println("3. 打开红外线感应器");
                        System.out.println("4. 关闭红外线感应器");
                        System.out.println("5. 打开门锁");
                        System.out.println("6. 关闭门锁");
                        System.out.println("7. 退出");
                        switch (choice2) {
                            case 1:
                                control.setCommand(turnOnCamera);
                                break;
                            case 2:
                                control.setCommand(turnOffCamera);
                                break;
                            case 3:
                                control.setCommand(turnOnInfraredSensor);
                                break;
                            case 4:
                                control.setCommand(turnOffInfraredSensor);
                                break;
                            case 5:
                                control.setCommand(turnOnDoorLock);
                                break;
                            case 6:
                                control.setCommand(turnOffDoorLock);
                                break;
                            case 7:
                                System.out.println("退出系统...");
                                scanner.close();
                                return;
                            default:
                                System.out.println("无效的输入，请重新输入！");
                                continue;
                        }
                        System.out.println("正在执行操作...");
                        control.pressButton();

                    }
                }
                case '3' -> {
                    Facility rollerCoaster = new Facility("过山车");
                    Facility ferrisWheel = new Facility("摩天轮");
                    Observer maintenanceDepartment = new MaintenanceDepartment();
                    Observer securityDepartment = new SecurityDepartment();

                    rollerCoaster.addObserver(maintenanceDepartment);
                    rollerCoaster.addObserver(securityDepartment);
                    ferrisWheel.addObserver(maintenanceDepartment);
                    ferrisWheel.addObserver(securityDepartment);

                    rollerCoaster.setStatus("运行中");

                    ferrisWheel.setStatus("故障");
                }
                case '4' ->{

                    BlackBoard blackboard = new BlackBoard();
                    NewsService rideService = new NewsService(blackboard);
                    NewsService restaurantService = new NewsService(blackboard);

                    rideService.publishUpdate("过山车项目运营中!");
                    restaurantService.publishUpdate("园区餐厅上新!");

                    blackboard.displayMessages();

                }
                case '5' ->{
                    QueueLengthSubscribe rollerCoasterQueue = new QueueLengthSubscribe();
                    amusementpark.Tourist alice = new amusementpark.Tourist("Alice");
                    amusementpark.Tourist bob = new Tourist("Bob");

                    // Alice和Bob订阅rollercoaster的排队人数
                    rollerCoasterQueue.subscribe(alice);
                    rollerCoasterQueue.subscribe(bob);

                    // Update queue length, which notifies all subscribers
                    System.out.println("更新排队人数为5人...");
                    rollerCoasterQueue.setQueueLength(5);

                    // Bob取消订阅
                    rollerCoasterQueue.unsubscribe(bob);

                    //只有Alice收到订阅消息
                    System.out.println("更新排队人数为3人");
                    rollerCoasterQueue.setQueueLength(3);
                }
                case '6' -> {
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
                case '7' -> {
                    return;
                }
                default -> System.out.println("输入错误，请重新输入");
            }

        }



    }

}
