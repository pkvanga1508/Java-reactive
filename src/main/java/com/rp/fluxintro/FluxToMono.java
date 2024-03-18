package com.rp.fluxintro;


import com.rp.util.Utils;
import reactor.core.publisher.Flux;

public class FluxToMono {

    public static void main(String[] args) {
        Flux<Integer> integerFlux = Flux.range(1, 10);
        integerFlux
                .filter(i -> i > 3)
                .next() //Converts Flux to Mono ->? Retun the first items > 3
                .subscribe(Utils.onNext(), Utils.onError(), Utils.onComplete());

        integerFlux
                .next()
                .filter(i -> i > 3) // Filters out 1
                .subscribe(Utils.onNext(), Utils.onError(), Utils.onComplete());
    }
}
