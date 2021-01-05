package com.example.mall.runner;

import com.example.mall.biz.InventoryService;
import com.example.mall.biz.UserService;
import com.example.mall.model.Inventory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

@Component
@ConditionalOnProperty(name = "runner",havingValue = "inventoryLT")
public class CommandRunner implements CommandLineRunner {

    @Autowired
    InventoryService inventoryService;
    @Autowired
    UserService userService;
    @Value("${spring.datasource.dbcp2.maxTotal}")
    int threadNum;

    Counter counter = new Counter();

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
                counter.increase();
                userService.book(1,1,1,1);
//                boolean decreaseSucc = inventoryService.increaseStockForUpdate(1l,1);
//                if (!decreaseSucc){
//                    break;
//                }
            }
        }
    }

    class Monitor implements Runnable{
        int lastNum=0;
        @Override
        public void run() {
            while (true){
                int currentVal = counter.getValue();
                System.out.println(currentVal-lastNum);
                lastNum = currentVal;
                try {
                    Thread.sleep(1000l);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    class Counter{
        int value=0;

        ReentrantReadWriteLock.ReadLock readLock;
        ReentrantReadWriteLock.WriteLock writeLock;
        Counter(){
            ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
            readLock = readWriteLock.readLock();
            writeLock = readWriteLock.writeLock();
        }

        void increase(){
            try {
                writeLock.lock();
                value++;
            }finally {
                writeLock.unlock();
            }
        }

        int getValue(){
            try {
                readLock.lock();
                return value;
            }finally {
                readLock.unlock();
            }
        }
    }
}
