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
//        stream.forEach(System.out::println); //Stream is closed after terminal operatior is applied
//        stream.forEach(System.out::println);
//        Flux<Integer> integerFlux_1 = Flux.fromStream(stream); //From stream
//        Flux<Integer> integerFlux_2 = Flux.fromStream(stream); //From stream error as stream is already applied terminal operator
//        integerFlux_1.subscribe(Utils.onNext());
//        integerFlux_2.subscribe(Utils.onNext());
//        Flux<Integer> integerFlux = Flux.fromStream(() -> stream); //Error same instance of stream is sent
        Flux<Integer> integerFlux = Flux.fromStream(() -> list.stream()); //Supplier of stream

        integerFlux.subscribe(Utils.onNext(), Utils.onError(), Utils.onComplete());
        integerFlux.subscribe(Utils.onNext(), Utils.onError(), Utils.onComplete());

    }
}
