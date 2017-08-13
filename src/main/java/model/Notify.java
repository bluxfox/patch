package model;

import utils.JsonUtils;

/**
 * Created by mad-man on 2017/8/13.
 */
public class Notify {

    private String time;
    private String eventDesc;
    private String sectionName;
    private String R;
    private String Q;
    private String price;
    private String percent;
    private String eventId;
    private String spidar;
    private String eventURL;
    private String checkOutURL;
    private String saleRecordURL;
    private String showInStubhubURL;
    private String mapping;

    public Notify() {
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getSectionName() {
        return sectionName;
    }

    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }

    public String getEventDesc() {
        return eventDesc;
    }

    public void setEventDesc(String eventDesc) {
        this.eventDesc = eventDesc;
    }

    public String getR() {
        return R;
    }

    public void setR(String r) {
        R = r;
    }

    public String getQ() {
        return Q;
    }

    public void setQ(String q) {
        Q = q;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPercent() {
        return percent;
    }

    public void setPercent(String percent) {
        this.percent = percent;
    }

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public String getSpidar() {
        return spidar;
    }

    public void setSpidar(String spidar) {
        this.spidar = spidar;
    }

    public String getEventURL() {
        return eventURL;
    }

    public void setEventURL(String eventURL) {
        this.eventURL = eventURL;
    }

    public String getCheckOutURL() {
        return checkOutURL;
    }

    public void setCheckOutURL(String checkOutURL) {
        this.checkOutURL = checkOutURL;
    }

    public String getSaleRecordURL() {
        return saleRecordURL;
    }

    public void setSaleRecordURL(String saleRecordURL) {
        this.saleRecordURL = saleRecordURL;
    }

    public String getShowInStubhubURL() {
        return showInStubhubURL;
    }

    public void setShowInStubhubURL(String showInStubhubURL) {
        this.showInStubhubURL = showInStubhubURL;
    }

    public String getMapping() {
        return mapping;
    }

    public void setMapping(String mapping) {
        this.mapping = mapping;
    }

    @Override
    public String toString() {
        return JsonUtils.toJson(this);
    }
}
