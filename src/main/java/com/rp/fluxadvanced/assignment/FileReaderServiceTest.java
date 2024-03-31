package com.rp.fluxadvanced.assignment;

import com.rp.util.Utils;
import reactor.core.publisher.Flux;
import reactor.core.publisher.SynchronousSink;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.Callable;
import java.util.function.BiFunction;
import java.util.function.Consumer;

public class FileReaderServiceTest {

    public static void main(String[] args) {
        FileReaderService fileReaderService = new FileReaderService();
        fileReaderService.read(Paths.get("src/main/resources/sec03/file01.txt")).take(20)
                .subscribe(Utils.subscriber());
    }


}
