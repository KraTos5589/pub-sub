package org.sub;

public interface Subscriber<T extends Object> {
    void accept(T t);
}
