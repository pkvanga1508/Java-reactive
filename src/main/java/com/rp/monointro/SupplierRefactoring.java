package com.rp.monointro;

import com.rp.util.Utils;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.util.concurrent.CountDownLatch;

public class SupplierRefactoring {

    public static void main(String[] args) throws InterruptedException {

        getName();
        getName();
        getName();
//        getName()
//                .subscribeOn(Schedulers.boundedElastic())
//                .subscribe(Utils.onNext());
//        getName()
//                .subscribeOn(Schedulers.boundedElastic())
//                .block(); //Blocking Mono subscriber -> DOnt use in Prod
        getName().subscribe(Utils.onNext());
        getName();
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
