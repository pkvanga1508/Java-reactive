package com.rp.operators;

import com.rp.util.Utils;
import reactor.core.publisher.Flux;

public class DoCallBacks {

    public static void main(String[] args) {

        Flux.create(fluxSink -> {
            System.out.println("Inside create");
            for (int i = 0; i < 5; i++) {
                fluxSink.next(i);
            }
            fluxSink.error(new RuntimeException("Runtime exp"));
            fluxSink.complete();
            System.out.println("Complete creatation");
        })
                //Do First executes in reverser order from bottom
                //Do On Subscribe passed from publisher to subscriber so order is preserved
                .doFirst(() -> System.out.println("Do First 1")) //Open DB Connection, FIle Handle etc
                .doOnNext(obj -> System.out.println("Do On Next: " + obj))
                .doOnSubscribe(subscription -> System.out.println("Do On Subscribe 1: " + subscription))
                .doOnRequest(value -> System.out.println("Do On Request: " + value))
                .doOnTerminate(() -> System.out.println("Do On Terminated"))
                .doOnComplete(() -> System.out.println("Do on Complete"))
                .doFirst(() -> System.out.println("Do First 2"))
                .doOnError(err -> System.out.println("DO On Error " + err.getMessage()))
                .doOnSubscribe(subscription -> System.out.println("Do On Subscribe 2: " + subscription))
                .doOnCancel(() -> System.out.println("Do On Canceled"))
                .doFinally(signalType -> System.out.println("Do Finally " + signalType))
                .doFirst(() -> System.out.println("Do First 3"))
                .doOnDiscard(Object.class, obj -> System.out.println("Do On Discard" + obj))
                .take(2)
                .subscribe(Utils.subscriber());
    }
}
