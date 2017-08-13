package strategy;

/**
 * Created by mad-man on 2017/8/12.
 */
public class AnalysisStrategy {
    private Double percent;
    public boolean isMatch(StrategyRule strategyRule){
        if(strategyRule.getPercent() <= percent){
            return true;
        } else {
            return false;
        }
    }

    public AnalysisStrategy() {
    }

    public AnalysisStrategy(Double percent) {
        this.percent = percent;
    }

    public Double getPercent() {
        return percent;
    }

    public void setPercent(Double percent) {
        this.percent = percent;
    }
}
