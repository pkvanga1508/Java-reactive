package com.rp.operators;

import com.rp.operators.util.OrderService;
import com.rp.operators.util.User;
import com.rp.operators.util.UserService;
import com.rp.util.Utils;
import reactor.core.publisher.Flux;

public class FlatMap {

    public static void main(String[] args) {

        Flux<User> users = UserService.getUsers();
        users.map(user -> OrderService.getOrder(user.getUserId()))
                .subscribe(Utils.subscriber());

//        users.flatMap(user -> OrderService.getOrder(user.getUserId())) //If return type is Flux/Mono we need to use Flatmap.
//                .subscribe(Utils.subscriber());

        users.concatMap(user -> OrderService.getOrder(user.getUserId())) //If return type is Flux/Mono we need to use Flatmap.
                .subscribe(Utils.subscriber());

        Utils.sleepSeconds(30);

    }
}
