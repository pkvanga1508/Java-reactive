package com.rp.fluxintro;

import com.rp.util.Utils;
import reactor.core.publisher.Flux;

public class FluxJust {

    public static void main(String[] args) {

        Flux.just(1);
        Flux<Object> fluxStrings = Flux.just(Utils.faker().name().fullName(),
                Utils.faker().name().fullName(),
                Utils.faker().name().fullName(), 1, 4, 55);

        Flux<String> emptyFlux = Flux.empty();

        fluxStrings.subscribe(Utils.onNext(), Utils.onError(), Utils.onComplete());
        emptyFlux.subscribe(Utils.onNext(), Utils.onError(), Utils.onComplete());


    }
}
