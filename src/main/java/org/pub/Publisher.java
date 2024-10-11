package org.pub;

import java.util.List;

public interface Publisher<T extends Object> {
    T push();
    List<T> pushBatch();
}
