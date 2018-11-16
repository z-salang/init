package com.zdd.project.utils.qps;

/**
 * <p>
 *
 * @author <a href="zdd109067@alibaba-inc.com">zhoudongdong</a>
 * @version create on 2017/11/5 下午4:57
 */

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class QpsControl {

  /**
   * 接受请求窗口
   */
  private Long[] accessWindow;
  /**
   * 窗口大小
   */
  private int maxSize;
  /**
   * 指针位置
   */
  private int curPosition;
  /**
   * 时间间隔
   */
  private long interval;

  public QpsControl(int maxSize, int interval, TimeUnit timeUnit) {
    if (maxSize < 0) {
      throw new IllegalArgumentException("Illegal Capacity: " + maxSize);
    }
    curPosition = 0;
    this.interval = timeUnit.toMillis(interval);
    this.maxSize = maxSize;
    accessWindow = new Long[maxSize];
    Arrays.fill(accessWindow, 0L);
  }

  public synchronized boolean isPass() {
    long curTime = System.currentTimeMillis();

    if (curTime - accessWindow[curPosition] >= interval) {
      accessWindow[curPosition++] = curTime;
      curPosition = curPosition % maxSize;
      return true;
    } else {
      return false;
    }
  }
}
