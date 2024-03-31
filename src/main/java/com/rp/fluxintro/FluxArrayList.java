package com.rp.fluxintro;

import com.rp.util.Utils;
import reactor.core.publisher.Flux;

import java.util.Arrays;

public class FluxArrayList {

    public static void main(String[] args) {

        Flux<String> namesFlux = Flux.fromIterable(Arrays.asList(Utils.faker().name().fullName(),
                Utils.faker().name().fullName(),
                Utils.faker().name().fullName(),
                Utils.faker().name().fullName()));

        String[] strArray = {Utils.faker().name().fullName(),
                Utils.faker().name().fullName(),
                Utils.faker().name().fullName(),
                Utils.faker().name().fullName()};

        Flux<String> namesArrayFlux = Flux.fromArray(strArray);
        namesFlux.subscribe(Utils.onNext(), Utils.onError(), Utils.onComplete());
        namesArrayFlux.subscribe(Utils.onNext(), Utils.onError(), Utils.onComplete());

    }
}
