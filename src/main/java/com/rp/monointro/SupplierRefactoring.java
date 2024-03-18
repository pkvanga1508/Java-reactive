package com.rp.monointro;

import com.rp.util.Utils;
import reactor.core.publisher.Mono;

public class SupplierRefactoring {

    public static void main(String[] args) {

        getName();
        getName();
        getName();
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
