package com.example.demo.service;

import com.xuxueli.crawler.XxlCrawler;
import com.xuxueli.crawler.annotation.PageFieldSelect;
import com.xuxueli.crawler.annotation.PageSelect;
import com.xuxueli.crawler.parser.PageParser;
import lombok.Data;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.util.ArrayList;
import java.util.List;

/**
 * 爬虫示例01：爬取页面数据并封装VO对象
 *
 * @author xuxueli 2017-10-09 19:48:48
 */
public class XxlCrawlerTest {

    @PageSelect(cssQuery = ".video-item")
    @Data
    public static class PageVo {


        @PageFieldSelect(cssQuery = ".title-info")
        private String title;

//        @PageFieldSelect(cssQuery = ".title-info")
        private String startTime;

//        @PageFieldSelect(cssQuery = ".title-info")
        private String endTime;

        @PageFieldSelect(cssQuery = ".state-info")
        private String liveState;

        @PageFieldSelect(cssQuery = ".time-titel")
        private String date;

        @PageFieldSelect(cssQuery = ".time-info")
        private String dateTime;


/*        @Override
        public String toString() {
            return "PageVo{" +
                    "repository='" + repository + '\'' +
                    ", description='" + description + '\'' +
                    '}';
        }*/
    }

    public static void main(String[] args) {

        XxlCrawler crawler = new XxlCrawler.Builder()
                .setUrls("https://yq.aliyun.com/webinar/schedule?date=2020-04")
                .setWhiteUrlRegexs("https://yq\\.aliyun\\.com/webinar/schedule\\?date=2020-04")
                .setThreadCount(3)
                .setPageParser(new PageParser<PageVo>() {
                    @Override
                    public void parse(Document html, Element pageVoElement, PageVo pageVo) {
                        // 解析封装 PageVo 对象
                        String pageUrl = html.baseUri();

                        List<PageVo> list = new ArrayList<>();
                        list.add(pageVo);
                        System.out.println(pageUrl + "：" + pageVo.toString());
                    }
                })
                .build();

        System.out.println("start");
        crawler.start(true);
        System.out.println("end");
    }

}
