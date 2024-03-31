package com.rp.fluxadvanced.assignment;

import reactor.core.publisher.Flux;
import reactor.core.publisher.SynchronousSink;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.concurrent.Callable;
import java.util.function.BiFunction;
import java.util.function.Consumer;

public class FileReaderService {

    public Flux<String> read(Path path) {
        return Flux.generate(openFileReader(path), readFile(), closeReader());
    }

    public Callable<BufferedReader> openFileReader(Path path) {
        return () -> Files.newBufferedReader(path);
    }

    private BiFunction<BufferedReader, SynchronousSink<String>, BufferedReader> readFile() {

        return (br, sink) -> {
            try {
                String line = br.readLine();
                if(line == null) {
                    sink.complete();
                } else {
                    sink.next(line);
                }
            } catch (IOException e) {
                sink.error(e);
            }
            return br;
        };
    }

    private Consumer<BufferedReader> closeReader() {
        return br -> {
            try {
                br.close();
                System.out.println("Closed");
            } catch (IOException e) {
                e.printStackTrace();
            }
        };
    }


}
