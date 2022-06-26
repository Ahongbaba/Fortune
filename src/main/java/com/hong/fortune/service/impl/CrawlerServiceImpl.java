package com.hong.fortune.service.impl;

import com.hong.fortune.common.Constants;
import com.hong.fortune.service.CrawlerService;
import com.hong.fortune.service.dto.LotteryGovDTO;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * 爬虫
 *
 * @author Ahong
 */
@Service
@Slf4j
public class CrawlerServiceImpl implements CrawlerService {

    @Override
    public LotteryGovDTO getLotteryGov() {
        try {
            Document document = Jsoup.connect(Constants.LOTTERY_URL)
                    .header("user-agent",
                            "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/102.0.0.0 Safari/537.36").get();

            final Element issueElement = document.getElementsByClass("cfont2").get(0)
                    .getElementsByTag("strong").get(0);
            final String issue = issueElement.toString().substring(8, 13);

            final Elements redElements = document.getElementsByClass("ball_red");
            final Elements blueElements = document.getElementsByClass("ball_blue");
            String firstNumber = redElements.get(0).toString().substring(21, 23);
            String secondNumber = redElements.get(1).toString().substring(21, 23);
            String thirdNumber = redElements.get(2).toString().substring(21, 23);
            String fourthNumber = redElements.get(3).toString().substring(21, 23);
            String fifthNumber = redElements.get(4).toString().substring(21, 23);
            String sixthNumber = blueElements.get(0).toString().substring(22, 24);
            String seventhNumber = blueElements.get(1).toString().substring(22, 24);

            return LotteryGovDTO.builder()
                    .issue(issue)
                    .firstNumber(firstNumber)
                    .secondNumber(secondNumber)
                    .thirdNumber(thirdNumber)
                    .fourthNumber(fourthNumber)
                    .fifthNumber(fifthNumber)
                    .sixthNumber(sixthNumber)
                    .seventhNumber(seventhNumber)
                    .build();
        } catch (IOException e) {
            log.error("getLotteryGov error: ", e);
        }
        return null;
    }
}
