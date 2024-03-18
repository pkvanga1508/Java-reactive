package com.rp.util;

import reactor.core.publisher.FluxSink;

import java.util.function.Consumer;

public class NameProducer implements Consumer<FluxSink<String>> {

    private FluxSink<String> fluxSink;

    @Override
    public void accept(FluxSink<String> fluxSink) {
        this.fluxSink = fluxSink;
    }

    public void produce() {
        String name = Utils.faker().country().name();
        String thread = Thread.currentThread().getName();
        this.fluxSink.next("Thread: " + thread + " Value: " + name);
    }

    public String produceAndReturn() {
        String name = Utils.faker().country().name();
        this.fluxSink.next(name);
        return name;
    }
}
