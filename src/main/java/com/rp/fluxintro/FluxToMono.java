package com.rp.fluxintro;


import com.rp.util.Utils;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class FluxToMono {

    public static void main(String[] args) {

        //next() -> Converts Flux to Mono
        Flux<Integer> integerFlux = Flux.range(1, 10);
        Mono<Integer> integerMono = Mono.from(integerFlux);
        integerFlux
                .filter(i -> i > 3)
                .next() //Converts Flux to Mono ->? Retun the first items > 3
                .subscribe(Utils.onNext(), Utils.onError(), Utils.onComplete());

        integerFlux
                .next() //Only first item 1 will be emitted
                .filter(i -> i > 3) // Filters out 1
                .subscribe(Utils.onNext(), Utils.onError(), Utils.onComplete());

        integerMono.subscribe(Utils.onNext(), Utils.onError(), Utils.onComplete());
    }
}
