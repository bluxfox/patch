package model;

import utils.JsonUtils;
import utils.StringsUtils;

/**
 * Created by mad-man on 2017/8/13.
 */
public class SectionStats {
    private Integer sectionId;
    private String sectionName;
    private Integer sectionNum;
    private Double minTicketPrice;
    private Double maxTicketPrice;
    private Double averageTicketPrice;
    private Integer maxTicketQuantity;
    private Integer totalTickets;
    private Integer totalListings;
    private Integer zoneId;
    private String zoneName;
    private Integer isGA;
//            "percentiles": [
//    {
//        "name": 95,
//            "value": 157.79999999999998
//    }
//    ],
    private Price minTicketPriceWithCurrency;
    private Price averageTicketPriceWithCurrency;
    private Price maxTicketPriceWithCurrency;

    public SectionStats() {
    }

    public Integer getSectionId() {
        return sectionId;
    }

    public void setSectionId(Integer sectionId) {
        this.sectionId = sectionId;
    }

    public String getSectionName() {
        return sectionName;
    }

    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
        this.sectionNum = StringsUtils.matchNumber(sectionName);
    }

    public Integer getSectionNum() {
        return sectionNum;
    }

    public Double getMinTicketPrice() {
        return minTicketPrice;
    }

    public void setMinTicketPrice(Double minTicketPrice) {
        this.minTicketPrice = minTicketPrice;
    }

    public Double getMaxTicketPrice() {
        return maxTicketPrice;
    }

    public void setMaxTicketPrice(Double maxTicketPrice) {
        this.maxTicketPrice = maxTicketPrice;
    }

    public Double getAverageTicketPrice() {
        return averageTicketPrice;
    }

    public void setAverageTicketPrice(Double averageTicketPrice) {
        this.averageTicketPrice = averageTicketPrice;
    }

    public Integer getMaxTicketQuantity() {
        return maxTicketQuantity;
    }

    public void setMaxTicketQuantity(Integer maxTicketQuantity) {
        this.maxTicketQuantity = maxTicketQuantity;
    }

    public Integer getTotalTickets() {
        return totalTickets;
    }

    public void setTotalTickets(Integer totalTickets) {
        this.totalTickets = totalTickets;
    }

    public Integer getTotalListings() {
        return totalListings;
    }

    public void setTotalListings(Integer totalListings) {
        this.totalListings = totalListings;
    }

    public Integer getZoneId() {
        return zoneId;
    }

    public void setZoneId(Integer zoneId) {
        this.zoneId = zoneId;
    }

    public String getZoneName() {
        return zoneName;
    }

    public void setZoneName(String zoneName) {
        this.zoneName = zoneName;
    }

    public Integer getIsGA() {
        return isGA;
    }

    public void setIsGA(Integer isGA) {
        this.isGA = isGA;
    }

    public Price getMinTicketPriceWithCurrency() {
        return minTicketPriceWithCurrency;
    }

    public void setMinTicketPriceWithCurrency(Price minTicketPriceWithCurrency) {
        this.minTicketPriceWithCurrency = minTicketPriceWithCurrency;
    }

    public Price getAverageTicketPriceWithCurrency() {
        return averageTicketPriceWithCurrency;
    }

    public void setAverageTicketPriceWithCurrency(Price averageTicketPriceWithCurrency) {
        this.averageTicketPriceWithCurrency = averageTicketPriceWithCurrency;
    }

    public Price getMaxTicketPriceWithCurrency() {
        return maxTicketPriceWithCurrency;
    }

    public void setMaxTicketPriceWithCurrency(Price maxTicketPriceWithCurrency) {
        this.maxTicketPriceWithCurrency = maxTicketPriceWithCurrency;
    }
    @Override
    public String toString() {
        return JsonUtils.toJson(this);
    }
}
