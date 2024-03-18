package com.rp.monointro;

import com.rp.util.Utils;
import reactor.core.publisher.Mono;

public class MonoSubscribeErrorExample {

    public static void main(String[] args) {

        //Publisher
        Mono<Integer> mono = Mono.just("ball")
                                .map(String::length)
                                .map(len -> len/0);

        //Dont forget to subscribe
//        mono.subscribe(item -> System.out.println(item)); //Subscription

        mono.subscribe(Utils.onNext(),
                Utils.onError(),
                Utils.onComplete());
//        mono.subscribe(integer -> System.out.println("Received : " + integer));

    }
}
