package org.concurrency.one;

import java.util.concurrent.CompletableFuture;

public class LegVar2 implements Runnable{

    private final String name;

    public LegVar2(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        while (true) {
            System.out.println(name);
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String[] args) {
        CompletableFuture.allOf(
                CompletableFuture.runAsync(new LegVar2("left")),
                CompletableFuture.runAsync(new LegVar2("right"))
        ).join();
    }
}
