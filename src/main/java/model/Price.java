package model;

import utils.JsonUtils;

/**
 * Created by mad-man on 2017/8/12.
 */
public class Price {
    private double amount;
    private String currency;

    public Price() {
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @Override
    public String toString() {
        return JsonUtils.toJson(this);
    }
}
