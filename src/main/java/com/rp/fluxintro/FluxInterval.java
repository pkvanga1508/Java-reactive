package com.rp.fluxintro;

import com.rp.util.Utils;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class FluxInterval {

    public static void main(String[] args) throws InterruptedException {

        Flux.interval(Duration.ofSeconds(1)) //ANy work that can be done periodically -> Update stock price
                .subscribe(Utils.onNext());
        Utils.sleepSeconds(5);
    }
}
