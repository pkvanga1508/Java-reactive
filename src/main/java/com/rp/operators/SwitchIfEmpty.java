package com.rp.operators;

import com.rp.util.Utils;
import reactor.core.publisher.Flux;

public class SwitchIfEmpty {

    public static void main(String[] args) {
        getOrderNumbers()
                .filter(i -> i > 10)
                .switchIfEmpty(fallBack()) //If we dont get any values
                .subscribe(Utils.subscriber());
    }

    //Redis
    private static Flux<Integer> getOrderNumbers() {
        return Flux.range(1, 11);
    }

    //Query DB
    private static Flux<Integer> fallBack() {
        return Flux.range(20, 5);
    }
}
