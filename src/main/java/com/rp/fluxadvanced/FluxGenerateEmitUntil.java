package com.rp.fluxadvanced;

import com.rp.util.Utils;
import reactor.core.publisher.Flux;

public class FluxGenerateEmitUntil {

    public static void main(String[] args) {

        Flux.generate(synchronousSink -> {
            String country = Utils.faker().country().name();
            System.out.println("Emitting country: " + country);
            synchronousSink.next(country);
            if(country.equalsIgnoreCase("Canada")) {
                synchronousSink.complete();
            }
        }).subscribe(Utils.subscriber());

    }
}
