package com.rp.monointro;

import com.rp.util.Utils;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class MonoEmptyOrError {

    public static void main(String[] args) {

        //Here data is present so onNext() returns name, On Complete is called.
        userRepository(1)
                .subscribe(Utils.onNext(),
                        Utils.onError(),
                        Utils.onComplete()
                );

        //Here data is not present so onNext() is not called but On Complete is called as end of data is reached
        userRepository(2)
                .subscribe(Utils.onNext(),
                        Utils.onError(),
                        Utils.onComplete()
                );
        //Here data is not present but error ic thrown so onError is called and finally On Complete is called as end of data is reached
        userRepository(3)
                .subscribe(Utils.onNext(),
                        Utils.onError(),
                        Utils.onComplete()
                );
    }

    private static Mono<String> userRepository(int userId) {
        if(userId == 1) {
            return Mono.just(Utils.faker().name().fullName());
        } else if(userId == 2) {
            return Mono.empty(); //No Data
        } else {
            return Mono.error(new RuntimeException("Not in Allowed Range"));
        }
    }
}
