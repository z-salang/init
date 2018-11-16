package com.zdd.file;

import com.zdd.project.number.UnsignedAndSignedTrans;
import com.zdd.project.timezone.TimeUtil;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;

/**
 * <p>
 *
 * @author <a href="zdd109067@alibaba-inc.com">zhoudongdong</a>
 * @version create on 2018/9/19 ??7:12
 */
public class ReadFileEngine {

    private static final String SINGLE_QUOTES = "'";
    private static final String COMMA = ",";

    private static final String SQL_INSERT_TITLE = "insert into click_chargelog20180918( srch_id ," +
            " click_id , version , bid , price , type , click_time , userid , packid , unitid , ideaid ," +
            " interestid , regionid , platform , srch_time , show_time , media_id , slot_id , ad_resource_id , " +
            "ghost_pack_id , create_time , business , group_id , campaign_id , creative_id ) values";

    private FileReader fileReader;
    private BufferedReader bufferedReader;

    public void start(String filePath) {
        try {
            initIO(filePath);
            readFile();
            closeIOQuietly();
        } catch (IOException e) {
            closeIOQuietly();
            e.printStackTrace();
        }
    }

    private void readFile() throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(SQL_INSERT_TITLE);

        String line;
        while (null != (line = bufferedReader.readLine())) {
            String sqlValue = transToSQLValue(line);
            stringBuilder.append(sqlValue);
        }

        String wholeSql = stringBuilder.toString().substring(0, stringBuilder.length() - 1);
        System.out.println(wholeSql);
    }

    private String transToSQLValue(String line) {
        String[] values = line.split(",");
        convert(values);
        return toSqlValue(values);
    }

    private String toSqlValue(String[] values) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("(");
        for (int i = 0; i < values.length; ++i) {
            String value = values[i];

            if (i == 6 || i == 14 || i == 15 || i == 20) {
                stringBuilder.append(SINGLE_QUOTES).append(value).append(SINGLE_QUOTES).append(COMMA);
            } else {
                stringBuilder.append(value).append(COMMA);
            }
        }

        String substring = stringBuilder.toString().substring(0, stringBuilder.length() - 1);
        substring += "),";

        return substring;
    }

    private void convert(String[] values) {
        values[0] = String.valueOf(UnsignedAndSignedTrans.unsignedToSigned(values[0])); // srch_id
        values[1] = String.valueOf(UnsignedAndSignedTrans.unsignedToSigned(values[1])); // click_id

        long clickTimeStamp = Long.valueOf(values[6]) / 1000;
        LocalDateTime clickDateTime = TimeUtil.ofEpochMillis(clickTimeStamp);
        values[6] = clickDateTime.format(TimeUtil.MILLIS_FORMATTER);

        long srchTimeStamp = Long.valueOf(values[14]) / 1000;
        LocalDateTime srchDateTime = TimeUtil.ofEpochMillis(srchTimeStamp);
        values[14] = srchDateTime.format(TimeUtil.MILLIS_FORMATTER);

        values[20] = LocalDateTime.now().format(TimeUtil.MILLIS_FORMATTER);
    }

    private void initIO(String filePath) {
        try {
            File file = new File(filePath);
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(filePath + " is not exists ...");
        }
    }

    private void closeIOQuietly() {
        if (bufferedReader != null) {
            try {
                bufferedReader.close();
            } catch (IOException e) {
            }
        }
    }
}
