package mediator.queue;

import mediator.tourist.AnnualPassTourist;
import mediator.tourist.Tourist;

import java.util.ArrayDeque;

/**
 * 队列的实现
 */
public class Queue extends AbstractQueue {
    private final ArrayDeque<Tourist> annualMemberQueue;
    private final ArrayDeque<Tourist> normalQueue;

    public Queue() {
        annualMemberQueue = new ArrayDeque<>();
        normalQueue = new ArrayDeque<>();
    }

    @Override
    public void addTourist(Tourist tourist) {
        normalQueue.addLast(tourist);
        tourist.setQueue(this);
    }

    @Override
    public void skipWait(Tourist tourist) {
        if (tourist instanceof AnnualPassTourist && normalQueue.remove(tourist)) {
            annualMemberQueue.addLast(tourist);
        }
    }

    @Override
    public int getPosition(Tourist tourist) {
        int pos = 1;
        for (var t : annualMemberQueue) {
            if (t == tourist) {
                return pos;
            }
            pos++;
        }
        for (var t : normalQueue) {
            if (t == tourist) {
                return pos;
            }
            pos++;
        }
        return -1;
    }

    @Override
    public void step() {
        if (!annualMemberQueue.isEmpty()) {
            annualMemberQueue.removeFirst().finishWaiting();
        } else if (!normalQueue.isEmpty()) {
            normalQueue.removeFirst().finishWaiting();
        }
    }
}
