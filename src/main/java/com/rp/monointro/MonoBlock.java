package com.rp.monointro;

import com.rp.util.Utils;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

public class MonoBlock {

    public static void main(String[] args) {

        getName();
        getName();
        //Dont do it in prod only for testing
        String name = getName().subscribeOn(Schedulers.boundedElastic())
                .block();
        System.out.println(name);
        getName();
        Utils.sleepSeconds(4);
    }

    private static Mono<String> getName() {
        System.out.println("Entered getNameMethod");
        return Mono.fromSupplier(() -> {
            System.out.println("Generating Name .... ");
            Utils.sleepSeconds(3);
            return Utils.faker().name().fullName();
        }).map(String::toUpperCase);
    }
}
