package com.rp.fluxadvanced;

import com.rp.util.NameProducer;
import com.rp.util.Utils;
import reactor.core.publisher.Flux;

public class FluxCreateFluxSink {

    public static void main(String[] args) {

        NameProducer nameProducer = new NameProducer();
        Flux.create(nameProducer)
                .subscribe(Utils.subscriber());

        //Invoke outside to produce names - Produce Just 1 name
        nameProducer.produce();

        //Emmit's items with Multiple threads -> Flux sink thread safe.
        Runnable runnable = nameProducer::produce;
        for(int i = 0; i < 10; i++) {
            new Thread(runnable).start();
        }

        //Keep on Producing names till it reaches Canada
//        String country;
//        do {
//            country = nameProducer.produceAndReturn();
//        } while (!country.equalsIgnoreCase("Canada"));
    }
}
