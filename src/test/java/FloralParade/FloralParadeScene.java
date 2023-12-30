package FloralParade;

import floralParade.Strategy.CarScheduleContext;
import floralParade.Strategy.HolidaySchedule;
import floralParade.Strategy.SpecialEventSchedule;

import java.util.Scanner;

public class FloralParadeScene {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("---------------------------------------------------------------------");
        System.out.println("欢迎进入花车巡游管理系统");
        System.out.println("---------------------------------------------------------------------");
        String strategy="";
        CarScheduleContext context = new CarScheduleContext();
        while(true) {
            System.out.println("请选择花车巡游的时间安排（1.节假日花车巡游 2.特殊活动花车巡游 0.退出）");
            if (scanner.hasNextLine()) {
                String ag = scanner.nextLine();
                String[] ags = ag.split(" ");
                if (ags.length != 1) {
                    System.out.println("参数输入不正确，请重新输入");
                    continue;
                }
                strategy = ags[0];
            }

            if(strategy.equals("1")){
                context.setTimeScheduleStrategy(new HolidaySchedule());
                context.arrangeCarSchedule();
            } else if (strategy.equals("2")) {
                // 设置特殊活动花车巡游策略
                context.setTimeScheduleStrategy(new SpecialEventSchedule());
                // 安排花车时间
                context.arrangeCarSchedule();
            } else if (strategy.equals("0")){
                System.out.println("退出花车巡游管理系统");
                break;
            } else{
                System.out.println("非法的花车时间安排");
            }
        }

    }
}
