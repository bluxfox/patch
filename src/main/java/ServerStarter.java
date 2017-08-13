import analysis.SimpleAnalysis;
import excutors.PatchEventData;
import model.*;
import strategy.AnalysisStrategy;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by mad-man on 2017/8/12.
 */
public class ServerStarter {

    static ConcurrentHashMap<String, Integer> sectionMap = new ConcurrentHashMap<String, Integer>();
    static ConcurrentHashMap<String, SectionStats> sectionStatMap = new ConcurrentHashMap<String, SectionStats>();
    public static void main(String[] args) throws InterruptedException {

        String patchUrl = "http://www.stubhub.com/buffalo-bills-tickets-buffalo-bills-orchard-park-new-era-field-9-9-2017/event/9818947";
        Mapping mapping1= new Mapping();
        mapping1.setSection_min(133);
        mapping1.setSection_max(134);
        mapping1.setRow_min(1);
        mapping1.setRow_max(9);
        mapping1.setPrice_level(1);
        mapping1.setBuy_percentage(65);
        mapping1.setMonth(8);
        mapping1.setDay(31);
        mapping1.setYear(2017);
        mapping1.setUrl(new PatchUrl(patchUrl));
        mapping1.setEvent_description("Lions@Bills Preseason");
        mapping1.setVenue("New Era Field");
        mapping1.setState("NY");
        mapping1.setHome_team("Bills");

        PatchEventData patchEventData = new PatchEventData();
        patchEventData.setEventId("9708708");
        String sectionName = "Grandstand Outfield 413";
        while(true){

            List<SectionStats> sectionStatses = patchEventData.getSectionStats();
            if(sectionStatses != null){
                for(SectionStats each : sectionStatses){
                    sectionMap.put(each.getSectionName(), each.getSectionId());
                    sectionStatMap.put(each.getSectionName(), each);
                    System.out.println(each.getSectionId() + ":" + each.getSectionName());
                }
            }
            SectionStats sectionStats = sectionStatMap.get(sectionName);
            SimpleAnalysis analysis = new SimpleAnalysis();
            if(analysis.analysisBySectionStat(sectionStats, new AnalysisStrategy(0.9))){
                patchEventData.setSectionIdList(sectionMap.get(sectionName) +"");
                EventData eventData = patchEventData.getEventDate(0);
                Listing listing = eventData.getListing().get(0);
                Long listingId = listing.getSeats().get(0).getListingId();
                System.out.println("找到符合条件的票了,minPrice="+ sectionStats.getMinTicketPrice() +",averagePrice = "+ sectionStats.getAverageTicketPrice() + ",price=" + listing.getPrice().getAmount()+listing.getPrice().getCurrency() +",listingId=" + listingId);

                //TODO: notify
                break;
            }
            Thread.sleep(1000 * 5);
        }

    }
}
