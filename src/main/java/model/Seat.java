package model;

import utils.JsonUtils;

/**
 * Created by mad-man on 2017/8/13.
 */
public class Seat {
    private String seatNumber;
    private Long listingId;
    private String row;
    private Integer isGA;

    public Seat() {
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public Long getListingId() {
        return listingId;
    }

    public void setListingId(Long listingId) {
        this.listingId = listingId;
    }

    public String getRow() {
        return row;
    }

    public void setRow(String row) {
        this.row = row;
    }

    public Integer getIsGA() {
        return isGA;
    }

    public void setIsGA(Integer isGA) {
        this.isGA = isGA;
    }
    @Override
    public String toString() {
        return JsonUtils.toJson(this);
    }
}
