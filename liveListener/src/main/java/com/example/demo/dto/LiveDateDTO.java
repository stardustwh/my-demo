package com.example.demo.dto;

import com.xuxueli.crawler.annotation.PageFieldSelect;
import com.xuxueli.crawler.annotation.PageSelect;
import lombok.Data;

import javax.persistence.Column;

@PageSelect(cssQuery = ".yq-schedule-list")
@Data
public class LiveDateDTO {

    @PageFieldSelect(cssQuery = "#date-select")
    private String dateTime;
}
