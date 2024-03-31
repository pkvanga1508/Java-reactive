package com.rp.monointro;

import com.rp.util.Utils;
import reactor.core.publisher.Mono;

public class MonoFromRunnable {

    public static void main(String[] args) {

        Mono.fromRunnable(timeConsumingProcess())
                .subscribe(Utils.onNext(),
                        Utils.onError(),
                        () -> {
                            System.out.println("Process is done. Sending Emails...");
                        });
    }

    private static Runnable timeConsumingProcess() {

        return () -> {
            Utils.sleepSeconds(3);
            System.out.println("Operation Completed");
        };
    }
}
