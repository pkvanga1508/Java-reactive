package com.rp.fluxadvanced;

import com.rp.util.Utils;
import reactor.core.publisher.Flux;

public class FluxCreate {

    public static void main(String[] args) {

        Flux.create(fluxSink -> {
            fluxSink.next("Praveen");
            fluxSink.next("Kumar");
            fluxSink.next("Vanga");
            System.out.println("-------");
            for (int i = 0; i < 10; i++) {
                fluxSink.next(Utils.faker().country().name());
            }
            System.out.println("-------");
            String country;
            do {
                country = Utils.faker().country().name();
                fluxSink.next(country);
            } while (!country.equalsIgnoreCase("Canada"));
            fluxSink.complete();
        }).subscribe(Utils.subscriber());
    }
}
