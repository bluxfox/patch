package model;

import com.sun.deploy.util.StringUtils;
import utils.JsonUtils;

/**
 * Created by mad-man on 2017/8/13.
 */
public class PatchUrl {

    private String originUrl;
    private String eventPath;
    private String eventId;

    public PatchUrl() {
    }

    public PatchUrl(String originUrl) {
        this.originUrl = originUrl;
        String[] splits = StringUtils.splitString(originUrl, "/");
        this.eventPath = splits[2];
        this.eventId = splits[4];
    }

    public String getOriginUrl() {
        return originUrl;
    }

    public void setOriginUrl(String originUrl) {
        this.originUrl = originUrl;
    }

    public String getEventPath() {
        return eventPath;
    }

    public void setEventPath(String eventPath) {
        this.eventPath = eventPath;
    }

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    @Override
    public String toString() {
        return JsonUtils.toJson(this);
    }
}
