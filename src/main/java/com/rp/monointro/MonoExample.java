package com.rp.monointro;

import reactor.core.publisher.Mono;

public class MonoExample {

    public static void main(String[] args) {

        //Publisher
        Mono<Integer> mono = Mono.just(1);

        //Dont forget to subscribe
        mono.subscribe(integer -> System.out.println("Received : " + integer));

    }
}
