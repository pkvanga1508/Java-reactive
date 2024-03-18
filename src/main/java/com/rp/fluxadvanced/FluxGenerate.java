package com.rp.fluxadvanced;

import com.rp.util.Utils;
import reactor.core.publisher.Flux;

public class FluxGenerate {

    public static void main(String[] args) {

        //synchronousSink can emit only 1 item
        Flux.generate(synchronousSink -> {
            //New instance of synchronousSink is created everytime
            System.out.println("Emitting");
            synchronousSink.next(Utils.faker().country().name()); //You don't have to maintain any loop. it will emit all items
//            synchronousSink.complete();
//            synchronousSink.error(new RuntimeException("No longer needed to emit"));
        })
                .take(2)
                .subscribe(Utils.subscriber());
    }
}
