package com.example.demo.controller;


import com.example.demo.dto.DateParm;
import com.example.demo.mapper.LiveInfoMapper;
import com.example.demo.model.LiveInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("/liveInfo")
@Slf4j
public class SystemController {

    @Autowired
    LiveInfoMapper liveInfoMapper;
    /**
     * @return
     */
    @RequestMapping("/getLiveInfo")
    public ModelAndView getLiveInfo(@RequestParam(required = false) String startTime, @RequestParam(required = false) String endTime){
        ModelAndView mv = new ModelAndView();
        LocalDate endParm = null;
        LocalDate startParm = null;
        if (endTime != null) {
            endParm = LocalDate.parse(endTime, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        }
        if (startTime != null) {
            startParm = LocalDate.parse(startTime, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        }

        if (endTime == null && startTime == null) {
            endParm = LocalDate.now();
        }
        List<LiveInfo> liveInfos = liveInfoMapper.getLiveInfoListByDate(startParm, endParm);
        mv.addObject("liveInfos", liveInfos);
        mv.setViewName("index");
        return mv;
    }

}
