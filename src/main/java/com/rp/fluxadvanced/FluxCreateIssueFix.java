package com.rp.fluxadvanced;

import com.rp.util.NameProducer;
import com.rp.util.Utils;
import reactor.core.publisher.Flux;

public class FluxCreateIssueFix {

    public static void main(String[] args) {

        //Only one instance of fluxsink
        Flux.create(fluxSink -> {
//            fluxSink.next("Praveen");
//            fluxSink.next("Kumar");
//            fluxSink.next("Vanga");
//            fluxSink.complete();
            String country;
            do {
                country = Utils.faker().country().name();
                System.out.println("Emitting :" + country);
                fluxSink.next(country);
            } while (!country.equalsIgnoreCase("Canada")
                    && !fluxSink.isCancelled());
            fluxSink.complete();
        })
                .take(3)
                .subscribe(Utils.subscriber());
    }
}
