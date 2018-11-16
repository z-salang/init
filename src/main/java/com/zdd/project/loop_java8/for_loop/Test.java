package com.zdd.project.loop_java8.for_loop;

import com.google.common.collect.Lists;

/**
 * <p>
 *
 * @author <a href="zdd109067@alibaba-inc.com">zhoudongdong</a>
 * @version create on 2017/10/16 下午3:58
 */
public class Test {

  public static void main(String[] args) {
    Article article = new Article("finance","zdd", Lists.newArrayList("111", "222"));

    //getFirstJavaArticle(article);

  }

  //public static Article getFirstJavaArticle(Article articles) {
  //  return articles(article -> article.getTags().contains("Java")).findFirst();
  //}

}
