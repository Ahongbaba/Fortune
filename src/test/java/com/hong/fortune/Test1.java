package com.hong.fortune;

import com.hong.fortune.service.CrawlerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

/**
 * @author Ahong
 */
@SpringBootTest(classes = FortuneApplication.class)
@ActiveProfiles
public class Test1 {

    @Autowired
    private CrawlerService crawlerService;

    @Test
    void test1() {
        crawlerService.getLotteryGov();
    }
}
