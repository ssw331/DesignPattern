package parkManage.BlackBoard;

public class ParkService {
    private final Blackboard blackboard;

    public ParkService(Blackboard blackboard) {
        this.blackboard = blackboard;
    }

    public void publishUpdate(String update) {
        blackboard.postMessage("园区服务信息更新: " + update);
    }
}
