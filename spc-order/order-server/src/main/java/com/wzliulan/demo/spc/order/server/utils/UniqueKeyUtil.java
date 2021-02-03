package com.wzliulan.demo.spc.order.server.utils;

import lombok.extern.slf4j.Slf4j;

import java.util.Random;

@Slf4j
public class UniqueKeyUtil {
    public static synchronized String generateUniqueKey() {
        Random random = new Random();
        Integer randomNumber = random.nextInt(900000) + 100000;
        log.info("randomNumber={}", randomNumber);
        String key = System.currentTimeMillis()+"/"+randomNumber;
        return key;
    }
}
