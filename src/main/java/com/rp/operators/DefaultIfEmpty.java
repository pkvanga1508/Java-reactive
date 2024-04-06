package com.rp.operators;

import com.rp.util.Utils;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class DefaultIfEmpty {

    public static void main(String[] args) {
        getOrderNumbers()
                .filter(i -> i > 10)
                .defaultIfEmpty(-100) //If we dont get any values
                .subscribe(Utils.subscriber());
    }

    private static Flux<Integer> getOrderNumbers() {

        return Flux.range(1, 10);
    }
}
