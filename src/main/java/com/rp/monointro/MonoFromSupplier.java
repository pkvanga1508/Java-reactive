package com.rp.monointro;

import com.rp.util.Utils;
import reactor.core.publisher.Mono;

import java.util.concurrent.Callable;
import java.util.function.Supplier;

public class MonoFromSupplier {

    public static void main(String[] args) {

        //User just only when you have data present already so dont use just here
//        Mono<String> nameFormSubscriber = Mono.just(getName());

        //Name is not generated if no subscriber
        Supplier<String> nameSupplier = () -> getName();
        Mono<String> nameFromSupplier = Mono.fromSupplier(nameSupplier);
        nameFromSupplier.subscribe(Utils.onNext());

        Callable<String> stringCallable = () -> getName();
        Mono<String> nameFromCallable = Mono.fromCallable(stringCallable);
        nameFromCallable.subscribe(Utils.onNext());
    }

    public static String getName() {
        System.out.println("Generating Name");
        return Utils.faker().name().fullName();
    }
}
