package org.lnr;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Getter
@Setter
 class DonutStorage {
    private int donutsNumber;
    public DonutStorage(int donutsNumber) {this.donutsNumber = donutsNumber;}

 }

class Consumer {
    private final DonutStorage donutStorage;
    public Consumer(DonutStorage donutStorage) {this.donutStorage = donutStorage;}

    /**
     * Subtracts the given number from the DonutStorage's donutsNumber.
     * @param numberOfItemsToConsume Number that will be subtracted from the donutsNumber
     */
    public void consume(int numberOfItemsToConsume) {
        donutStorage.setDonutsNumber(donutStorage.getDonutsNumber() - numberOfItemsToConsume);
    }
}

@Slf4j
public class Main {
    public static void main(String[] args) {
        int consumersNumber = 10;
        DonutStorage donutStorage = new DonutStorage(20);
        ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        try {
            Consumer consumer = new Consumer(donutStorage);
            for (int i = 0; i < consumersNumber; i++) {
                executor.submit(() -> consumer.consume(1));
            }
        } catch (Exception e) {
            log.error("Error during donut consumption", e);
        } finally {
            executor.shutdown();
        }


        log.info("Number of remaining donuts: {}", donutStorage.getDonutsNumber());
    }
}