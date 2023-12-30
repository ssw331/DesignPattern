package floralParade.Strategy;

/*
 * @Author XiaoJunLv
 * @Date 2023/12/19
 * */
/* *
 * 环境类，用于运行花车时间排表
 */
public class CarScheduleContext {
    private TimeScheduleStrategy timeScheduleStrategy;

    public void setTimeScheduleStrategy(TimeScheduleStrategy timeScheduleStrategy) {
        this.timeScheduleStrategy = timeScheduleStrategy;
    }

    public void arrangeCarSchedule() {
        if (timeScheduleStrategy != null) {
            timeScheduleStrategy.schedule();
        } else {
            System.out.println("未设置时间安排策略");
        }
    }
}
