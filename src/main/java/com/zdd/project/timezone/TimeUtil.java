package com.zdd.project.timezone;

import java.time.Instant;
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
    public static final DateTimeFormatter MILLIS_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
    public static final DateTimeFormatter SECOND_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

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

    public static long toEpochMillisWithDelta(LocalDateTime localDateTime, int delta, MillisUnit millisUnit) {
        return toEpochMillis(localDateTime) + delta * millisUnit.value;
    }

    public enum MillisUnit {
        SECOND_TO_MILLIS(1000),
        MINUTE_TO_MILLIS(60 * 1000),
        HOUR_TO_MILLIS(60 * 60 * 1000),
        DAY_TO_MILLIS(24 * 60 * 60 * 1000);

        private long value;

        MillisUnit(long value) {
            this.value = value;
        }

        public long getValue() {
            return value;
        }
    }

    public static void main(String[] args) {
        long time = 1537255199495351L;
        LocalDateTime dateTime = TimeUtil.ofEpochMillis(time);
        System.out.println(dateTime.format(TimeUtil.SECOND_FORMATTER));
        System.out.println(dateTime.format(TimeUtil.MILLIS_FORMATTER));
    }
}
