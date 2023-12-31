import FloralParade.FloralParadeScene;
import TourBusStationSubSystem.TourBusStationSceneAdminTest;
import TourBusStationSubSystem.TourBusStationSceneTouristTest;
import amusementparkvisit.AmusementParkVisitSceneTest;
import miscellaneous.MiscellaneousScene;
import restaurant.RestaurantTest;
import ticket.TicketSceneTest;

import java.util.Scanner;

public class AllScene {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println(
                """
                        欢迎来到游乐园，以下是场景测试菜单
                        1.票务系统
                        2.花车巡游
                        3.观光车
                        4.园区参观
                        5.餐厅
                        6.园区管理
                        7.其他
                        0.退出
                        """
        );

        String choice;

        input:
        while (true) {
            System.out.println("请输入菜单序号：");
            choice = scanner.nextLine();
            while (choice.isEmpty()) {
                choice = scanner.nextLine();
            }
            switch (choice.charAt(0)) {
                case '1' -> TicketSceneTest.main(args);
                case '2' -> FloralParadeScene.main(args);
                case '3' -> {
                    TourBusStationSceneAdminTest.main(args);
                    TourBusStationSceneTouristTest.main(args);
                }
                case '4' -> AmusementParkVisitSceneTest.main(args);
                case '5' -> new RestaurantTest().run();
//                case '6' -> ;
                case '7' -> MiscellaneousScene.main(args);
                case '0' -> {
                    System.out.println("----------------------演示结束----------------------");
                    break input;
                }
                default -> System.out.println("输入错误，请重新输入");
            }
        }
    }
}
