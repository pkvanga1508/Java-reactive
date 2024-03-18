package com.rp.monointro;

import reactor.core.publisher.Mono;

public class MonoSubscribeExample {

    public static void main(String[] args) {

        //Publisher
        Mono<String> mono = Mono.just("ball");

        //Dont forget to subscribe
//        mono.subscribe(); //Subscription

        mono.subscribe(item -> System.out.println(item),
                err -> System.out.println(err.getMessage()),
                () -> System.out.println("Completed"));
//        mono.subscribe(integer -> System.out.println("Received : " + integer));

    }
}
