package com.rp.operators;

import com.rp.util.Utils;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class HighResilientOperator {

    public static void main(String[] args) {

        Flux.range(1, 10)
                .log()
                .map(i -> 10 / (5 - i))
//                .onErrorReturn(-1) //Fallback value on error
//                .onErrorResume(err -> fallBack()) //Value comes from Fallback Mono Supplier
                .onErrorContinue((throwable, obj) -> {}) //No Action Just keep continue or you can log object etc actions
                .subscribe(Utils.subscriber());
    }

    private static Mono<Integer> fallBack() {
        return Mono.fromSupplier(() -> Utils.faker().random().nextInt(100,200));
    }
}
