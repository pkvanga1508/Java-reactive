package com.rp.fluxintro;

import com.rp.util.Utils;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import reactor.core.publisher.Flux;

import java.util.concurrent.atomic.AtomicReference;

public class CustomSubscription {

    public static void main(String[] args) {

        AtomicReference<Subscription> atomicReference = new AtomicReference<>();
        Flux.range(10, 20)
                .log()
                .subscribeWith(new Subscriber<Integer>() {
                    @Override
                    public void onSubscribe(Subscription subscription) {
                        System.out.println("On Subscribe Method received" + subscription);
                        atomicReference.set(subscription);
                    }

                    @Override
                    public void onNext(Integer integer) {
                        System.out.println("On Next :" + integer);
                    }

                    @Override
                    public void onError(Throwable throwable) {
                        System.out.println("On Error :" + throwable.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        System.out.println("On Complete :");
                    }
                });

        Utils.sleepSeconds(3);
        atomicReference.get().request(3);
        Utils.sleepSeconds(5);
        atomicReference.get().request(3);
        Utils.sleepSeconds(5);
        atomicReference.get().request(3);
        System.out.println("Cancel requested");
        atomicReference.get().cancel();
        Utils.sleepSeconds(5);
        atomicReference.get().request(3);
        Utils.sleepSeconds(5);
    }

}
