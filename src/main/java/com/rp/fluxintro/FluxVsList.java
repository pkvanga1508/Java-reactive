package com.rp.fluxintro;

import com.rp.util.NameGenerator;
import reactor.core.publisher.Flux;

import java.util.List;

public class FluxVsList {

    public static void main(String[] args) {

        List<String> names = NameGenerator.getNamesList(5);
        System.out.println(names); //Blocking call for 5 seconds we don't get anything
        NameGenerator.getNames(5)
                 .subscribe(System.out::println);
    }
}
