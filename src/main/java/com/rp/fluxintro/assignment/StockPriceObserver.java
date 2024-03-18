package com.rp.fluxintro.assignment;

import com.rp.util.Utils;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.Random;
import java.util.concurrent.atomic.AtomicReference;

public class StockPriceObserver {

    static Random random = new Random();

    public static Flux<AtomicReference<Integer>> stockPriceFlux() {
        AtomicReference<Integer> priceReference = new AtomicReference<>();
        priceReference.set(100);
        return Flux.interval(Duration.ofSeconds(1))
                .map(second -> updatedPrice(priceReference));
    }

    public static AtomicReference<Integer> updatedPrice(AtomicReference<Integer> currentPrice) {
        int updatedPrice = currentPrice.get() + random.nextInt(10) + -5;
        currentPrice.set(updatedPrice);
        return currentPrice;
    }

    public static void main(String[] args) {
        int minPrice = 90;
        int maxPrice = 120;
        AtomicReference<Subscription> subscriptionAtomicReference = new AtomicReference<>();
        stockPriceFlux().subscribeWith(new Subscriber<AtomicReference<Integer>>() {
            @Override
            public void onSubscribe(Subscription subscription) {
                System.out.println("Subscription Started:");
                subscriptionAtomicReference.set(subscription);
            }

            @Override
            public void onNext(AtomicReference<Integer> integerAtomicReference) {
                int currentPrice = integerAtomicReference.get();
                System.out.println("Current Value: " + currentPrice);
                if(currentPrice > minPrice ||currentPrice > maxPrice) {
                    subscriptionAtomicReference.get().cancel();
                }
            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println("Subscription ended because of an error: " + throwable.getMessage());
            }

            @Override
            public void onComplete() {
                System.out.println("Subscription ended:");
            }
        });
        Utils.sleepSeconds(30);
    }

}
