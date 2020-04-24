package com.example.demo.service;

import com.example.demo.dto.LiveDateDTO;
import com.example.demo.mapper.LiveInfoMapper;
import com.example.demo.model.LiveInfo;
import com.xuxueli.crawler.XxlCrawler;
import com.xuxueli.crawler.parser.PageParser;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

@Component
@Order(value = 1)
public class ReptileService implements CommandLineRunner {
    @Autowired
    LiveInfoMapper liveInfoMapper;

    private Map<String, String> map = new HashMap<>();

    public void parseData(String date) {

        XxlCrawler crawler = new XxlCrawler.Builder()
                .setUrls("https://yq.aliyun.com/webinar/schedule?date=" + date)
                .setWhiteUrlRegexs("https://yq\\.aliyun\\.com/webinar/schedule\\?date=\\d{4}-\\d{2}")
                .setThreadCount(3)
                .setPageParser(new PageParser<LiveInfo>() {
                    @Override
                    public void parse(Document html, Element pageVoElement, LiveInfo liveInfo) {
                        // 解析封装 PageVo 对象
                        String pageUrl = html.baseUri();
                        String startTime = date + "-" + liveInfo.getDate().substring(3,5);
                        SimpleDateFormat sdf = null;
                        try {
                            sdf = new SimpleDateFormat("yyyy-MM-dd");
                            liveInfo.setStartTime(sdf.parse(startTime));
                            liveInfo.setEndTime(sdf.parse(startTime));
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                        /*DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                        liveInfo.setStartTime(LocalDate.parse(startTime, dateTimeFormatter));
                        liveInfo.setEndTime(LocalDate.parse(startTime, dateTimeFormatter));*/
                        liveInfoMapper.insertUseGeneratedKeys(liveInfo);
                        System.out.println(pageUrl + "：" + liveInfo.toString());
                    }
                })
                .build();

        System.out.println("start");
        crawler.start(true);
        System.out.println("end");
    }

    public void parseDate(String date) {

        XxlCrawler crawler = new XxlCrawler.Builder()
                .setUrls("https://yq.aliyun.com/webinar/schedule?date=" + date)
                .setWhiteUrlRegexs("https://yq\\.aliyun\\.com/webinar/schedule\\?date=\\d{4}-\\d{2}")
                .setThreadCount(3)
                .setPageParser(new PageParser<LiveDateDTO>() {
                    @Override
                    public void parse(Document html, Element pageVoElement, LiveDateDTO liveDateDTO) {
                        // 解析封装 PageVo 对象
                        String pageUrl = html.baseUri();
//                        liveInfoMapper.insertUseGeneratedKeys(liveInfo);
                        map.put("liveDate",liveDateDTO.getDateTime());
                        System.out.println(pageUrl + "：" + liveDateDTO.toString());
                    }
                })
                .build();

        System.out.println("start");
        crawler.start(true);
        System.out.println("end");
    }

    @Override
    public void run(String... args) throws Exception {
        String date = "2020-04";
        parseDate(date);
        String dates = map.get("liveDate");
        String[] dates2 = dates.split(" ");
        for (String date1 : dates2) {
            parseData(date1);
        }

    }
}
