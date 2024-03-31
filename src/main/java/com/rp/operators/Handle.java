package com.rp.operators;

import com.rp.util.Utils;
import reactor.core.publisher.Flux;

//Filter + Map
public class Handle {

    public static void main(String[] args) {
        Flux.range(1,20)
                .handle(((integer, synchronousSink) -> {
                    if(integer % 2 == 0) { //Filter
                        synchronousSink.next(integer);
                    } else if(integer == 7) {
                        synchronousSink.complete();
                    }else { //Map
                        synchronousSink.next(integer + "abc");
                    }
                })).subscribe(Utils.subscriber());

        Flux.generate(synchronousSink -> {
            String country = Utils.faker().country().name();
            synchronousSink.next(country);
        })
                .map(Object::toString)
                .handle((countryName, synchronousSink) -> {
                    synchronousSink.next(countryName);
            if(countryName.equalsIgnoreCase("canada")) {
                synchronousSink.complete();
            }
        }).subscribe(Utils.subscriber());
    }




}
