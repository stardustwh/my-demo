package com.example.demo.job;


import com.example.demo.controller.GreetingController;
import com.example.demo.model.LiveInfo;
import com.example.demo.service.WebSocketService;
import com.xuxueli.crawler.XxlCrawler;
import com.xuxueli.crawler.parser.PageParser;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Component
@EnableScheduling
public class LiveInfoJob {

    @Autowired
    WebSocketService socketService;

//    private Map<String, String> map = new HashMap<>();
    private volatile static List<LiveInfo> list = new ArrayList<>();

    @Scheduled(cron = "0/30 * * * * ?")
    public void runfirst(){
        System.out.println("********first job is ok******");
        String date = LocalDate.now().getYear() + "-" + LocalDate.now().getMonth();
        date = "2020-04";
        parseData(date);

        try {
            list.forEach(item -> {
                try {
                    socketService.sendMsg(item);
//                    controller.sendInfo(item);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

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
                        liveInfo.setEndTime(LocalDate.parse(startTime, dateTimeFormatter));
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");*/
//                        list.add(liveInfo);
                        LocalDate date2 = liveInfo.getStartTime().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                        if (LocalDate.now().isEqual(date2)) {
                            if ("正在直播".equals(liveInfo.getLiveState())) {
                                liveInfo.setLiveState("直播开始");
                            } else {
                                liveInfo.setLiveState("直播新增");
                            }
                            list.add(liveInfo);
                        }
/*                        if (new Date().compareTo(liveInfo.getStartTime()) == 0) {
                            if ("正在直播".equals(liveInfo.getLiveState())) {
                                liveInfo.setLiveState("直播开始");
                            } else {
                                liveInfo.setLiveState("直播新增");
                            }
                            list.add(liveInfo);
                        }*/
//                        liveInfoMapper.insertUseGeneratedKeys(liveInfo);
                        System.out.println(pageUrl + "：" + liveInfo.toString());
                    }
                })
                .build();

        System.out.println("start");
        crawler.start(true);
        System.out.println("end");
    }

/*    @Scheduled(fixedRate = 1000 * 10)
    public void runsecend(){
        System.out.println("********second job is ok******");
    }

    @Scheduled(fixedDelay=1000)
    public void runThird(){
        System.out.println("********third job is ok*******");
    }*/

}
