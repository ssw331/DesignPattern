package mediator;

import mediator.queue.Queue;
import mediator.tourist.AnnualPassTourist;
import mediator.tourist.NormalTourist;
import mediator.tourist.Tourist;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * 中介者测试
 */
public class MediatorTest {
    @Test
    public void testMediator() {
        // 创建一个队列
        var rollarCosterQueue = new Queue();

        // 创建六名游客
        Tourist tom = new NormalTourist("Tom", 15);
        Tourist jack = new NormalTourist("Jack", 16);
        Tourist david = new NormalTourist("David", 15);
        Tourist bob = new NormalTourist("Bob", 17);

        Tourist alice = new AnnualPassTourist("Alice", 14);
        Tourist john = new AnnualPassTourist("John", 16);

        rollarCosterQueue.addTourist(tom);
        rollarCosterQueue.addTourist(jack);
        rollarCosterQueue.addTourist(david);
        rollarCosterQueue.addTourist(bob);
        rollarCosterQueue.addTourist(alice);
        rollarCosterQueue.addTourist(john);

        Assertions.assertEquals(1, tom.getMyPosition());
        Assertions.assertEquals(4, bob.getMyPosition());
        Assertions.assertEquals(6, john.getMyPosition());

        rollarCosterQueue.step();

        Assertions.assertEquals(-1, tom.getMyPosition());
        Assertions.assertEquals(3, bob.getMyPosition());
        Assertions.assertEquals(5, john.getMyPosition());

        john.skipWait();

        Assertions.assertEquals(4, bob.getMyPosition());
        Assertions.assertEquals(1, john.getMyPosition());

        rollarCosterQueue.step();

        Assertions.assertEquals(3, bob.getMyPosition());
        Assertions.assertEquals(-1, john.getMyPosition());

    }
}
