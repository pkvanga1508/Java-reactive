package com.rp.fluxadvanced;

import com.rp.util.Utils;
import reactor.core.publisher.Flux;

public class FluxGenerate {

    public static void main(String[] args) {
        //FluxSink you can emit any items or share with Multiple threads
        //fluxsink.next("abc")
        //fluxsink.next("def") etc -> Shared with Multiple threads

        //synchronousSink can emit only 1 item but if you dont cancel or call error it will emit forever.
        Flux.generate(synchronousSink -> {
            //New instance of synchronousSink is created everytime
            System.out.println("Emitting");
            synchronousSink.next(Utils.faker().country().name()); //You don't have to maintain any loop. it will emit all items
            //You dont have to check if the subscription is cancelled or not.
//            synchronousSink.complete();
//            synchronousSink.error(new RuntimeException("No longer needed to emit"));
        })
                .take(2)
                .subscribe(Utils.subscriber());
    }
}
