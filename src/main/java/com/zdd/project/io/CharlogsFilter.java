package com.zdd.project.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;

/**
 * <p>
 *
 * @author <a href="zdd109067@alibaba-inc.com">zhoudongdong</a>
 * @version create on 2017/8/7 下午4:44
 */
public class CharlogsFilter {

  private static FileReader fileReader;
  private static FileWriter clickFileWriter;
  private static FileWriter showFileWriter;
  private static BufferedReader bufferedReader;
  private static BufferedWriter clickBufferedWriter;
  private static BufferedWriter showBufferedWriter;

  private static HashSet<Integer> set = new HashSet<>();

  private static final String CLICK_ALTER = "alter table %s modify click_time timestamp(3) NOT NULL DEFAULT '2000-01-01 00:00:00' COMMENT '点击发生时间',\n"
      + "modify click_time_local timestamp(3) NOT NULL DEFAULT '2000-01-01 00:00:00' COMMENT '转换后点击发生时间',\n"
      + "modify srch_time timestamp(3) NOT NULL DEFAULT '2000-01-01 00:00:00' COMMENT '搜索发生时间',\n"
      + "modify srch_time_local timestamp(3) NOT NULL DEFAULT '2000-01-01 00:00:00' COMMENT '转换后搜索发生时间',\n"
      + "modify show_time timestamp(3) NOT NULL DEFAULT '2000-01-01 00:00:00' COMMENT '展现发生时间',\n"
      + "modify show_time_local timestamp(3) NOT NULL DEFAULT '2000-01-01 00:00:00' COMMENT '转换后展现发生时间';\n";

  private static final String SHOW_ALTER = "alter table %s modify srch_time timestamp(3) NOT NULL DEFAULT '2000-01-01 00:00:00' COMMENT '搜索发生时间',\n"
      + "modify srch_time_local timestamp(3) NOT NULL DEFAULT '2000-01-01 00:00:00' COMMENT '转换后搜索发生时间',\n"
      + "modify show_time timestamp(3) NOT NULL DEFAULT '2000-01-01 00:00:00' COMMENT '展现发生时间',\n"
      + "modify show_time_local timestamp(3) NOT NULL DEFAULT '2000-01-01 00:00:00' COMMENT '转换后展现发生时间';\n";

  public static void main(String[] args) throws IOException {
    fileReader = new FileReader(new File("/Users/zdd/temp/charge_tables.cp"));
    bufferedReader = new BufferedReader(fileReader);

    clickFileWriter = new FileWriter("/Users/zdd/temp/sql/click-chargelog-modify.sql");
    clickBufferedWriter = new BufferedWriter(clickFileWriter);

    showFileWriter = new FileWriter("/Users/zdd/temp/sql/show-chargelog-modify.sql");
    showBufferedWriter = new BufferedWriter(showFileWriter);

    String line;

    int clickNum = 0;
    int clickFileSuffix = 0;

    int showNum = 0;
    int showFileSuffix = 0;

    while ((line = bufferedReader.readLine()) != null) {

      System.out.println("clickNum=" + clickNum +"; clickFileSuffix="+clickFileSuffix + ";showNum=" + showNum + ";showFileSuffix=" + showFileSuffix);

      if (line.startsWith("click")) {
        line = String.format(CLICK_ALTER, line);

        if (clickNum > 67) {
          clickBufferedWriter.flush();

          String path = "/Users/zdd/temp/sql/click-chargelog-modify-%s.sql";


          String fileName = String.format(path, ++clickFileSuffix);

          clickFileWriter = new FileWriter(fileName);
          clickBufferedWriter = new BufferedWriter(clickFileWriter);

          clickBufferedWriter.write(line);
          clickBufferedWriter.newLine();

          clickNum = 0;
        } else {
          ++clickNum;
          clickBufferedWriter.write(line);
          clickBufferedWriter.newLine();
        }

      } else {
        line = String.format(SHOW_ALTER, line);

        if (showNum > 100) {
          showBufferedWriter.flush();

          String path = "/Users/zdd/temp/sql/show-chargelog-modify-%s.sql";
          String fileName = String.format(path, ++showFileSuffix);

          showFileWriter = new FileWriter(fileName);
          showBufferedWriter = new BufferedWriter(showFileWriter);

          showBufferedWriter.write(line);
          showBufferedWriter.newLine();

          showNum = 0;
        } else {
          ++showNum;
          showBufferedWriter.write(line);
          showBufferedWriter.newLine();
        }

      }
    }

    showBufferedWriter.flush();
    clickBufferedWriter.flush();

    if (bufferedReader != null) {
      bufferedReader.close();
    }

    if (fileReader != null) {
      fileReader.close();
    }

    if (clickBufferedWriter != null) {
      clickBufferedWriter.close();
    }

    if (clickFileWriter != null) {
      clickFileWriter.close();
    }

    if (showBufferedWriter != null) {
      showBufferedWriter.close();
    }

    if (showFileWriter != null) {
      showFileWriter.close();
    }
  }

}
