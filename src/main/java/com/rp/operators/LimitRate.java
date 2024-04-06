package com.rp.operators;

import com.rp.util.Utils;
import reactor.core.publisher.Flux;

public class LimitRate {

    public static void main(String[] args) {

        Flux.range(1, 1000)
                .log()
//                .limitRate(100, 90) //75% default gives next request or give custom rate yourself 90% of data
//                .limitRate(100, 100) //drain 75% done Honor this
                .limitRate(100, 0) //drain all
                .subscribe(Utils.subscriber());
    }
}
