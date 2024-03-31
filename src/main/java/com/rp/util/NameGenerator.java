package com.rp.util;

import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;

public class NameGenerator {

    public static List<String> getNamesList(int count) {
        List<String> names = new ArrayList<>(count);
        for(int i = 0; i < count; i++) {
            names.add(getName());
        }
        return names;
    }

    public static Flux<String> getNames(int count) {
        return Flux.range(0, count)
                .map(i -> getName());
    }

    private static String getName() {
        System.out.println("Generating Name: ");
        Utils.sleepSeconds(1);
        return Utils.faker().name().fullName();
    }
}
