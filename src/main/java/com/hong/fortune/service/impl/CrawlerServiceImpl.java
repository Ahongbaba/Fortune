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
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

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
            final Document document = Jsoup.connect(Constants.LOTTERY_URL)
                    .header("user-agent",
                            "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/102.0.0.0 Safari/537.36").get();

            final Element issueElement = document.getElementsByClass("cfont2").get(0)
                    .getElementsByTag("strong").get(0);
            final String issue = issueElement.toString().substring(8, 13);

            final Elements redElements = document.getElementsByClass("ball_red");
            final Elements blueElements = document.getElementsByClass("ball_blue");
            final String firstNumber = redElements.get(0).toString().substring(21, 23);
            final String secondNumber = redElements.get(1).toString().substring(21, 23);
            final String thirdNumber = redElements.get(2).toString().substring(21, 23);
            final String fourthNumber = redElements.get(3).toString().substring(21, 23);
            final String fifthNumber = redElements.get(4).toString().substring(21, 23);
            final String sixthNumber = blueElements.get(0).toString().substring(22, 24);
            final String seventhNumber = blueElements.get(1).toString().substring(22, 24);

            final List<Integer> redNumber = new ArrayList<>();
            redNumber.add(Integer.valueOf(firstNumber));
            redNumber.add(Integer.valueOf(secondNumber));
            redNumber.add(Integer.valueOf(thirdNumber));
            redNumber.add(Integer.valueOf(fourthNumber));
            redNumber.add(Integer.valueOf(fifthNumber));
            final List<Integer> blueNumber = new ArrayList<>();
            blueNumber.add(Integer.valueOf(sixthNumber));
            blueNumber.add(Integer.valueOf(seventhNumber));


            return LotteryGovDTO.builder()
                    .issue(Integer.valueOf(issue))
                    .gmtLottery(Instant.now()) // TODO: 2022/7/3 获取时间
                    .redNumber(redNumber)
                    .blueNumber(blueNumber)
                    .build();
        } catch (IOException e) {
            log.error("getLotteryGov error: ", e);
        }
        return null;
    }
}
