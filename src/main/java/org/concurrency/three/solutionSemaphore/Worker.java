package org.concurrency.three.solutionSemaphore;

import java.util.concurrent.Semaphore;

public class Worker extends Thread{

    private final int workerId;

    private final Semaphore millingMachine;

    public Worker(int workerId, Semaphore millingMachine){
        this.workerId = workerId;
        this.millingMachine = millingMachine;
        this.start();
    }

    public void run(){
        try {
            millingMachine.acquire();
            System.out.println("worker " + this.workerId + " occupy production machine ...");
            Thread.sleep(2000);
            System.out.println("worker " + this.workerId + " release production machine");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            millingMachine.release();
        }
    }
}
