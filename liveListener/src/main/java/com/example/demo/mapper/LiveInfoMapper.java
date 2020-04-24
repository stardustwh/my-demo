package com.example.demo.mapper;


import com.example.demo.dto.DateParm;
import com.example.demo.model.LiveInfo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Component
public interface LiveInfoMapper extends Mapper<LiveInfo>, MySqlMapper<LiveInfo> {

    @Select("<script>" +
            " select * from live_info a " +
            " where 1 = 1 " +

            " <if test=\" startTime!=null  \" >" +
            " and a.startTime >= #{startTime} " +
            " </if>" +

            " <if test=\" endTime!=null \" >" +
            " and #{endTime} > a.endTime " +
            " </if>" +
            " </script>")
    List<LiveInfo> getLiveInfoListByDate(@Param("startTime") LocalDate startTime,
                                         @Param("endTime") LocalDate endTime);
}
