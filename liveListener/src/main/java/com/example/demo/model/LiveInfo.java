package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.xuxueli.crawler.annotation.PageFieldSelect;
import com.xuxueli.crawler.annotation.PageSelect;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@PageSelect(cssQuery = ".video-item")
@Data
@Table(name = "live_info")
public class LiveInfo {

    /**
     * 主键
     */
    @Id
    @Column(name = "`id`")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @PageFieldSelect(cssQuery = ".title-info")
    @Column(name = "title")
    private String title;

    //        @PageFieldSelect(cssQuery = ".title-info")
    @Column(name = "startTime")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startTime;

    //        @PageFieldSelect(cssQuery = ".title-info")
    @Column(name = "endTime")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endTime;

    @PageFieldSelect(cssQuery = ".state-info")
    @Column(name = "liveState")
    private String liveState;

    @PageFieldSelect(cssQuery = ".time-titel")
    @Column(name = "date")
    private String date;

    @PageFieldSelect(cssQuery = ".time-info")
    @Column(name = "dateTime")
    private String dateTime;


}
