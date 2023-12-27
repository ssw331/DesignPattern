package TourBusStationSubSystem.VisitAnimalAreaSubSystem.Mediator;


/**
 *  @author Xinyu Fang
 *  @version 1.0
 *  @title: Admin
 */
public class Admin {
    private String name;

    /**
     * @Desc: 获得管理员姓名
     * @Param: 无
     * @Return: 管理员姓名
     */
    public String getName() {
        return name;
    }

    /**
     * @Desc: 设置管理员姓名
     * @Param: 管理员姓名
     * @Return: 无
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @Desc: 管理员构造函数
     * @Param: 姓名
     * @Return: 无
     */
    public Admin(String name) {
        this.name = name;
    }

    /**
     * @Desc: 管理员获得通知之后向显示器上加入某场馆进馆人数
     * @Param: 设备,进馆人数
     * @Return: 无
     */
    public void addGuest(Facility facility,int enterNum) {
        facility.setCurrentNum(facility.getCurrentNum() + enterNum);
        Mediator.addGuest(this, facility, enterNum);
    }

    /**
     * @Desc: 管理员获得通知之后向显示器上减去某场馆出馆人数
     * @Param: 设备,出馆人数
     * @Return: 无
     */
    public void popGuest(Facility facility,int exitNum) {
        facility.setCurrentNum(facility.getCurrentNum() - exitNum);
        Mediator.removeGuest(this, facility, exitNum);
    }


}
