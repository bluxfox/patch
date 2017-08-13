package model;

import utils.JsonUtils;

import java.util.List;

/**
 * Created by mad-man on 2017/8/12.
 */
public class EventData {

    private Long eventId;
    private Integer totalListings;
    private Integer totalTickets;
    private Integer start;
    private Integer rows;
    private List<Listing> listing;
    private List<SectionStats> sectionStats;
    public EventData() {
    }

    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    public Integer getTotalListings() {
        return totalListings;
    }

    public void setTotalListings(Integer totalListings) {
        this.totalListings = totalListings;
    }

    public Integer getTotalTickets() {
        return totalTickets;
    }

    public void setTotalTickets(Integer totalTickets) {
        this.totalTickets = totalTickets;
    }

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public Integer getRows() {
        return rows;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }

    public List<Listing> getListing() {
        return listing;
    }

    public void setListing(List<Listing> listing) {
        this.listing = listing;
    }

    public List<SectionStats> getSectionStats() {
        return sectionStats;
    }

    public void setSectionStats(List<SectionStats> sectionStats) {
        this.sectionStats = sectionStats;
    }

    @Override
    public String toString() {
        return JsonUtils.toJson(this);
    }
}
