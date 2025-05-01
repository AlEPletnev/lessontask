package org.concurrency.three.solutionSemaphore;

import java.util.concurrent.Semaphore;

public class MainWorker {
    public static void main(String[] args) {
        //Semaphore millingMachine = new Semaphore(5);
        Semaphore millingMachine = new Semaphore(1); // для теста задал, чтобы вывод проверить
        new Worker(1,millingMachine);
        new Worker(2,millingMachine);
        new Worker(3,millingMachine);
        new Worker(4,millingMachine);
        new Worker(5,millingMachine);
        new Worker(6,millingMachine);
        new Worker(7,millingMachine);
        new Worker(8,millingMachine);
    }
}
