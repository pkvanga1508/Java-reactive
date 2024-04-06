package com.rp.operators;

import com.rp.operators.util.Person;
import com.rp.util.Utils;
import reactor.core.publisher.Flux;

import java.util.function.Function;

public class SwitchOnFirst {

    public static void main(String[] args) {

        getPerson()
                .switchOnFirst((signal, personFlux) -> {
                    System.out.println("Inside Switch on First"); //This will execute only once.
                    return signal.isOnNext() && signal.get().getAge() > 10 ? personFlux : applyFilterMap().apply(personFlux);
                })
//                .transform(applyFilterMap())
                .subscribe(Utils.subscriber());

    }

    public static Flux<Person> getPerson() {
        return Flux.range(1, 10)
                .map(i -> new Person());
    }

    public static Function<Flux<Person>, Flux<Person>> applyFilterMap() {

        return flux -> flux.filter(person -> person.getAge() > 10)
                .doOnNext(person -> person.setName(person.getName().toUpperCase()))
                .doOnDiscard(Person.class, person -> System.out.println("Discarded Person: "+ person));
    }
}
