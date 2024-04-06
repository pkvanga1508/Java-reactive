package com.rp.operators;

import com.rp.util.Utils;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class TimeOutOperator {

    public static void main(String[] args) {

        getOrderNumbers()
                .timeout(Duration.ofSeconds(2), fallBack())
                .subscribe(Utils.subscriber());

        Utils.sleepSeconds(60);
    }

    private static Flux<Integer> getOrderNumbers() {

        return Flux.range(1, 10)
                .delayElements(Duration.ofSeconds(1));
    }

    private static Flux<Integer> fallBack() {
        return Flux.range(100, 10)
                .delayElements(Duration.ofMillis(200));
    }


}
