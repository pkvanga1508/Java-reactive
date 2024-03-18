package com.rp.fluxintro.assignment;

import com.github.javafaker.Faker;
import com.rp.util.Utils;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.concurrent.atomic.AtomicInteger;

public class StockPricePublisher {

    public static Flux<Integer> getPrice() {

        AtomicInteger atomicInteger = new AtomicInteger(100);
        return Flux.interval(Duration.ofSeconds(1))
                .map(interval -> atomicInteger.getAndAccumulate(
                        Utils.faker().random().nextInt(-5, 5),
                        Integer::sum
                ));
    }


}
