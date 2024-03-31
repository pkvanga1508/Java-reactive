package com.rp.fluxintro;

import reactor.core.publisher.Flux;

public class FluxMultipleSubscribers {

    public static void main(String[] args) {
        Flux<Integer> integerFlux = Flux.just(1,2,3,4,5,6,7,8,9);
        Flux<Integer> evenFlux = integerFlux.filter(integer -> integer % 2 == 0);
        Flux<Integer> oddFlux = integerFlux.filter(integer -> integer % 3 == 0);
        evenFlux.subscribe(integer -> System.out.println("Sub 1 : " + integer));
        oddFlux.subscribe(integer -> System.out.println("Sub 2 : " + integer));
    }
}
