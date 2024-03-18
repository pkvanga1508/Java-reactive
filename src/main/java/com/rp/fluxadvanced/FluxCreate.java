package com.rp.fluxadvanced;

import com.rp.util.Utils;
import reactor.core.publisher.Flux;

public class FluxCreate {

    public static void main(String[] args) {

        Flux.create(fluxSink -> {
//            fluxSink.next("Praveen");
//            fluxSink.next("Kumar");
//            fluxSink.next("Vanga");
//            fluxSink.complete();
            String country;
            do {
                country = Utils.faker().country().name();
                fluxSink.next(country);
            } while (!country.equalsIgnoreCase("Canada"));
            fluxSink.complete();
        }).subscribe(Utils.subscriber());
    }
}
