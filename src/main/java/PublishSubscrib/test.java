package PublishSubscrib;

public class test {
    public static void main(String[] args) {
        System.out.println("**********************************************");
        System.out.println("发布-订阅模式是一种消息传递范式，其中发布者（发布消息的实体）并不直接将消息发送给特定的订阅者（接收消息的实体），\n而是发布（发布）消息到一个话题或频道。订阅者订阅这些话题或频道，以便接收相关消息。\n在游乐园队伍长度通知的情景中，可以实现一个简单的发布-订阅系统，让游客订阅特定游乐设施的队伍长度更新");
        System.out.println("**********************************************");
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
    }
}
