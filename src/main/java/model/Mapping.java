package model;

import utils.JsonUtils;

/**
 * Created by mad-man on 2017/8/13.
 */
public class Mapping {

    private String section_name;
    private Integer section_min;
    private Integer section_max;
    private Integer row_min;
    private Integer row_max;
    private Integer price_level;
    private Integer buy_percentage;
    private Integer month;
    private Integer day;
    private Integer year;
    private PatchUrl url;
    private String event_description;
    private String ticketsnow_url;
    private String tx_url;
    private String venue;
    private String state;
    private String home_team;

    public Mapping() {
    }

    public String getSection_name() {
        return section_name;
    }

    public void setSection_name(String section_name) {
        this.section_name = section_name;
    }

    public Integer getSection_min() {
        return section_min;
    }

    public void setSection_min(Integer section_min) {
        this.section_min = section_min;
    }

    public Integer getSection_max() {
        return section_max;
    }

    public void setSection_max(Integer section_max) {
        this.section_max = section_max;
    }

    public Integer getRow_min() {
        return row_min;
    }

    public void setRow_min(Integer row_min) {
        this.row_min = row_min;
    }

    public Integer getRow_max() {
        return row_max;
    }

    public void setRow_max(Integer row_max) {
        this.row_max = row_max;
    }

    public Integer getPrice_level() {
        return price_level;
    }

    public void setPrice_level(Integer price_level) {
        this.price_level = price_level;
    }

    public Integer getBuy_percentage() {
        return buy_percentage;
    }

    public void setBuy_percentage(Integer buy_percentage) {
        this.buy_percentage = buy_percentage;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Integer getDay() {
        return day;
    }

    public void setDay(Integer day) {
        this.day = day;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public PatchUrl getUrl() {
        return url;
    }

    public void setUrl(PatchUrl url) {
        this.url = url;
    }

    public String getEvent_description() {
        return event_description;
    }

    public void setEvent_description(String event_description) {
        this.event_description = event_description;
    }

    public String getTicketsnow_url() {
        return ticketsnow_url;
    }

    public void setTicketsnow_url(String ticketsnow_url) {
        this.ticketsnow_url = ticketsnow_url;
    }

    public String getTx_url() {
        return tx_url;
    }

    public void setTx_url(String tx_url) {
        this.tx_url = tx_url;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getHome_team() {
        return home_team;
    }

    public void setHome_team(String home_team) {
        this.home_team = home_team;
    }

    @Override
    public String toString() {
        return JsonUtils.toJson(this);
    }
}
