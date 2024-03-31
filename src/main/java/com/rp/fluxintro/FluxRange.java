package com.rp.fluxintro;

import com.rp.util.Utils;
import reactor.core.publisher.Flux;

public class FluxRange {

    public static void main(String[] args) {
        Flux<Integer> integerFlux = Flux.range(10, 10);

        integerFlux.subscribe(Utils.onNext(), Utils.onError(), Utils.onComplete());

        integerFlux
                .map(i -> Utils.faker().name().fullName()) //Generate a String for each number in range
                .subscribe(Utils.onNext(), Utils.onError(), Utils.onComplete()); //Get 10 names

        integerFlux
                .log()
                .map(i -> Utils.faker().name().fullName()) //Generate a String for each number in range
                .subscribe(Utils.onNext(), Utils.onError(), Utils.onComplete()); //Get 10 names

    }
}
