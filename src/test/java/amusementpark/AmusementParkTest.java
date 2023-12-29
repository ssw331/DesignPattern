package amusementpark;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import amusementpark.blackboard.BlackBoard;
import amusementpark.service.NewsService;
import amusementpark.workers.*;
import amusementpark.security.*;
import amusementpark.service.*;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class AmusementParkTest {

    @BeforeEach
    public void beforeEach() {
        System.out.println();
        System.out.println("*****************************【园区管理子系统】****************************");
        System.out.println();
    }

    /**
     * 测试黑板模式
     */
    @Test
    @Order(1)
    public void testBlackBoardPattern(){
        System.out.println("*****************************【黑板模式展示】****************************");
        System.out.println("# 黑板模式通常用于问题的解决，其中多个组件独立地向一个公共知识源（即“黑板”）贡献数据和处理逻辑。");
        System.out.println("# 在黑板模式中，有三个主要组成部分：黑板（Blackboard）、知识源（Knowledge Source）和控制组件（Control Component）。黑板是一个共享的数据存储区域，知识源是负责向黑板添加信息的组件，控制组件监视并处理从黑板中获得的信息。");
        System.out.println("# 这种模式通常在处理复杂问题、机器学习、专家系统以及需要多个组件协作解决问题的应用中使用。");
        System.out.println("**********************************************************************");
        System.out.println();

        System.out.println("---------------------------黑板模式测试开始----------------------------");
        System.out.println("使用黑板模式创建公告板");
        System.out.println("---------------------------------------------------------------------");
        BlackBoard blackboard = new BlackBoard();
        NewsService rideService = new NewsService(blackboard);
        NewsService restaurantService = new NewsService(blackboard);
        System.out.println("公告板创建完成，向公告板上添加信息");

        rideService.publishUpdate("过山车项目运营中!");
        restaurantService.publishUpdate("园区餐厅上新!");

        String expectedMessage1 = "过山车项目运营中!";
        String expectedMessage2 = "园区餐厅上新!";
        blackboard.displayMessages();
        List<String> message=blackboard.getMessage();

        System.out.println("测试公告是否来自公告板");
        Assertions.assertTrue(message.contains(expectedMessage1));
        Assertions.assertTrue(message.contains(expectedMessage2));
        System.out.println("得到的公告来自公告板");
        System.out.println("---------------------------黑板模式测试结束----------------------------");
        System.out.println();

    }

    /**
     * 测试组合模式
     */
    @Test
    @Order(2)
    public void testCompositePattern() {
        System.out.println("*****************************【组合模式展示】****************************");
        System.out.println("# 组合模式是一种结构设计模式，用于将对象组合成树状结构以表示部分-整体层次结构。它允许客户端以一致的方式处理个体对象和组合对象。");
        System.out.println("# 在组合模式中，有三个主要角色：组件（Component）、叶子（Leaf）和复合（Composite）。组件是组合中的抽象基类，叶子表示个体对象，复合表示包含子组件的对象。");
        System.out.println("# 这种模式使得客户端能够统一处理单个对象和组合对象，非常适用于处理树状结构数据、图形界面和文件系统等。");
        System.out.println("**********************************************************************");
        System.out.println();

        System.out.println("---------------------------组合模式测试开始----------------------------");
        System.out.println("创建园长、区长、组长、员工");
        System.out.println("---------------------------------------------------------------------");
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

        System.out.println("---------------------------组合模式测试结束----------------------------");
        System.out.println();

    }

    /**
     * 测试委托模式
     */
    @Test
    @Order(3)
    public void testDelegationPattern(){
        System.out.println("*****************************【委托模式展示】****************************");
        System.out.println("# 委托模式是一种对象行为模式，用于允许一个对象（委托对象）代表另一个对象执行某些操作。它允许客户端将请求委托给不同的对象，从而提高了系统的灵活性和可扩展性。");
        System.out.println("# 在委托模式中，有两个主要角色：委托（Delegate）和被委托者（Delegator）。委托者将请求委托给委托对象来执行实际操作。");
        System.out.println("# 这种模式通常用于分离责任、实现回调机制、事件处理以及扩展现有类的功能。");
        System.out.println("**********************************************************************");
        System.out.println();

        System.out.println("---------------------------组合模式测试开始----------------------------");
        System.out.println("创建日常任务");
        System.out.println("---------------------------------------------------------------------");

        System.out.println("园长将日常管理任务委托给区长");

        AreaManager manager = new AreaManager("Alice");
        ParkManager director = new ParkManager("Bob");

        Task dailyTask = new DailyManagementTask();
        director.delegateTask(dailyTask,manager);

        System.out.println("---------------------------组合模式测试结束----------------------------");
        System.out.println();
    }

    /**
     * 测试观察者模式
     */
    @Test
    @Order(4)
    public void testObserverPattern(){
        System.out.println("*****************************【观察者模式展示】****************************");
        System.out.println("# 观察者模式是一种行为设计模式，用于定义对象之间的一对多依赖关系，使得当一个对象状态改变时，所有依赖于它的对象都会自动收到通知并更新。");
        System.out.println("# 在观察者模式中，有两个主要角色：主题（Subject）和观察者（Observer）。主题维护一组观察者，并通知它们关于状态变化的信息。观察者订阅主题，并在主题发生改变时接收通知并执行相应操作。");
        System.out.println("# 这种模式在实现松耦合、分布式事件处理以及构建可维护和可扩展系统时非常有用。");
        System.out.println("**********************************************************************");
        System.out.println();


        System.out.println("---------------------------观察者模式测试开始----------------------------");
        System.out.println("创建园长、区长、组长、员工");
        System.out.println("---------------------------------------------------------------------");

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
        System.out.println("---------------------------观察者模式测试结束----------------------------");
        System.out.println();
    }

    /**
     * 测试命令模式
     */
    @Test
    @Order(5)
    public void testCommandPattern() {
        System.out.println("*****************************【命令模式展示】****************************");
        System.out.println("# 命令模式是一种行为设计模式，用于将请求或操作封装成一个对象，从而使我们能够参数化客户端操作，将方法调用、请求或操作排队、记录日志或者支持可撤销操作。");
        System.out.println("# 在命令模式中，有四个主要角色：命令接口（Command）、具体命令（Concrete Command）、调用者（Invoker）和接收者（Receiver）。命令接口定义了命令的执行方法，具体命令将具体操作封装成对象，调用者负责执行命令，接收者执行具体操作。");
        System.out.println("# 这种模式在构建具有可扩展性的命令处理系统、事务管理以及实现支持撤销和重做功能的应用程序中非常有用。");
        System.out.println("**********************************************************************");
        System.out.println();

        System.out.println("---------------------------命令模式测试开始----------------------------");
        System.out.println("创建园长、区长、组长、员工");
        System.out.println("---------------------------------------------------------------------");

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

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("请输入你想要执行的操作：");
            System.out.println("1. 打开摄像头");
            System.out.println("2. 关闭摄像头");
            System.out.println("3. 打开红外线感应器");
            System.out.println("4. 关闭红外线感应器");
            System.out.println("5. 打开门锁");
            System.out.println("6. 关闭门锁");
            System.out.println("7. 退出");
            int choice = scanner.nextInt();
            switch (choice) {
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


            System.out.println("---------------------------命令模式测试结束----------------------------");
            System.out.println();
        }
    }

    /**
     * 测试发布订阅模式
     */
    @Test
    @Order(6)
    public void testPublishSubscribPattern(){
        System.out.println("*****************************【发布-订阅模式展示】****************************");
        System.out.println("# 发布-订阅模式是一种行为设计模式，用于实现对象之间的松耦合通信，其中一组发布者对象将事件发送给一组订阅者对象，而订阅者只关注它们感兴趣的事件。");
        System.out.println("# 在发布-订阅模式中，有三个主要角色：发布者（Publisher）、订阅者（Subscriber）和事件（Event）。发布者负责发布事件，订阅者订阅感兴趣的事件并在事件发生时接收通知。");
        System.out.println("# 这种模式支持松耦合、分布式系统、事件驱动架构以及解耦复杂系统中的组件通信。");
        System.out.println("**********************************************************************");
        System.out.println();

        System.out.println("---------------------------发布订阅模式测试开始----------------------------");
        System.out.println("创建园长、区长、组长、员工");
        System.out.println("---------------------------------------------------------------------");

        QueueLength rollerCoasterQueue = new QueueLength();
        Tourist alice = new Tourist("Alice");
        Tourist bob = new Tourist("Bob");

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
        System.out.println("---------------------------发布订阅模式测试结束----------------------------");
        System.out.println();
    }
}
