package com.rp.fluxadvanced;

import com.rp.util.Utils;
import reactor.core.publisher.Flux;

import java.util.concurrent.atomic.AtomicInteger;

public class FluxGenerateCounter {

    public static void main(String[] args) {
        //Max emit 10
        //Country name is Canada
        //Subscriber cancels - exit
//        Flux.create(fluxSink -> {
//            int counter = 0;
//            String country;
//            do {
//                country = Utils.faker().country().name();
//                System.out.println("Emitting country: " + country);
//                fluxSink.next(country);
//                counter++;
//            } while (!country.equalsIgnoreCase("Canada") && !fluxSink.isCancelled() && counter < 10);
//            fluxSink.complete();
//        }).subscribe(Utils.subscriber());

//        AtomicInteger atomicInteger = new AtomicInteger(0);
//        Flux.generate(synchronousSink -> {
//            String country = Utils.faker().country().name();
//            System.out.println("Emitting country: " + country);
//            synchronousSink.next(country);
//            atomicInteger.getAndIncrement();
//            if (country.equalsIgnoreCase("Canada") || atomicInteger.get() >= 10) {
//                synchronousSink.complete();
//            }
//        }).subscribe(Utils.subscriber());

        Flux.generate(
                () -> 1, //Initial state
                (state, sink) -> {
                    String country = Utils.faker().country().name();
                    System.out.println("Emitting country: " + country);
                    sink.next(country);
                    if (country.equalsIgnoreCase("Canada") || state >= 10) {
                        sink.complete();
                    }
                    return state + 1;
                })
                .take(4)
                .subscribe(Utils.subscriber());
    }
}
