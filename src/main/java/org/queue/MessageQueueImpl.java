package org.queue;

import org.sub.Subscriber;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MessageQueueImpl<T> implements MessageQueue<T> {
    private final Map<String, List<Subscriber<T>>> queueNameToSubscriberList = new HashMap<>();

    @Override
    public void push(T message, String queueName) {
        queueNameToSubscriberList.get(queueName).forEach(s -> s.accept(message));
    }

    @Override
    public void registerSubscriber(String queueName, Subscriber<T> subscriber) {
        queueNameToSubscriberList.computeIfAbsent(queueName, qn -> new ArrayList<>()).add(subscriber);
    }
}
