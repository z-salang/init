package com.zdd.project.io.files;

import java.io.File;
import java.io.IOException;

/**
 * <p>
 *
 * @author <a href="zdd109067@alibaba-inc.com">zhoudongdong</a>
 * @version create on 2017/9/5 下午6:03
 */
public class TestCreateFile {

  public static void main(String[] args) throws IOException {
    String filePath = "/Users/zdd";
    String fileName = "chargelog-success";
    String successFile = filePath + "/" + fileName;

    File file = new File(successFile);
    if (!file.exists()) {
      System.out.println("chargelog-success does not exist .., start to create the file.");
      file.createNewFile();
    } else {
      System.out.println("chargelog-success has exist ...");
      file.renameTo(new File(filePath + "/" + "aaaaaaaaaaa.txt"));
    }
  }
}
