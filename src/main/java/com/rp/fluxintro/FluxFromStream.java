package com.rp.fluxintro;

import com.rp.util.Utils;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.stream.Stream;

public class FluxFromStream {

    public static void main(String[] args) {
        List<Integer> list = List.of(1,2,3,4,5,6,7);
        Stream<Integer> stream = list.stream();
//        Flux<Integer> integerFlux = Flux.fromStream(stream); //From stream
        Flux<Integer> integerFlux = Flux.fromStream(() -> list.stream()); //Supplier of stream
//        stream.forEach(System.out::println);
//        stream.forEach(System.out::println);
        integerFlux.subscribe(Utils.onNext(), Utils.onError(), Utils.onComplete());
        integerFlux.subscribe(Utils.onNext(), Utils.onError(), Utils.onComplete());



    }
}
