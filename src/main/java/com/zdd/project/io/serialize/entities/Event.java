package com.zdd.project.io.serialize.entities;

import java.io.Serializable;

/**
 * <p>
 *
 * @author <a href="zdd109067@alibaba-inc.com">zhoudongdong</a>
 * @version create on 2018/2/27 ??11:53
 */
public interface Event extends Serializable {

    void setEventId(long eventId);

    long getEventId();

    long getAccountId();

    String getProduct();
}
