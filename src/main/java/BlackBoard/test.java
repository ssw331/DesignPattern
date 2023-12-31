package BlackBoard;

public class test {
    public static void main(String[] args) {
        System.out.println("**********************************************");
        System.out.println("黑板模式（Blackboard Pattern）通常用于问题的解决，其中多个组件独立地向一个公共知识源（即“黑板”）贡献数据和处理逻辑。\n在游乐园公告的情景中，可以将黑板视为公告板，而各种服务或活动可以作为独立组件，向黑板发布消息。");
        System.out.println("**********************************************");
        Blackboard blackboard = new Blackboard();
        ParkService rideService = new ParkService(blackboard);
        ParkService restaurantService = new ParkService(blackboard);

        rideService.publishUpdate("过山车项目运营中!");
        restaurantService.publishUpdate("园区餐厅上新!");

        blackboard.displayMessages();
    }
}
