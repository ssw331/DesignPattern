package parkManage.BlackBoard;

import java.util.ArrayList;
import java.util.List;
public class Blackboard {
    private final List<String> messages = new ArrayList<>();

    public void postMessage(String message) {
        messages.add(message);
        System.out.println("新消息公告: " + message);
    }

    public void displayMessages() {
        System.out.println("\n当前公告板上信息:");
        for (String message : messages) {
            System.out.println("- " + message);
        }
    }
}
