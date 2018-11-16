package com.zdd.project.timezone;

import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;

/**
 * <p>
 *
 * @author <a href="zdd109067@alibaba-inc.com">zhoudongdong</a>
 * @version create on 2017/5/22 下午5:49
 */
public abstract class TimeZoneUtil {
    private static final int oneHour = 3600000;
    private static final String gmt = "GMT";

    /**
     * zoneId --> gmt
     */
    private static final Map<String, String> zoneMap;

    static {
        zoneMap = createZoneMap();
    }

    private static Map<String, String> createZoneMap() {
        String[] zoneIds = TimeZone.getAvailableIDs();
        int length = zoneIds.length;
        TimeZone timeZone = null;
        // 存储时区列表+偏移量到map中,all is 623?
        Map<String, String> map = new HashMap<>(650);
        long offset = 0L;
        String diplayOffset = "";
        for (int i = 0; i < length; i++) {
            // 获取给定 ID 的 TimeZone
            String zoneId = zoneIds[i];
            timeZone = TimeZone.getTimeZone(zoneId);
            // 返回添加到 UTC 以获取此时区中的标准时间的时间偏移量（以毫秒为单位）。
            offset = timeZone.getRawOffset();
            // 对偏移量做显示，如GMT-09:30、GMT+09:30
            diplayOffset = appendZoneSuffix(offset);
            // 存储到map中，形式为Hongkong---GMT+08:00
            map.put(zoneId, diplayOffset);
        }
        return map;
    }

    private static String appendZoneSuffix(long offset) {
        // 将偏移量转化为小时（小数去除不要）
        long hour = Long.valueOf((offset / oneHour));
        // 偏移量对小时取余数，得到小数（以毫秒为单位）
        double decimals = offset % oneHour;
        // 显示为09:30分钟形式
        double decimalsZone = (decimals / oneHour) * 60 / 100;
        String sAdd = (hour >= 0) ? "+" : "-";
        hour = hour > 0 ? hour : -hour;
        String sHour = hour + "";
        if (sHour.length() == 1) {
            sHour = '0' + sHour;
        }

        decimalsZone = decimalsZone < 0 ? -decimalsZone : decimalsZone;
        String sDecimalsZone = decimalsZone + "";
        sDecimalsZone = sDecimalsZone.substring(2);
        if (sDecimalsZone.length() == 1) {
            sDecimalsZone = sDecimalsZone + '0';
        } else if (sDecimalsZone.length() >= 3) {
            sDecimalsZone = sDecimalsZone.substring(0, 2);
        }

        return gmt + sAdd + sHour + ':' + sDecimalsZone;
    }

    public static String getGmt(String zoneId) {
        if (zoneId == null) {
            TimeZone defaultZone = TimeZone.getDefault();
            long offset = defaultZone.getRawOffset();
            // 对偏移量做显示，如GMT-09:30、GMT+09:30
            return appendZoneSuffix(offset);
        }
        return zoneMap.get(zoneId);
    }


    public static void main(String[] args) {
        TimeZone timeZone = TimeZone.getTimeZone("Asia/Kolkata");
        System.out.println(timeZone);
    }
}
