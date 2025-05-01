package org.concurrency.three.solutionExecutor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainWorker {
    public static void main(String[] args) {
        //ExecutorService executorService = Executors.newFixedThreadPool(5);
        ExecutorService executorService = Executors.newFixedThreadPool(1); // для теста
        for(int i = 1; i <= 8; i++){
            int finalI = i;
            executorService.execute(()->TaskWorker.workOnMachine(finalI));
        }
    }
}
