package mediator.queue;

import mediator.tourist.Tourist;

/**
 * 队列的抽象
 */
public abstract class AbstractQueue {
    public abstract void addTourist(Tourist tourist);

    public abstract void skipWait(Tourist tourist);

    public abstract int getPosition(Tourist tourist);

    // 前进一个人
    public abstract void step();
}
