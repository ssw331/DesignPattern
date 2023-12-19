package Strategy;

/*
 * @Author XiaoJunLv
 * @Date 2023/12/19
 * */
/* *
 * 测试样例类
 */
public class StrategyPatternExample {
    public static void main(String[] args) {
        // 创建环境类
        CarScheduleContext context = new CarScheduleContext();

        // 设置节假日花车巡游策略
        context.setTimeScheduleStrategy(new HolidaySchedule());
        // 安排花车时间
        context.arrangeCarSchedule();

        System.out.println();

        // 设置特殊活动花车巡游策略
        context.setTimeScheduleStrategy(new SpecialEventSchedule());
        // 安排花车时间
        context.arrangeCarSchedule();
    }
}
