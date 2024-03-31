package com.rp.fluxadvanced;

import com.rp.util.NameProducer;
import com.rp.util.Utils;
import reactor.core.publisher.Flux;

public class FluxCreateIssueFix {

    public static void main(String[] args) {

        //Only one instance of fluxsink
        Flux.create(fluxSink -> {
            String country;
            do {
                country = Utils.faker().country().name();
                System.out.println("Emitting :" + country);
                fluxSink.next(country);
            } while (!country.equalsIgnoreCase("Canada")
                    && !fluxSink.isCancelled());
            fluxSink.complete();
        })
                .take(3) //Does not respect take operator it continues to emit more than 3 events so we also check fluxSink.isCancelled()
                .subscribe(Utils.subscriber());
    }
}
