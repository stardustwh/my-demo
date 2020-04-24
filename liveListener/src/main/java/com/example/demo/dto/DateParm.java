package com.example.demo.dto;

import lombok.Data;

import javax.persistence.Column;
import java.time.LocalDate;
import java.util.Date;

@Data
public class DateParm {

    private LocalDate startTime;

    private LocalDate endTime;
}
