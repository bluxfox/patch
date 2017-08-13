package model;

import utils.JsonUtils;

import java.util.List;

/**
 * Created by mad-man on 2017/8/12.
 */
public class Listing {
    private boolean multipleListing;
    private Price price;
    private Integer sectionId;
    private String sectionName;
    private boolean dirtyTicketInd;
    private Integer zoneId;
    private String zoneName;
    private List<Seat> seats;
    public Listing() {
    }

    public boolean isMultipleListing() {
        return multipleListing;
    }

    public void setMultipleListing(boolean multipleListing) {
        this.multipleListing = multipleListing;
    }

    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
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
    }

    public boolean isDirtyTicketInd() {
        return dirtyTicketInd;
    }

    public void setDirtyTicketInd(boolean dirtyTicketInd) {
        this.dirtyTicketInd = dirtyTicketInd;
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

    public List<Seat> getSeats() {
        return seats;
    }

    public void setSeats(List<Seat> seats) {
        this.seats = seats;
    }

    @Override
    public String toString() {
        return JsonUtils.toJson(this);
    }
}
