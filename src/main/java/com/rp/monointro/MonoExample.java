package com.rp.monointro;

import reactor.core.publisher.Mono;

import java.util.stream.Stream;

public class MonoExample {

    public static void main(String[] args) {

//        Stream<Integer> integerStream = Stream.of(1).map(i -> {
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            return i * 4;
//        });
//
//        integerStream.forEach(System.out::println);

        //Publisher
        Mono<Integer> mono = Mono.just(1);

        mono.subscribe(obj -> System.out.println("OBJ ->" + obj));
        //Dont forget to subscribe
        mono.subscribe(integer -> System.out.println("Received : " + integer));

    }
}
