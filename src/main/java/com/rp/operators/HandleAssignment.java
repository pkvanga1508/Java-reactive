package com.rp.operators;

import com.rp.util.DefaultSubscriber;
import com.rp.util.Utils;
import reactor.core.publisher.Flux;

public class HandleAssignment {

    public static void main(String[] args) {

        Flux.generate(synchronousSink -> {
            String country = Utils.faker().country().name();
            synchronousSink.next(country);
        })
                .map(Object::toString)
                .handle((country, synchronousSink) -> {
                    synchronousSink.next(country);
                    if(country.equalsIgnoreCase("Canada")) {
                        synchronousSink.complete();
                    }
                })
                .subscribe(Utils.subscriber());
    }
}
