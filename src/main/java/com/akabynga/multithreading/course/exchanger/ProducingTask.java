package com.akabynga.multithreading.course.exchanger;

import java.util.Queue;
import java.util.concurrent.Exchanger;
import java.util.stream.IntStream;

public class ProducingTask extends ExchangingTask {
    private final ExchangedObjectFactory objectFactory;
    private final int producedObjectCount;

    public ProducingTask(final Exchanger<Queue<ExchangedObject>> exchanger,
                         final ExchangedObjectFactory objectFactory,
                         final int producedObjectCount) {
        super(exchanger);
        this.objectFactory = objectFactory;
        this.producedObjectCount = producedObjectCount;
    }

    @Override
    protected void handle(Queue<ExchangedObject> objects) {
        IntStream.range(0, producedObjectCount)
                .mapToObj(i -> objectFactory.create())
                .peek(object -> System.out.printf("%s is being produced\n", object))
                .forEach(objects::add);
    }
}
