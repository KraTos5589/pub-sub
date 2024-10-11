package org.queue;

import org.junit.Test;
import org.mockito.Mockito;
import org.sub.Subscriber;


public class MessageQueueImplTest {


    @Test
    public void simpleTest() {
        Subscriber<String> mockSubscriber1 = Mockito.mock(Subscriber.class);
        Subscriber<String> mockSubscriber2 = Mockito.mock(Subscriber.class);

        MessageQueue<String> messageQueue = new MessageQueueImpl<>();

        messageQueue.registerSubscriber("q1", mockSubscriber1);
        messageQueue.registerSubscriber("q1", mockSubscriber2);

        messageQueue.push("123", "q1");

        Mockito.verify(mockSubscriber1, Mockito.times(1)).accept("123");
        Mockito.verify(mockSubscriber2, Mockito.times(1)).accept("123");
    }
}
