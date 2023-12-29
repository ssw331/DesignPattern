package amusementpark.service;
import amusementpark.blackboard.BlackBoard;
public class NewsService {
    private final BlackBoard blackboard;

    public NewsService(BlackBoard blackboard) {
        this.blackboard = blackboard;
    }

    public void publishUpdate(String update) {
        blackboard.postMessage("园区服务信息更新: " + update);
    }
}
