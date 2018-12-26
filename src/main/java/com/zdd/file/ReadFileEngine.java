package com.zdd.file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * <p>
 *
 * @author <a href="zdd109067@alibaba-inc.com">zhoudongdong</a>
 * @version create on 2018/9/19 ??7:12
 */
public class ReadFileEngine {

    private static final String SINGLE_QUOTES = "'";
    private static final String COMMA = ",";

    private static final String SQL_INSERT_TITLE = "insert into charged_log20181226(account_id,element_id,business,charge_id,price,type,charge_version,product,occur_time,created_on) values";

    private static final int BLOB_SIZE = 500;

    private FileReader fileReader;
    private BufferedReader bufferedReader;

    private FileWriter fileWriter;
    private BufferedWriter bufferedWriter;

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
        StringBuilder stringBuilder = buildSqlStatement();

        int blobCounter = 1;
        String line;
        while (null != (line = bufferedReader.readLine())) {
            if (blobCounter > BLOB_SIZE) {
                String wholeSql = stringBuilder.toString().substring(0, stringBuilder.length() - 1) + ";";
                bufferedWriter.write(wholeSql);
                bufferedWriter.newLine();

                stringBuilder = buildSqlStatement();
                blobCounter=1;
            }

            String sqlValue = transToSQLValue(line);
            stringBuilder.append(sqlValue);
            ++blobCounter;
        }

        String wholeSql = stringBuilder.toString().substring(0, stringBuilder.length() - 1) + ";";
        bufferedWriter.write(wholeSql);
        bufferedWriter.newLine();
        bufferedWriter.flush();
    }

    private StringBuilder buildSqlStatement() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(SQL_INSERT_TITLE);
        return stringBuilder;
    }

    private String transToSQLValue(String line) {
        String[] values = line.split("\t");
        convert(values);
        return toSqlValue(values);
    }

    private String toSqlValue(String[] values) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("(");
        for (int i = 0; i < values.length; ++i) {
            String value = values[i];

            if (i == 2 || i == 5 || i == 7 || i == 9) {
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
//        values[0] = String.valueOf(UnsignedAndSignedTrans.unsignedToSigned(values[2])); // srch_id
//        values[1] = String.valueOf(UnsignedAndSignedTrans.unsignedToSigned(values[1])); // click_id
//
//        long clickTimeStamp = Long.valueOf(values[6]) / 1000;
//        LocalDateTime clickDateTime = TimeUtil.ofEpochMillis(clickTimeStamp);
//        values[6] = clickDateTime.format(TimeUtil.MILLIS_FORMATTER);
//
//        long srchTimeStamp = Long.valueOf(values[14]) / 1000;
//        LocalDateTime srchDateTime = TimeUtil.ofEpochMillis(srchTimeStamp);
//        values[14] = srchDateTime.format(TimeUtil.MILLIS_FORMATTER);
//
//        values[20] = LocalDateTime.now().format(TimeUtil.MILLIS_FORMATTER);
    }

    private void initIO(String filePath) {
        try {
            File file = new File(filePath);
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);

            File outFile = new File(file.getParent() + "/" + "blob_insert.sql");
            fileWriter = new FileWriter(outFile);
            bufferedWriter = new BufferedWriter(fileWriter);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(filePath + " is not exists ...");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void closeIOQuietly() {
        if (bufferedReader != null) {
            try {
                bufferedReader.close();
            } catch (IOException e) {
            }
        }

        if (bufferedWriter != null) {
            try {
                bufferedWriter.close();
            } catch (IOException e) {

            }
        }
    }
}
