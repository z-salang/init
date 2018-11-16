package com.zdd.project.loop_java8.for_loop;

import java.util.List;

/**
 * <p>
 *
 * @author <a href="zdd109067@alibaba-inc.com">zhoudongdong</a>
 * @version create on 2017/10/16 下午3:58
 */
public class Article {
  private final String title;
  private final String author;
  private final List<String> tags;

  public Article(String title, String author, List<String> tags) {
    this.title = title;
    this.author = author;
    this.tags = tags;
  }

  public String getTitle() {
    return title;
  }

  public String getAuthor() {
    return author;
  }

  public List<String> getTags() {
    return tags;
  }
}
