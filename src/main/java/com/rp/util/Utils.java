package com.rp.util;

import com.github.javafaker.Faker;
import org.reactivestreams.Subscriber;

import java.util.function.Consumer;

public class Utils {

    public static final Faker FAKER = Faker.instance();

    public static Consumer<Object> onNext() {
        return obj -> System.out.println("Received : " + obj);
    }

    public static Consumer<Throwable> onError() {
        return err -> System.out.println("Received : " + err.getMessage());
    }

    public static Runnable onComplete() {
        return () -> System.out.println("Completed ");
    }

    public static Faker faker() {
        return FAKER;
    }

    public static void sleepSeconds(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static Subscriber<Object> subscriber() {
        return new DefaultSubscriber();
    }

    public static Subscriber<Object> subscriber(String name) {
        return new DefaultSubscriber(name);
    }
}
