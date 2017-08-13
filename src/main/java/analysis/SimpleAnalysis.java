package analysis;

import com.google.common.collect.Collections2;
import model.EventData;
import model.Listing;
import model.SectionStats;
import strategy.AnalysisStrategy;
import strategy.StrategyRule;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by mad-man on 2017/8/12.
 */
public class SimpleAnalysis {

    public static boolean analysisBySectionStat(SectionStats sectionStat, AnalysisStrategy strategy){
        Double minPrice = sectionStat.getMinTicketPrice();
        Double averagePrice = sectionStat.getAverageTicketPrice();
        if(minPrice / averagePrice <= strategy.getPercent()){
            return true;
        }
        return false;
    }


    public static void analysis(List<EventData> eventDatas, AnalysisStrategy strategy){

        Double priceSum = 0.0;
        Double minPrice = 0.0;
        Integer counter = 0;
        String eventId = null;
        String sectionName = null;
        Integer minPriceStart = 0;
        for(EventData each : eventDatas){
            List<Listing> listings = each.getListing();
            eventId = each.getEventId() + "";
            if(listings != null && listings.size() > 0){
                for(Listing eachLising : listings){
                    Double price = eachLising.getPrice().getAmount();
                    priceSum += price;
                    if(minPrice == 0 || minPrice > price){
                        minPrice = price;
                        minPriceStart = each.getStart();
                    }
                    counter ++;
                }
            } else {
              System.out.println("listing 为空。eventId=" + each.getEventId() + ",start=" + each.getStart());
            }
        }

        Double averagePrice = priceSum / counter;
        Double percent = minPrice / averagePrice;
        if(strategy.isMatch(new StrategyRule(percent))){
            //TODO： notify by email.
            System.out.println("找到符合要求的票了，eventId=" + eventId + ",start=" + minPriceStart + ",minPrice=" + minPrice +",averagePrice=" + averagePrice + ",percent=" + percent);
        } else {
            System.out.println("不符合要求的票，eventId=" + eventId + ",start=" + minPriceStart + ",minPrice=" + minPrice +",averagePrice=" + averagePrice + ",percent=" + percent);
        }
    }
}
