package com.rp.stockpriceObserver;

import com.rp.util.Utils;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class StockPriceObserver {

    public static Flux<Integer> getPrice() {

        AtomicInteger atomicInteger = new AtomicInteger(100);
        return Flux.interval(Duration.ofSeconds(1))
                .map(i -> atomicInteger.getAndAccumulate(
                        Utils.faker().random().nextInt(-5, 5),
                        Integer::sum
                ));
    };

    public static void main(String[] args) throws InterruptedException {

        CountDownLatch latch = new CountDownLatch(1);
        getPrice().subscribeWith(new Subscriber<Integer>() {

            Subscription subscription;
            @Override
            public void onSubscribe(Subscription subscription) {
                subscription.request(Long.MAX_VALUE); //Give me all values you have
                this.subscription = subscription;
            }

            @Override
            public void onNext(Integer price) {
                System.out.println(LocalDateTime.now() + " : Price : " + price);
                if(price < 90 || price > 110) {
                    this.subscription.cancel();
                }
            }

            @Override
            public void onError(Throwable throwable) {
                latch.countDown();
            }

            @Override
            public void onComplete() {
                latch.countDown();
            }
        });

        latch.await();

    }

}
