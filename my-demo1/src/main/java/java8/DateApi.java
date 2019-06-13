package java8;

import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Locale;

public class DateApi {

    @Test
    public void test1(){

        Clock clock = Clock.systemDefaultZone();
        long millis = clock.millis();
        System.out.println(millis);
        Instant instant = clock.instant();
        System.out.println(instant);
        Date legacyDate = Date.from(instant);
        System.out.println(legacyDate);
        System.out.println(LocalDate.now());

        //输出所有区域标识符
        System.out.println(ZoneId.getAvailableZoneIds());

        ZoneId zoneId = ZoneId.of("Europe/Berlin");
        ZoneId zoneId1 = ZoneId.of("Brazil/East");
        System.out.println(zoneId.getRules());
        System.out.println(zoneId1.getRules());

        LocalTime now1 = LocalTime.now(zoneId);
        LocalTime now2 = LocalTime.now(zoneId1);
        System.out.println(now1.isBefore(now2));

        long hoursBetween = ChronoUnit.HOURS.between(now1,now2);
        long minutesBetween = ChronoUnit.MINUTES.between(now1,now2);

        System.out.println(hoursBetween);
        System.out.println(minutesBetween);

        LocalTime late = LocalTime.of(23,59,59);
        System.out.println(late);

        DateTimeFormatter germanFormatter =
                DateTimeFormatter
                .ofLocalizedTime(FormatStyle.SHORT)
                .withLocale(Locale.GERMAN);
        LocalTime localTime = LocalTime.parse("13:38",germanFormatter);
        System.out.println(localTime);
        System.out.println(LocalTime.now());

        LocalDate today = LocalDate.now();
        System.out.println("今天的日期："+today);

        LocalDate tomorrow = today.plus(1,ChronoUnit.DAYS);
        System.out.println("明天的日期是："+tomorrow);

        LocalDate yesterday = tomorrow.minusDays(2);
        System.out.println("昨天的日期是："+yesterday);

        LocalDate independenceDay = LocalDate.of(2019,Month.JUNE,12);
        DayOfWeek dayOfWeek = independenceDay.getDayOfWeek();
        System.out.println("今天是周几："+dayOfWeek);


    }

    @Test
    public void test2(){

        String str1 = "2019==06==12 14时30分50秒";
        DateTimeFormatter formatter1 = DateTimeFormatter
                .ofPattern("yyyy==MM==dd HH时mm分ss秒");

        LocalDateTime dt1 = LocalDateTime.parse(str1,formatter1);
        System.out.println(dt1);

        LocalDateTime rightNow = LocalDateTime.now();
        String date = DateTimeFormatter.ISO_LOCAL_DATE_TIME.format(rightNow);
        System.out.println(date);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("YYYY-MM-dd HH:mm:ss");
        System.out.println(formatter.format(rightNow));
    }

    @Test
    public void test3(){
       /* LocalDateTime sylvester = LocalDateTime.of(2019,Month.JUNE,12,14,52,20);

        DayOfWeek dayOfWeek = sylvester.getDayOfWeek();
        System.out.println(dayOfWeek);

        Month month = sylvester.getMonth();
        System.out.println(month);

        long minuteOfDay = sylvester.getLong(ChronoField.MINUTE_OF_DAY);
        System.out.println(minuteOfDay);

        Instant instant = sylvester.atZone(ZoneId.systemDefault()).toInstant();
        Date legacyDate = Date.from(instant);
        System.out.println(legacyDate);*/

       /* DateTimeFormatter formatter =
                DateTimeFormatter
                .ofPattern("MMM dd, yyyy - HH:mm");
        LocalDateTime parsed = LocalDateTime.parse("Nov 03, 2014 - 07:03",formatter);
        String string = formatter.format(parsed);
        System.out.println(string);*/

        DateTimeFormatter formatter =
                DateTimeFormatter
                        .ofPattern("MMM-dd,yyyy-HH:mm");
        LocalDateTime parsed = LocalDateTime.parse("Nov-03,2014-07:13", formatter);
        String string = formatter.format(parsed);
        System.out.println(string);     // Nov 03, 2014 - 07:13
    }
}
