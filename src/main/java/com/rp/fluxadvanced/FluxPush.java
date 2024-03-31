package com.rp.fluxadvanced;

import com.rp.util.NameProducer;
import com.rp.util.Utils;
import reactor.core.publisher.Flux;

public class FluxPush {

    public static void main(String[] args) {

        //Create is thread safe but Push is not thread safe
        //Create internally uses Serializedsync
        NameProducer nameProducer = new NameProducer();
        Flux.push(nameProducer).subscribe(Utils.subscriber()); //Not all threads may come

        Runnable runnable = nameProducer::produce;
        for(int i = 0; i < 10; i++) {
            new Thread(runnable).start();
        }
    }
}
