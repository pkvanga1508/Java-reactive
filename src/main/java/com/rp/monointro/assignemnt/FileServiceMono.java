package com.rp.monointro.assignemnt;

import com.rp.util.Utils;
import reactor.core.publisher.Mono;

public class FileServiceMono {

    public static Mono<String> read(String fileName) {
        return Mono.fromSupplier(() -> FileService.readFile(fileName));
    }

    public static Mono<Void> write(String fileName) {
        //This is from Runnable as it does not return anything
        return Mono.fromRunnable(() -> FileService.writeFile(fileName, "New File Content"));
    }

    public static Mono<Void> delete(String fileName) {
        //This is from Runnable as it does not return anything
        return Mono.fromRunnable(() -> FileService.deleteFile(fileName));
    }

    public static void main(String[] args) {
        read("file01.txt").subscribe(Utils.onNext(), Utils.onError(), Utils.onComplete());
        read("file02.txt").subscribe(Utils.onNext(), Utils.onError(), Utils.onComplete());
        write("file03.txt").subscribe(Utils.onNext(), Utils.onError(), Utils.onComplete());
        read("file03.txt").subscribe(Utils.onNext(), Utils.onError(), Utils.onComplete());
        delete("file04.txt").subscribe(Utils.onNext(), Utils.onError(), Utils.onComplete());
        delete("file03.txt").subscribe(Utils.onNext(), Utils.onError(), Utils.onComplete());
    }
}
