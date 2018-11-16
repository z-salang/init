package com.zdd.project.io.serialize.entities;

/**
 * <p>
 *
 * @author <a href="zdd109067@alibaba-inc.com">zhoudongdong</a>
 * @version create on 2018/2/27 ??11:56
 */
public class ChargeEventEntity implements ChargeEvent {

    private static final long serialVersionUID = 6897383109164340061L;

    private long chargeId;
    private long eventId;
    private long accountId;
    private String product;

    @Override
    public long getChargeId() {
        return chargeId;
    }

    public void setChargeId(long chargeId) {
        this.chargeId = chargeId;
    }

    @Override
    public void setEventId(long eventId) {
        this.eventId = eventId;
    }

    @Override
    public long getEventId() {
        return eventId;
    }

    @Override
    public long getAccountId() {
        return accountId;
    }

    public void setAccountId(long accountId) {
        this.accountId = accountId;
    }

    @Override
    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "ChargeEventEntity{" +
                "chargeId=" + chargeId +
                ", eventId=" + eventId +
                ", accountId=" + accountId +
                ", product='" + product + '\'' +
                '}';
    }
}
