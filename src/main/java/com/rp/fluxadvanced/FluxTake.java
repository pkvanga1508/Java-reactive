package com.rp.fluxadvanced;

import com.rp.util.Utils;
import reactor.core.publisher.Flux;

public class FluxTake {

    public static void main(String[] args) {

        Flux.range(10, 20)
                .log()
                .take(3) //After 3rd item subscription is canceled is called
                .log()
                .subscribe(Utils.subscriber());
    }
}
