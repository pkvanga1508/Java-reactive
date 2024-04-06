package com.rp.operators;

import com.rp.util.Utils;
import reactor.core.publisher.Flux;
import reactor.util.concurrent.Queues;

import java.time.Duration;

public class Delay {

    public static void main(String[] args) {

        //By default
        System.setProperty("reactor.bufferSize.x", "9"); //Queue size to 9
        Flux.range(1, 100) //32 -> Limit rate
                .log()
                .delayElements(Duration.ofSeconds(1))
                .subscribe(Utils.subscriber()); //There is a limit rate interally when we have delay element

        Utils.sleepSeconds(60);

    }
}
