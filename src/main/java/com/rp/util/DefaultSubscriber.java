package com.rp.util;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public class DefaultSubscriber implements Subscriber<Object> {

    private String name = "";

    public DefaultSubscriber() {
    }

    public DefaultSubscriber(String name) {
        this.name = name;
    }

    @Override
    public void onSubscribe(Subscription subscription) {
        subscription.request(Long.MAX_VALUE); //Unbounded
    }

    @Override
    public void onNext(Object o) {
        System.out.println(name + " Received onNext: " + o);
    }

    @Override
    public void onError(Throwable throwable) {
        System.out.println(name + " ERROR: " + throwable.getMessage());
    }

    @Override
    public void onComplete() {
        System.out.println(name + " COMPLETED ");
    }
}
