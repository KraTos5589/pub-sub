package org.queue;

import org.pub.Publisher;
import org.sub.Subscriber;

public interface MessageQueue<T extends Object> {
    void push(T message, String queueName);
    void registerSubscriber(String queueName, Subscriber<T> subscriber);
}
