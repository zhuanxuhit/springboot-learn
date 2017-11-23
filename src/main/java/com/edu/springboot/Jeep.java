package com.edu.springboot;

import ch.qos.logback.core.util.TimeUtil;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component("jeep")
public class Jeep implements Runnable{
    @Override
    public void run() {
        try {
            for(int i=0;i<10;i++){
                System.out.println("========"+i+"=======");
                TimeUnit.SECONDS.sleep(1);
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
