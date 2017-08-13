package excutors;

import model.EventData;
import model.SectionStats;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.util.EntityUtils;
import utils.HttpClientUtils;
import utils.JsonUtils;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mad-man on 2017/8/12.
 */
public class PatchEventData {
    static Integer errorCounter = 0 ;
    private String eventId;
    private String sectionIdList;
    private Integer total;
    private Integer totalPage;

    public PatchEventData() {
    }

    public PatchEventData(String eventId, String sectionIdList) {
        this.eventId = eventId;
        this.sectionIdList = sectionIdList;
    }

    public List<SectionStats> getSectionStats(){
        EventData eventData = getEventDate(0);
        if(eventData != null && eventData.getSectionStats() != null && eventData.getSectionStats().size() > 0){
            return eventData.getSectionStats();
        }
        return null;
    }

    public List<EventData> getTotalEventData() throws InterruptedException {
        List<EventData> totalEventData = new ArrayList<EventData>();
        //第一页
        EventData eachEventData = getEventDate(0);
        if (eachEventData != null) {
            totalEventData.add(eachEventData);
            this.total = eachEventData.getTotalListings();
            this.totalPage = total % 20 == 0 ? (total / 20) : ((total / 20) + 1);
            int halfPage = totalPage / 2;
            int lastPage = totalPage;

            //中间页
            if (halfPage > 0) {
                eachEventData = getEventDate(halfPage * 20);
                if (eachEventData != null) {
                    totalEventData.add(eachEventData);
                }
            }

            if(lastPage - 2 > 0 && lastPage - 2 != halfPage){
                //倒数第二页
                eachEventData = getEventDate((lastPage - 2) * 20);
                if (eachEventData != null) {
                    totalEventData.add(eachEventData);
                }
            }
            //最后一页
            eachEventData = getEventDate((lastPage - 1) * 20);
            if (eachEventData != null) {
                totalEventData.add(eachEventData);
            }
        }
        return totalEventData;

    }

    public EventData getEventDate(Integer start){
        HttpResponse response = null;
        try {
            HttpGet httpGet = HttpClientUtils.getHttpGet(eventId, sectionIdList, start);
            response = HttpClientUtils.getHttpClient().execute(httpGet);
            int status = response.getStatusLine().getStatusCode(); //状态码
            HttpEntity entity = response.getEntity();
            if(status == 200){
                if (entity != null) {
                    String json = EntityUtils.toString(entity);
                    System.out.println("OK");
                    EventData eventData = (EventData) JsonUtils.toObj(json, EventData.class);
                    return eventData;
                } else {
                    errorCounter ++;
                    System.out.println("HttpClient execute error, response is empty." + ",errorCount=" + errorCounter);
                }
            } else {
                errorCounter ++;
                System.out.println("HttpClient execute error, status = " + status + ",errorCount=" + errorCounter);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (KeyManagementException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public String getSectionIdList() {
        return sectionIdList;
    }

    public void setSectionIdList(String sectionIdList) {
        this.sectionIdList = sectionIdList;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    @Override
    public String toString() {
        return "PatchEventData{" +
                "eventId='" + eventId + '\'' +
                ", sectionIdList='" + sectionIdList + '\'' +
                ", total=" + total +
                ", totalPage=" + totalPage +
                '}';
    }
}
