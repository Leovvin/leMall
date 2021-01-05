package com.example.mall.runner;

import com.example.mall.biz.InventoryService;
import com.example.mall.model.Inventory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Component
@ConditionalOnProperty(name = "runner",havingValue = "inventoryLT")
public class CommandRunner implements CommandLineRunner {

    @Autowired
    InventoryService inventoryService;
    @Value("${spring.datasource.dbcp2.maxTotal}")
    int threadNum;

    @Override
    public void run(String... args) throws Exception {

        ExecutorService executorService = Executors.newFixedThreadPool(threadNum);
        for (int i=0;i<threadNum;i++){
            executorService.submit(new Updater());
        }
        new Thread(new Monitor()).start();
    }


    class Updater implements Runnable{
        @Override
        public void run() {
            while (true){
                boolean decreaseSucc = inventoryService.increaseStock(1l,1);
                if (!decreaseSucc){
                    break;
                }

            }
        }
    }

    class Monitor implements Runnable{
        int lastStock=0;
        @Override
        public void run() {
            while (true){
                Inventory inventory = inventoryService.findById(1l);
                int stock = inventory.getStock();
                System.out.println("stock increased:"+(stock-lastStock));
                lastStock = stock;
                try {
                    Thread.sleep(1000l);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
