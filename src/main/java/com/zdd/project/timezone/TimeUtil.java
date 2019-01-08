package com.zdd.project.timezone;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

/**
 * <p>
 *
 * @author <a href="zdd109067@alibaba-inc.com">zhoudongdong</a>
 * @version create on 2018/4/22 ??8:55
 */
public class TimeUtil {
    public static final String DEFAULT_DATE_PATTERN = "yyyyMMdd";
    public static final String DATE_PATTERN = "yyyy-MM-dd";

    public static final String TIME_PATTER = " HH:mm:ss";
    public static final String TIME_PATTER_WITH_MILLIS = " HH:mm:ss.SSS";

    public static final String MID_NIGHT_TIME = " 00:00:00";

    public static LocalDateTime ofEpochMillis(long millis) {
        return ofEpochMillis(millis, ZoneId.systemDefault());
    }

    public static LocalDateTime ofEpochMillis(long millis, ZoneId zoneId) {
        return LocalDateTime.ofInstant(Instant.ofEpochMilli(millis), zoneId);
    }

    public static LocalDateTime ofEpochSecond(long second) {
        return ofEpochSecond(second, ZoneId.systemDefault());
    }

    public static LocalDateTime ofEpochSecond(long second, ZoneId zoneId) {
        return LocalDateTime.ofInstant(Instant.ofEpochSecond(second), zoneId);
    }

    public static long toEpochMillis(LocalDateTime localDateTime) {
        return localDateTime.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
    }

    public static long toEpochMillis(LocalDateTime localDateTime, ZoneId zoneId) {
        return localDateTime.atZone(zoneId).toInstant().toEpochMilli();
    }

    public static int getDateIntWithDefaultPattern(LocalDateTime dateTime) {
        return Integer.valueOf(getDateWithDefaultPattern(dateTime));
    }

    public static int getDateIntWithDefaultPattern(LocalDate date) {
        return Integer.valueOf(getDateWithDefaultPattern(date));
    }

    public static String getDateWithDefaultPattern(LocalDate date) {
        return date.format(DateTimeFormatter.ofPattern(DEFAULT_DATE_PATTERN));
    }

    public static String getDateWithDefaultPattern(LocalDateTime dateTime) {
        LocalDate date = LocalDate.of(dateTime.getYear(), dateTime.getMonth(), dateTime.getDayOfMonth());
        return date.format(DateTimeFormatter.ofPattern(DEFAULT_DATE_PATTERN));
    }

    public static String getDateWithDefaultPattern(LocalDate date, String pattern) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(pattern);
        return date.format(dateTimeFormatter);
    }

    public static LocalDateTime timeFromYYYYYMMDD(String date, String datePattern) {
        date = date + MID_NIGHT_TIME;
        return LocalDateTime.parse(date, DateTimeFormatter.ofPattern(datePattern + TIME_PATTER));
    }

    public static LocalDateTime timeFromYYYYYMMDD(int date) {
        String dateStr = date + MID_NIGHT_TIME;
        return LocalDateTime.parse(dateStr, DateTimeFormatter.ofPattern(DEFAULT_DATE_PATTERN + TIME_PATTER));
    }

    public static LocalDate dateFromYYYYYMMDD(String date, String datePattern) {
        return LocalDate.parse(date, DateTimeFormatter.ofPattern(datePattern));
    }

    public static LocalDate dateFromYYYYYMMDD(int date) {
        return LocalDate.parse(String.valueOf(date), DateTimeFormatter.ofPattern(DEFAULT_DATE_PATTERN));
    }

    public static LocalDateTime getStartDateTimeOfTheDay(LocalDateTime dateTime) {
        return dateTime.withHour(0).withMinute(0).withSecond(0).withNano(0);
    }

    public static LocalDateTime getEndDateTimeOfTheDay(LocalDateTime dateTime) {
        return dateTime.withHour(23).withMinute(59).withSecond(59).withNano(999999999);
    }
}
