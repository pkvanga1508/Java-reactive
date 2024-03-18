package com.rp.fluxintro;

import com.rp.util.Utils;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class FluxFromMono {

    public static void main(String[] args) {
        Mono<String> mono = Mono.just("Praveen");
        Flux<String> flux = Flux.from(mono);
        flux.subscribe(Utils.onNext(), Utils.onError(), Utils.onComplete());
    }

    private static void doSomething(Flux<String> flux) {

    }
}
